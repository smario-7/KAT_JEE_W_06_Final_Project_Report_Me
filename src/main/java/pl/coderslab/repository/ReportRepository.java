package pl.coderslab.repository;

import pl.coderslab.model.Report;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRepository extends JpaRepository<Report,Long> {
}
