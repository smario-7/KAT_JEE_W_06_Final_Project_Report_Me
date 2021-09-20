package pl.coderslab.service;

import pl.coderslab.dto.ReportDto;
import pl.coderslab.dto.ReportEditDto;
import pl.coderslab.dto.ReportReadDto;

import java.util.List;


public interface ReportMeService {
    void add (ReportDto reportDto) throws Exception;
    List<ReportReadDto> findAll();
    ReportEditDto findById(Long id);
    void update(ReportEditDto reportEditDto);
}
