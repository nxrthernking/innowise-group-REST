package innowisegroup.springwebapp.Repositories;

import innowisegroup.springwebapp.Entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository  extends JpaRepository<Role,Long> {
}
