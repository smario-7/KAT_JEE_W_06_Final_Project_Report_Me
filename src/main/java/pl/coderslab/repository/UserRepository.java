package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.beans.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
