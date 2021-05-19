package innowisegroup.springwebapp.repository;

import innowisegroup.springwebapp.model.RealEstate;
import innowisegroup.springwebapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RealEstateRepository extends JpaRepository<RealEstate,Long>{
    List<RealEstate> findByUser(User user);
}
