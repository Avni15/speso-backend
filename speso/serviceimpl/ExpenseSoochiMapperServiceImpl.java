package appnivi.products.speso.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import appnivi.products.speso.model.Expense;
import appnivi.products.speso.model.ExpenseSoochiMapper;
import appnivi.products.speso.model.Soochi;
import appnivi.products.speso.repository.ExpenseSoochiMapperRepository;
import appnivi.products.speso.response.Response;
import appnivi.products.speso.service.ExpenseSoochiMapperService;

@Service
public class ExpenseSoochiMapperServiceImpl implements ExpenseSoochiMapperService {
	@Autowired
	ExpenseSoochiMapperRepository expenseSoochiMapperRepository;
	@Autowired
	Response response;
	@Override
	public Response addExpenseInSoochiMapper(Expense expense, Soochi soochi) {
		ExpenseSoochiMapper expenseSoochiMapper=new ExpenseSoochiMapper();
		expenseSoochiMapper.setExpenseMapper(expense);
		expenseSoochiMapper.setSoochiMapper(soochi);
		ExpenseSoochiMapper saved=expenseSoochiMapperRepository.save(expenseSoochiMapper);
		if (saved == null) {
			response.setError(true);
			response.setMessage("expense not mapped");
			response.setResponse(null);
		} else {
			response.setError(false);
			response.setMessage("expense mapped");
			response.setResponse(saved);
		}
		return response;
	}

}
