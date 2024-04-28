package thecommerce.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import thecommerce.project.domain.User;

public interface UserRepository extends JpaRepository<User, String> {
}
