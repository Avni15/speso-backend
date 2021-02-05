package appnivi.products.speso.service;

import org.springframework.stereotype.Service;

import appnivi.products.speso.request.AddExpenseInSoochiRequest;
import appnivi.products.speso.request.AddExpenseRequest;
import appnivi.products.speso.request.EditExpenseRequest;
import appnivi.products.speso.response.Response;

@Service
public interface ExpenseService {

	Response addExpense(AddExpenseRequest request);

	Response addExpenseInSoochi(AddExpenseInSoochiRequest request);

	Response editExpense(EditExpenseRequest request);

	Response deleteExpense(String userCode, String expenseCode);

	Response fetchAllExpenseOfUser(String userCode);

}
