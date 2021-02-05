package appnivi.products.speso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import appnivi.products.speso.request.AddSoochiRequest;
import appnivi.products.speso.request.EditSoochiRequest;
import appnivi.products.speso.response.Response;
import appnivi.products.speso.service.SoochiService;

@RestController
@RequestMapping(path = "/soochi")
@CrossOrigin(origins = "*")
public class SoochiController {
	@Autowired
	SoochiService soochiService;

	@PostMapping(path = "/addSoochi")
	public Response addSoochi(@RequestBody AddSoochiRequest request) {
		Response response = soochiService.addSoochi(request);
		return response;
	}

	@PostMapping(path = "/editSoochi")
	public Response editSoochi(@RequestBody EditSoochiRequest request) {
		Response response = soochiService.editSoochi(request);
		return response;
	}

	@DeleteMapping(path = "/deleteSoochi")
	public Response deleteSoochi(@RequestParam String soochiCode,String userCode) {
		Response response = soochiService.deleteSoochi(soochiCode,userCode);
		return response;
	}
	
	@PostMapping(path = "/closeSoochi")
	public Response closeSoochi(@RequestParam String soochiCode,String userCode) {
		Response response = soochiService.closeSoochi(soochiCode,userCode);
		return response;
	}
	@PostMapping(path = "/openSoochi")
	public Response openSoochi(@RequestParam String soochiCode,String userCode) {
		Response response = soochiService.openSoochi(soochiCode,userCode);
		return response;
	}
	
	@GetMapping(path="/fetchAllSoochiOfUser")
	public Response fetchAllSoochiOfUser(@RequestParam String userCode) {
		Response response = soochiService.fetchAllSoochiOfUser(userCode);
		return response;
	}
	
	@GetMapping(path="/fetchAllSoochiOfUserByMonth")
	public Response fetchAllSoochiOfUserByMonth(@RequestParam String userCode) {
		Response response = soochiService.fetchAllSoochiOfUserByMonth(userCode);
		return response;
	}
}
