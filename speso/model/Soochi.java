package appnivi.products.speso.model;

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
@Table(name = "soochi")
public class Soochi extends BaseModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer Id;

	@Column(name = "code", nullable = false)
	String code;

	@Column(name = "name", nullable = false)
	String name;

	@Column(name = "description", nullable = false)
	String description;

	@Column(name = "budget", nullable = false)
	String budget;

	@Column(name = "is_closed", nullable = false)
	String isClosed;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "owner_id", nullable = false)
	@JsonBackReference
	ExpenseUsers owner;
	
	
	@OneToMany(mappedBy = "soochiMapper", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonManagedReference
	Set<ExpenseSoochiMapper> expensemapper;

	public Set<ExpenseSoochiMapper> getExpensemapper() {
		return expensemapper;
	}

	public void setExpensemapper(Set<ExpenseSoochiMapper> expensemapper) {
		this.expensemapper = expensemapper;
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

	public String getBudget() {
		return budget;
	}

	public void setBudget(String budget) {
		this.budget = budget;
	}

	public String getIsClosed() {
		return isClosed;
	}

	public void setIsClosed(String isClosed) {
		this.isClosed = isClosed;
	}

	public ExpenseUsers getOwner() {
		return owner;
	}

	public void setOwner(ExpenseUsers owner) {
		this.owner = owner;
	}


}
