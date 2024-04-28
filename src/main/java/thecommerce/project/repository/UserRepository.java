package thecommerce.project.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import thecommerce.project.domain.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, String> {

}
