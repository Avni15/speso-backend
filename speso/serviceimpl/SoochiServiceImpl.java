package appnivi.products.speso.serviceimpl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import appnivi.products.speso.model.ExpenseUsers;
import appnivi.products.speso.model.Soochi;
import appnivi.products.speso.repository.SoochiRepository;
import appnivi.products.speso.repository.UserRepository;
import appnivi.products.speso.request.AddSoochiRequest;
import appnivi.products.speso.request.EditSoochiRequest;
import appnivi.products.speso.response.Response;
import appnivi.products.speso.service.SoochiService;
import appnivi.products.speso.utility.CodeGenerator;
import appnivi.products.speso.utility.DateUtils;

@Service
public class SoochiServiceImpl implements SoochiService {
	@Autowired
	UserRepository userRepository;
	@Autowired
	Response response;
	@Autowired
	CodeGenerator codeGenerator;
	@Autowired
	DateUtils dataUtils;
	@Autowired
	SoochiRepository soochiRepository;

	@Override
	public Response addSoochi(AddSoochiRequest request) {
		if (userRepository.findByCode(request.getUserCode()) == null) {
			response.setError(true);
			response.setMessage("User does not exists");
			response.setResponse(null);
			return response;
		}
		ExpenseUsers user = userRepository.findByCode(request.getUserCode());
		Soochi soochi = new Soochi();
		soochi.setBudget(request.getBudget());
		soochi.setCode(codeGenerator.genrateCode(request.getName()));
		soochi.setCreatedAt(dataUtils.getCurrentDate());
		soochi.setModifiedAt(null);
		soochi.setIsClosed("0");
		soochi.setExpensemapper(null);
		soochi.setOwner(user);
		soochi.setDescription(request.getDescription());
		soochi.setName(request.getName());
		Soochi saved = soochiRepository.save(soochi);
		if (saved == null) {
			response.setError(true);
			response.setMessage("soochi not saved");
			response.setResponse(null);
		} else {
			response.setError(false);
			response.setMessage("soochi created");
			response.setResponse(saved);
		}
		return response;
	}

	@Override
	public Response editSoochi(EditSoochiRequest request) {
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
		Soochi soochi = soochiRepository.findByCode(request.getSoochiCode());
		soochi.setBudget(request.getBudget());
		soochi.setDescription(request.getDescription());
		soochi.setName(request.getName());
		soochi.setModifiedAt(dataUtils.getCurrentDate());
		Soochi saved = soochiRepository.save(soochi);
		if (saved == null) {
			response.setError(true);
			response.setMessage("soochi not updated");
			response.setResponse(null);
		} else {
			response.setError(false);
			response.setMessage("soochi updated");
			response.setResponse(saved);
		}
		return response;
	}

	@Override
	public Response deleteSoochi(String soochiId, String userCode) {
		if (userRepository.findByCode(userCode) == null) {
			response.setError(true);
			response.setMessage("User does not exists");
			response.setResponse(null);
			return response;
		}
		if (soochiRepository.findByCode(soochiId) == null) {
			response.setError(true);
			response.setMessage("soochi does not exists");
			response.setResponse(null);
			return response;
		}
		try {
			soochiRepository.delete(soochiRepository.findByCode(soochiId));
			response.setError(false);
			response.setMessage("soochi deleted");
			response.setResponse(null);
			return response;
		} catch (Exception e) {
			response.setError(true);
			response.setMessage("soochi not deleted");
			response.setResponse(null);
			return response;
		}
	}

	@Override
	public Response fetchAllSoochiOfUser(String userCode) {
		if (userRepository.findByCode(userCode) == null) {
			response.setError(true);
			response.setMessage("User does not exists");
			response.setResponse(null);
			return response;
		}
		ExpenseUsers user = userRepository.findByCode(userCode);
		Set<Soochi> usersSoochiList = user.getSoochi();
		if (usersSoochiList.isEmpty() || usersSoochiList == null) {
			response.setError(false);
			response.setMessage("no soochi found");
			response.setResponse(usersSoochiList);
			return response;
		} else {
			response.setError(false);
			response.setMessage("soochi found");
			response.setResponse(usersSoochiList);
			return response;
		}
	}

	@Override
	public Response fetchAllSoochiOfUserByMonth(String userCode) {
		if (userRepository.findByCode(userCode) == null) {
			response.setError(true);
			response.setMessage("User does not exists");
			response.setResponse(null);
			return response;
		}
		response.setError(false);
		response.setMessage("not implemented");
		response.setResponse(null);
		return response;
	}

	@Override
	public Response openSoochi(String soochiId, String userCode) {
		if (userRepository.findByCode(userCode) == null) {
			response.setError(true);
			response.setMessage("User does not exists");
			response.setResponse(null);
			return response;
		}
		if (soochiRepository.findByCode(soochiId) == null) {
			response.setError(true);
			response.setMessage("soochi does not exists");
			response.setResponse(null);
			return response;
		}
		Soochi soochi = soochiRepository.findByCode(soochiId);
		soochi.setIsClosed("false");
		Soochi saved = soochiRepository.save(soochi);
		if (saved == null) {
			response.setError(true);
			response.setMessage("soochi not updated");
			response.setResponse(null);
		} else {
			response.setError(false);
			response.setMessage("soochi updated");
			response.setResponse(saved);
		}
		return response;
	}

	@Override
	public Response closeSoochi(String soochiId, String userCode) {
		if (userRepository.findByCode(userCode) == null) {
			response.setError(true);
			response.setMessage("User does not exists");
			response.setResponse(null);
			return response;
		}
		if (soochiRepository.findByCode(soochiId) == null) {
			response.setError(true);
			response.setMessage("soochi does not exists");
			response.setResponse(null);
			return response;
		}
		Soochi soochi = soochiRepository.findByCode(soochiId);
		soochi.setIsClosed("true");
		Soochi saved = soochiRepository.save(soochi);
		if (saved == null) {
			response.setError(true);
			response.setMessage("soochi not updated");
			response.setResponse(null);
		} else {
			response.setError(false);
			response.setMessage("soochi updated");
			response.setResponse(saved);
		}
		return response;

	}

}
