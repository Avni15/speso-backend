package appnivi.products.speso.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import appnivi.products.speso.model.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Integer>{

}
