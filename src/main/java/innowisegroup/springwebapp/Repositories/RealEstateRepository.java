package innowisegroup.springwebapp.Repositories;

import innowisegroup.springwebapp.Entities.RealEstate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RealEstateRepository extends JpaRepository<RealEstate,Long>{
}
