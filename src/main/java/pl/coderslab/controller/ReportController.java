package pl.coderslab.controller;

import pl.coderslab.dto.ReportDto;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.service.ReportService;

@Controller
@RequestMapping("/reportform")
public class ReportController {
    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping
    public String getReport(Model model) {
        model.addAttribute("report", new ReportDto());
        return "reportform";
    }

    @PostMapping
    @ResponseBody
    public String postRaport(ReportDto report){
        reportService.add(report);
        return reportService.findAll().toString();
    }
}
