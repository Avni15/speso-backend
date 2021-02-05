package appnivi.products.speso.serviceimpl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import appnivi.products.speso.model.Expense;
import appnivi.products.speso.model.ExpenseUsers;
import appnivi.products.speso.model.Soochi;
import appnivi.products.speso.repository.ExpenseRepository;
import appnivi.products.speso.repository.SoochiRepository;
import appnivi.products.speso.repository.UserRepository;
import appnivi.products.speso.request.AddExpenseInSoochiRequest;
import appnivi.products.speso.request.AddExpenseRequest;
import appnivi.products.speso.request.EditExpenseRequest;
import appnivi.products.speso.response.Response;
import appnivi.products.speso.service.ExpenseService;
import appnivi.products.speso.service.ExpenseSoochiMapperService;
import appnivi.products.speso.utility.CodeGenerator;
import appnivi.products.speso.utility.DateUtils;

@Service
public class ExpenseServiceImpl implements ExpenseService {
	@Autowired
	ExpenseRepository expenseRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	Response response;
	@Autowired
	CodeGenerator codeGenerator;
	@Autowired
	DateUtils dateUtils;
	@Autowired
	ExpenseSoochiMapperService expenseSoochiMapperService;
	@Autowired
	SoochiRepository soochiRepository;

	@Override
	public Response addExpense(AddExpenseRequest request) {
		if (userRepository.findByCode(request.getUserCode()) == null) {
			response.setError(true);
			response.setMessage("User does not exists");
			response.setResponse(null);
			return response;
		}
		ExpenseUsers user = userRepository.findByCode(request.getUserCode());
		Expense expense = new Expense();
		expense.setAmount(request.getAmount());
		expense.setCategory_id(request.getCategory());
		expense.setCode(codeGenerator.genrateCode(request.getName()));
		expense.setName(request.getName());
		expense.setCreatedAt(dateUtils.getCurrentDate());
		expense.setDescription(request.getDescription());
		expense.setExpense(null);
		expense.setModifiedAt(null);
		expense.setType("0");
		expense.setUser(user);

		Expense saved = expenseRepository.save(expense);
		if (saved == null) {
			response.setError(true);
			response.setMessage("Unable to add expense");
			response.setResponse(null);
		} else {
			response.setError(false);
			response.setMessage("Expense created");
			response.setResponse(saved);
		}
		return response;
	}

	@Override
	public Response addExpenseInSoochi(AddExpenseInSoochiRequest request) {

		if (userRepository.findByCode(request.getUserCode()) == null) {
			response.setError(true);
			response.setMessage("User does not exists");
			response.setResponse(null);
			return response;
		}
		if (soochiRepository.findByCode(request.getSoochiCode()) == null) {
			response.setError(true);
			response.setMessage("soochi does not exists");
			response.setResponse(null);
			return response;
		}
		ExpenseUsers user = userRepository.findByCode(request.getUserCode());
		Expense expense = new Expense();
		expense.setAmount(request.getAmount());
		expense.setCategory_id(request.getCategory());
		expense.setCode(codeGenerator.genrateCode(request.getName()));
		expense.setCreatedAt(dateUtils.getCurrentDate());
		expense.setDescription(request.getDescription());
		expense.setModifiedAt(null);
		expense.setName(request.getName());
		expense.setType("1");
		expense.setUser(user);
		Expense saved = expenseRepository.save(expense);
		if (saved == null) {
			response.setError(true);
			response.setMessage("expense not saved");
			response.setResponse(null);
			return response;
		}
		Soochi soochi = soochiRepository.findByCode(request.getSoochiCode());
		response = expenseSoochiMapperService.addExpenseInSoochiMapper(expense, soochi);
		if (response.getError()) {
			expenseRepository.delete(saved);
			return response;
		} else {
			response.setError(false);
			response.setMessage("expense created");
			response.setResponse(saved);
			return response;
		}
	}

	@Override
	public Response editExpense(EditExpenseRequest request) {

		return null;
	}

	@Override
	public Response deleteExpense(String userCode, String expenseCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response fetchAllExpenseOfUser(String userCode) {
		if (userRepository.findByCode(userCode) == null) {
			response.setError(true);
			response.setMessage("User does not exists");
			response.setResponse(null);
			return response;
		}
		ExpenseUsers user = userRepository.findByCode(userCode);
		Set<Expense> usersExpenseList = user.getExpenses();
		if (usersExpenseList.isEmpty() || usersExpenseList == null) {
			response.setError(false);
			response.setMessage("No expenses found");
			response.setResponse(usersExpenseList);
			return response;
		} else {
			response.setError(false);
			response.setMessage("Expenses found");
			response.setResponse(usersExpenseList);
			return response;
		}
	}

}
