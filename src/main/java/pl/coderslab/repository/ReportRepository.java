package pl.coderslab.repository;

import pl.coderslab.beans.Report;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRepository extends JpaRepository<Report,Long> {
}
