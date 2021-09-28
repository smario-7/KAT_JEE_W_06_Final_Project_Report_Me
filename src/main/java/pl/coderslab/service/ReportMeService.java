package pl.coderslab.service;

import pl.coderslab.dto.ReportDto;
import pl.coderslab.dto.ReportEditDto;
import pl.coderslab.dto.ReportReadDto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


public interface ReportMeService {
    void add (ReportDto reportDto) throws Exception;
    List<ReportReadDto> findAllSortedByShopAndMonth(LocalDateTime start, LocalDateTime end);
    ReportEditDto findById(Long id);
    void update(ReportEditDto reportEditDto);
    LocalDate dateNow();
}
