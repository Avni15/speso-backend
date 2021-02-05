package appnivi.products.speso.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import appnivi.products.speso.model.Soochi;

public interface SoochiRepository extends JpaRepository<Soochi, Integer> {
	@Query(value="select * from soochi where code=:soochiCode",nativeQuery=true)
	Soochi findByCode(String soochiCode);


}
