package appnivi.products.speso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import appnivi.products.speso.request.LoginUserRequest;
import appnivi.products.speso.request.RegisterUserRequest;
import appnivi.products.speso.request.VerifyUserRequest;
import appnivi.products.speso.response.Response;
import appnivi.products.speso.service.UserService;

@RestController
@RequestMapping(path = "/user")
@CrossOrigin(origins = "*")
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("/registerUser")
	public Response registerUser(@RequestBody RegisterUserRequest request) {
		Response response = userService.registerUser(request);
		return response;
	}
	
	@PostMapping("/verifyOtp")
	public Response verifyOtp(@RequestBody VerifyUserRequest request) {
		Response response = userService.verifyOtp(request);
		return response;
	}
	
	@PostMapping("/loginUser")
	public Response loginUser(@RequestBody LoginUserRequest request) {
		Response response = userService.loginUser(request);
		return response;
	}
}
