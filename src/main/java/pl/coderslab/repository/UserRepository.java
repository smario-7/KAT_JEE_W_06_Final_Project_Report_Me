package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.model.ReportUser;

public interface UserRepository extends JpaRepository<ReportUser, Long> {
    ReportUser findByEmail(String email);
}
