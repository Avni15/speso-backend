package appnivi.products.speso.model;

import java.util.Set;

import javax.persistence.CascadeType;
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
@Table(name = "expense_soochi_mapper")
public class ExpenseSoochiMapper {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer Id;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "expense_id", nullable = false)
	@JsonBackReference
	Expense expenseMapper;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "soochi", nullable = false)
	@JsonBackReference
	Soochi soochiMapper;

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public Expense getExpenseMapper() {
		return expenseMapper;
	}

	public void setExpenseMapper(Expense expenseMapper) {
		this.expenseMapper = expenseMapper;
	}

	public Soochi getSoochiMapper() {
		return soochiMapper;
	}

	public void setSoochiMapper(Soochi soochiMapper) {
		this.soochiMapper = soochiMapper;
	}


//	
//	@OneToMany(mappedBy = "expense", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	@JsonManagedReference
//	Set<Expense> expenses;
//	@OneToMany(mappedBy = "soochi", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	@JsonManagedReference
//	Set<Soochi> soochi;

}
