package appnivi.products.speso.request;

public class AddExpenseInSoochiRequest {
	String userCode;
	String name;
	String description;
	String amount;
	String type;
	String category;
	String soochiCode;
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
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
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getSoochiCode() {
		return soochiCode;
	}
	public void setSoochiCode(String soochiCode) {
		this.soochiCode = soochiCode;
	}
	
	
}
