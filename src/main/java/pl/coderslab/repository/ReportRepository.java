package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.model.Report;

import java.time.LocalDateTime;
import java.util.List;

public interface ReportRepository extends JpaRepository<Report,Long> {
    List<Report> findAllByCreatedTimeBetweenOrderByShop(LocalDateTime start, LocalDateTime end);
}
