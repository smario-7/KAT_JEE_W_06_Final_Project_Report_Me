package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.model.ReportUser;

import java.util.List;

public interface UserRepository extends JpaRepository<ReportUser, Long> {
    ReportUser findByEmail(String email);
    boolean existsByEmail(String email);
    List<ReportUser> findAllByOrderByShop();
}
