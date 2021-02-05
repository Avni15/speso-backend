package appnivi.products.speso.serviceimpl;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import appnivi.products.speso.model.ExpenseUsers;
import appnivi.products.speso.model.TemporaryUsers;
import appnivi.products.speso.repository.TemporaryUserRepository;
import appnivi.products.speso.repository.UserRepository;
import appnivi.products.speso.request.LoginUserRequest;
import appnivi.products.speso.request.RegisterUserRequest;
import appnivi.products.speso.request.VerifyUserRequest;
import appnivi.products.speso.response.Response;
import appnivi.products.speso.service.UserService;
import appnivi.products.speso.utility.CodeGenerator;
import appnivi.products.speso.utility.DateUtils;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	Response response;
	@Autowired
	CodeGenerator codeGenerator;
	@Autowired
	DateUtils dateUtils;
	@Autowired
	UserRepository userRepository;
	@Autowired
	TemporaryUserRepository temporaryUserRepository;
	@Autowired
	private JavaMailSender mailSender;

	@Override
	public Response registerUser(RegisterUserRequest request) {
		ExpenseUsers expenseUser = userRepository.findByEmail(request.getEmail());
		if(expenseUser!=null)
		{
			response.setError(true);
			response.setMessage("User already registered");
			response.setResponse(null);
			return response;
		}
		TemporaryUsers temporaryUser = temporaryUserRepository.findByEmail(request.getEmail());
		if(temporaryUser!=null)
		{
			temporaryUser.setOtp("1234");
			try {
	    			MimeMessage mimeMessage = mailSender.createMimeMessage();
	        		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
	                helper.setTo(request.getEmail());
	                helper.setSubject("Speso - OTP Verification");
	                helper.setText("Hello, please verify your OTP. Your OTP is "+ "1234",true);
	                helper.setFrom((new InternetAddress("teams@appnivi.com","Appnivi")).toString());
	                mailSender.send(mimeMessage);
	                System.out.print("mail sent");
			}catch(Exception e) {
	    		System.out.println("Error in sending mail");
	    	}
			temporaryUser.setName(request.getName());
			temporaryUser.setPassword(request.getPassword());
			temporaryUserRepository.save(temporaryUser);
			response.setError(false);
			response.setMessage("User registered. Please verfiy otp.");
			response.setResponse(temporaryUser);
			return response;
		}
		TemporaryUsers user = new TemporaryUsers();
		user.setPassword(request.getPassword());
		user.setName(request.getName());
		user.setEmail(request.getEmail());
		user.setOtp("0000");
		user.setCreatedAt(dateUtils.getCurrentDate());
		user.setModifiedAt(null);
		TemporaryUsers saved = temporaryUserRepository.save(user);
		if (saved == null) {
			response.setError(true);
			response.setMessage("User is unable to register");
			response.setResponse(null);
		} 
		else 
		{
			response.setError(false);
			response.setMessage("User registered successfully. Verify OTP sent to your mail!");
			response.setResponse(saved);
			try {
    			MimeMessage mimeMessage = mailSender.createMimeMessage();
        		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
                helper.setTo(request.getEmail());
                helper.setSubject("Speso - OTP Verification");
                helper.setText("Hello, please verify your OTP. Your OTP is "+ "0000",true);
                helper.setFrom((new InternetAddress("teams@appnivi.com","Appnivi")).toString());
                mailSender.send(mimeMessage);
                System.out.print("mail sent");
		}catch(Exception e) {
    		System.out.println("Error in sending mail");
    	}
		}
		return response;
	}

	@Override
	public Response verifyOtp(VerifyUserRequest request) {
		TemporaryUsers temporaryUser = temporaryUserRepository.findByEmail(request.getEmail());
		if (temporaryUser != null) {
			String otp = temporaryUser.getOtp();

			if (otp.equals(request.getOtp())) {
				ExpenseUsers user = new ExpenseUsers();
				user.setName(temporaryUser.getName());
				user.setEmail(temporaryUser.getEmail());
				user.setPhoneNumber(null);
				user.setPassword(temporaryUser.getPassword());
				user.setCode(codeGenerator.genrateCode(temporaryUser.getName()));
				user.setCreatedAt(dateUtils.getCurrentDate());
				user.setModifiedAt(null);
				ExpenseUsers saved = userRepository.save(user);
				if (saved == null) {
					response.setError(true);
					response.setMessage("Something went wrong, could not verify the OTP!");
					response.setResponse(null);
				} else {
					temporaryUserRepository.delete(temporaryUser);
					response.setError(false);
					response.setMessage("User email verified successfully. You may log in now!");
					response.setResponse(saved);
				}
			} else {
				response.setError(true);
				response.setMessage("Incorrect OTP. Request a new one!");
				response.setResponse(null);
			}
		} else {
			response.setError(true);
			response.setMessage("Please register first.");
			response.setResponse(null);
		}
		return response;
	}

	@Override
	public Response loginUser(LoginUserRequest request) {
		ExpenseUsers user = userRepository.findByEmail(request.getEmail());
		if (user == null) {
			response.setError(false);
			response.setMessage("User Not found");
			response.setResponse(null);
		} else {
			if(user.getPassword().equals(request.getPassword())) {
				response.setError(false);
				response.setMessage("User found");
				response.setResponse(user);
			}else {
				response.setError(true);
				response.setMessage("Wrong Credentials");
				response.setResponse(null);
			}
			
		}
		return response;
	}

}
