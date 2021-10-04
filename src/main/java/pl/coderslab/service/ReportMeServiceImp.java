package pl.coderslab.service;

import org.springframework.stereotype.Service;
import pl.coderslab.dto.ReportDto;
import pl.coderslab.dto.ReportEditDto;
import pl.coderslab.dto.ReportReadDto;
import pl.coderslab.model.Report;
import pl.coderslab.repository.ReportRepository;
import pl.coderslab.repository.ShopRepository;
import pl.coderslab.repository.UserRepository;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReportMeServiceImp implements ReportMeService{
    private final ReportRepository reportRepository;
    private final UserRepository userRepository;
    private final ShopRepository shopRepository;

    public ReportMeServiceImp(ReportRepository reportRepository, UserRepository userRepository, ShopRepository shopRepository) {
        this.reportRepository = reportRepository;
        this.userRepository = userRepository;
        this.shopRepository = shopRepository;
    }

    public LocalDate dateNow (){
        return LocalDate.now();
    }

    public void add(ReportDto reportDto) {
        Report newRepost = new Report();
//        Long shopId = 1L;
//        Long userId = 1L;
        newRepost.setContract(reportDto.getContract());
        newRepost.setAnnex(reportDto.getAnnex());
        newRepost.setBusinessToBusiness(reportDto.getBusinessToBusiness());
        newRepost.setHeandset(reportDto.getHandset());
        newRepost.setPlay360(reportDto.getPlay360());
        newRepost.setTelevision(reportDto.getTelevision());
        newRepost.setUpSaleOnTheSameDay(reportDto.getUpSaleOnTheSameDay());
        newRepost.setTeleSales(reportDto.getTeleSales());
        newRepost.setDisplayProtection(reportDto.getDisplayProtection());
        newRepost.setAccessories(reportDto.getAccessories());
        newRepost.setUser(userRepository.findByEmail(reportDto.getUser()));
        newRepost.setShop(userRepository.findByEmail(reportDto.getUser()).getShop());
        reportRepository.save(newRepost);
    }

    public void update(ReportEditDto reportEditDto) {
        Report newReport = reportRepository.findById(reportEditDto.getId()).orElseThrow(EntityNotFoundException::new);
        newReport.setId(reportEditDto.getId());
        newReport.setContract(reportEditDto.getContract());
        newReport.setAnnex(reportEditDto.getAnnex());
        newReport.setBusinessToBusiness(reportEditDto.getBusinessToBusiness());
        newReport.setHeandset(reportEditDto.getHeandset());
        newReport.setPlay360(reportEditDto.getPlay360());
        newReport.setTelevision(reportEditDto.getTelevision());
        newReport.setUpSaleOnTheSameDay(reportEditDto.getUpSaleOnTheSameDay());
        newReport.setTeleSales(reportEditDto.getTeleSales());
        newReport.setDisplayProtection(reportEditDto.getDisplayProtection());
        newReport.setAccessories(reportEditDto.getAccessories());

        reportRepository.save(newReport);
    }
    public List<ReportReadDto> findAllSortedByShopAndMonth(LocalDateTime start, LocalDateTime end) {
        return reportRepository.findAllByCreatedTimeBetweenOrderByShop(start, end)
                .stream()
                .map(report -> new ReportReadDto(report.getId(), report.getUser().getFirstName(), report.getShop().getShopName(), report.getContract(),
                        report.getAnnex(), report.getBusinessToBusiness(), report.getHeandset(), report.getPlay360(),
                        report.getTelevision(), report.getUpSaleOnTheSameDay(), report.getTeleSales(),
                        report.getDisplayProtection(),report.getAccessories(), report.getCreatedTime().toLocalDate())
                    )
                .collect(Collectors.toList());

    }

    public ReportEditDto findById(Long id) {
         Report report = reportRepository.findById(id).orElseThrow(EntityNotFoundException::new);
         return new ReportEditDto(report.getId(), report.getContract(), report.getAnnex(), report.getBusinessToBusiness(),
                 report.getHeandset(), report.getPlay360(), report.getTelevision(), report.getUpSaleOnTheSameDay(),
                 report.getTeleSales(), report.getDisplayProtection(), report.getAccessories());
    }

}
