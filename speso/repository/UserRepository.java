package appnivi.products.speso.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import appnivi.products.speso.model.ExpenseUsers;

public interface UserRepository extends JpaRepository<ExpenseUsers, Integer> {

	@Query(value = "select * from expense_users where email=:email", nativeQuery = true)
	ExpenseUsers findByEmail(String email);

	@Query(value = "select * from expense_users where code=:userCode",nativeQuery = true)
	ExpenseUsers findByCode(String userCode);
}
