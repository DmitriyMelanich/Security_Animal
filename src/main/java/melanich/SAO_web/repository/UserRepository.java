package melanich.SAO_web.repository;

import melanich.SAO_web.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {
	public User findByUsername(String username);
}
