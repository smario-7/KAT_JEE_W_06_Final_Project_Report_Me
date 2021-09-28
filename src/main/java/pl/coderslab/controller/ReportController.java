package pl.coderslab.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.coderslab.dto.ReportDto;
import pl.coderslab.dto.ReportEditDto;
import pl.coderslab.service.CurrentUser;
import pl.coderslab.service.ReportMeService;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.Map;


@Controller
@RequestMapping("/report")
public class ReportController {
    private final ReportMeService reportMeService;

    public ReportController(ReportMeService reportMeService) {
        this.reportMeService = reportMeService;
    }

    @GetMapping("/form")
    public String getReport(Model model) {
        model.addAttribute("report", new ReportDto());
        return "report/formReport";
    }

    @PostMapping("/form")
    public String postRaport(@ModelAttribute("report") @Valid ReportDto report, BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()){
            return "report/formReport";
        }
        reportMeService.add(report);
        return "redirect:/report/view";
    }

    @GetMapping("/view")
    public ModelAndView viewReportNow() {
        ModelAndView modelAndView = new ModelAndView("report/viewReport");
        LocalDate dateNow = LocalDate.now();
        modelAndView.addAllObjects(Map.of("reports", reportMeService.findAllSortedByShopAndMonth(
                dateNow.withDayOfMonth(1).atTime(00,00),
                dateNow.withDayOfMonth(dateNow.lengthOfMonth()).atTime(23,59) )));
        return modelAndView;
    }
    @GetMapping(value = "/view", params = "date")
    public ModelAndView viewReport(@RequestParam LocalDate date){
        ModelAndView modelAndView = new ModelAndView("report/viewReport");
        modelAndView.addAllObjects(Map.of("reports", reportMeService.findAllSortedByShopAndMonth(
                date.withDayOfMonth(1).atTime(00,00),
                date.withDayOfMonth(date.lengthOfMonth()).atTime(23,59))));
        return modelAndView;
    }

    @GetMapping(value = "/edit", params = "id")
    public String editRaport(@RequestParam Long id, Model model){
        ReportEditDto reportEditDto = reportMeService.findById(id);
        model.addAttribute("reportEditDto", reportEditDto);
        return "report/editReport";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String saveEditReport (@ModelAttribute("reportEditDto") @Valid ReportEditDto reportEditDto, BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()) {
            return "report/editReport";
        }
        reportMeService.update(reportEditDto);
        return "redirect:/report/view";

    }

    @ModelAttribute("headername")
    public String headerName(){
        return "Raporty";
    }

    @ModelAttribute("basicUserData")
    public String[] basicUserData(@AuthenticationPrincipal CurrentUser currentUser) {
        return new String[]{currentUser.getUsername(), currentUser.getUser().getFirstName(), currentUser.getUser().getShop().getShopName()};
    }



}
