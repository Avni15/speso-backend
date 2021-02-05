package appnivi.products.speso.service;

import org.springframework.stereotype.Service;

import appnivi.products.speso.request.LoginUserRequest;
import appnivi.products.speso.request.RegisterUserRequest;
import appnivi.products.speso.request.VerifyUserRequest;
import appnivi.products.speso.response.Response;

@Service
public interface UserService {

	public Response registerUser(RegisterUserRequest request);

	public Response loginUser(LoginUserRequest request);

	public Response verifyOtp(VerifyUserRequest request);

}
