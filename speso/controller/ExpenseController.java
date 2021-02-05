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

import appnivi.products.speso.request.AddExpenseInSoochiRequest;
import appnivi.products.speso.request.AddExpenseRequest;
import appnivi.products.speso.request.EditExpenseRequest;
import appnivi.products.speso.response.Response;
import appnivi.products.speso.service.ExpenseService;

@RestController
@RequestMapping(path = "/expense")
@CrossOrigin(origins = "*")
public class ExpenseController {

	@Autowired
	ExpenseService expenseService;
	
	
	@PostMapping(path = "/addExpense")
	public Response addExpense(@RequestBody AddExpenseRequest request) {
		Response response = expenseService.addExpense(request);
		return response;
	}
	
	@PostMapping(path = "/addExpenseInSoochi")
	public Response addExpenseInSoochi(@RequestBody AddExpenseInSoochiRequest request) {
		Response response = expenseService.addExpenseInSoochi(request);
		return response;
	}
	
	@GetMapping(path = "/fetchAllExpenseOfUser")
	public Response fetchAllExpenseOfUser(@RequestParam String userCode) {
		Response response = expenseService.fetchAllExpenseOfUser(userCode);
		return response;
	}
	
	@PostMapping(path = "/editExpense")
	public Response editExpense(@RequestBody EditExpenseRequest request) {
		Response response = expenseService.editExpense(request);
		return response;
	}
	
	@DeleteMapping(path = "/deleteExpense")
	public Response deleteExpense(@RequestParam String userCode,String expenseCode) {
		Response response = expenseService.deleteExpense(userCode,expenseCode);
		return response;
	}
	
	
}
