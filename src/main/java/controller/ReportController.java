package controller;

import dto.ReportDto;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.ReportService;

@Controller
@RequestMapping("reportform")
public class ReportController {
    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping
    public String getReport(Model model) {
        model.addAttribute("report", new ReportDto());
        return "resportform";
    }

    @PostMapping
    @ResponseBody
    public String postRaport(ReportDto reportDto){
        reportService.add(reportDto);
        return reportService.findAll().toString();
    }
}
