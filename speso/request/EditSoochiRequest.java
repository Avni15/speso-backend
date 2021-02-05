package appnivi.products.speso.request;

public class EditSoochiRequest {
	String soochiCode;
	String name;
	String description;
	String budget;
	String userCode;

	public String getSoochiCode() {
		return soochiCode;
	}

	public void setSoochiCode(String soochiCode) {
		this.soochiCode = soochiCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getBudget() {
		return budget;
	}

	public void setBudget(String budget) {
		this.budget = budget;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

}
