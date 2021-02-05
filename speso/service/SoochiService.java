package appnivi.products.speso.service;

import appnivi.products.speso.request.AddSoochiRequest;
import appnivi.products.speso.request.EditSoochiRequest;
import appnivi.products.speso.response.Response;

public interface SoochiService {

	Response addSoochi(AddSoochiRequest request);

	Response editSoochi(EditSoochiRequest request);

	Response deleteSoochi(String soochiId, String userCode);

	Response fetchAllSoochiOfUser(String userCode);

	Response fetchAllSoochiOfUserByMonth(String userCode);

	Response openSoochi(String soochiId, String userCode);

	Response closeSoochi(String soochiId, String userCode);

	
}
