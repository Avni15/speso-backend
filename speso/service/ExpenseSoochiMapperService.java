package appnivi.products.speso.service;

import appnivi.products.speso.model.Expense;
import appnivi.products.speso.model.Soochi;
import appnivi.products.speso.response.Response;

public interface ExpenseSoochiMapperService {
	Response addExpenseInSoochiMapper(Expense expense,Soochi soochi);
}
