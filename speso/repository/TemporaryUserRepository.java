package appnivi.products.speso.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import appnivi.products.speso.model.TemporaryUsers;

public interface TemporaryUserRepository extends JpaRepository<TemporaryUsers, Integer>{

	@Query(value = "select * from temporary_users where email=:email", nativeQuery = true)
	TemporaryUsers findByEmail(String email);

}
