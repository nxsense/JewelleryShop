package repository;

import entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author author
 * @version 1.0
 */
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
