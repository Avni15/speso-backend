package appnivi.products.speso.model;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "expense")
public class Expense extends BaseModel{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer Id;

	@Column(name = "code", nullable = false)
	String code;

	@Column(name = "name", nullable = false)
	String name;

	@Column(name = "description", nullable = false)
	String description;

	@Column(name = "amount", nullable = false)
	String amount;

	

	@Column(name = "type", nullable = false)
	String type;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "user_id", nullable = false)
	@JsonBackReference
	ExpenseUsers user;

	@OneToMany(mappedBy = "expenseMapper", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonManagedReference
	Set<ExpenseSoochiMapper> expense;
	
	@Column(name = "category_id", nullable = false)
	String category_id;

	public Set<ExpenseSoochiMapper> getExpense() {
		return expense;
	}

	public void setExpense(Set<ExpenseSoochiMapper> expense) {
		this.expense = expense;
	}

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

	public ExpenseUsers getUser() {
		return user;
	}

	public void setUser(ExpenseUsers user) {
		this.user = user;
	}

	public String getCategory_id() {
		return category_id;
	}

	public void setCategory_id(String category_id) {
		this.category_id = category_id;
	}
	
	

}
