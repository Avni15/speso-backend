package appnivi.products.speso.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
@Table(name = "expense_users")
public class ExpenseUsers extends BaseModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer Id;

	@Column(name = "code", nullable = false)
	String code;

	@Column(name = "name", nullable = false)
	String name;

	@Column(name = "phone_number", nullable = true)
	String phoneNumber;

	@Column(name = "email", nullable = false)
	String email;
	
	@Column(name = "password", nullable = false)
	String password;

	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonManagedReference
	Set<Expense> expenses;
	
	@OneToMany(mappedBy = "owner", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonManagedReference
	Set<Soochi> soochi;
	
	
	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Expense> getExpenses() {
		return expenses;
	}

	public void setExpenses(Set<Expense> expenses) {
		this.expenses = expenses;
	}

	public Set<Soochi> getSoochi() {
		return soochi;
	}

	public void setSoochi(Set<Soochi> soochi) {
		this.soochi = soochi;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
