package pl.coderslab.service;

import pl.coderslab.beans.Report;
import pl.coderslab.dto.ReportDto;
import pl.coderslab.dto.ReportEditDto;
import pl.coderslab.dto.ReportReadDto;
import org.springframework.stereotype.Service;
import pl.coderslab.repository.ReportRepository;
import pl.coderslab.repository.ShopRepository;
import pl.coderslab.repository.UserRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReportService implements ReportMeService{
    private final ReportRepository reportRepository;
    private final UserRepository userRepository;
    private final ShopRepository shopRepository;

    public ReportService(ReportRepository reportRepository, UserRepository userRepository, ShopRepository shopRepository) {
        this.reportRepository = reportRepository;
        this.userRepository = userRepository;
        this.shopRepository = shopRepository;
    }

    public void add(ReportDto reportDto) {
        Report newRepost = new Report();
        Long shopId = 1L;
        Long userId = 1L;
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
        newRepost.setUser(userRepository.findById(userId).orElseThrow(EntityNotFoundException::new));
        newRepost.setShop(shopRepository.findById(shopId).orElseThrow(EntityNotFoundException::new));
        reportRepository.save(newRepost);
    }

    public void update(ReportEditDto reportEditDto) {
        Report newReport = reportRepository.findById(reportEditDto.getId()).orElseThrow(EntityNotFoundException::new);
//        Report newReport = new Report();
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
    public List<ReportReadDto> findAll() {
        return reportRepository.findAll()
                .stream()
                .map(report -> new ReportReadDto(report.getId(), report.getUser().getFirstName(), report.getShop().getShopName(), report.getContract(),
                        report.getAnnex(), report.getBusinessToBusiness(), report.getHeandset(), report.getPlay360(),
                        report.getTelevision(), report.getUpSaleOnTheSameDay(), report.getTeleSales(),
                        report.getDisplayProtection(),report.getAccessories())
                    )
                .collect(Collectors.toList());

    }

    public ReportEditDto findById(Long id) {
         Report report = reportRepository.findById(id).orElseThrow(EntityNotFoundException::new);
         return new ReportEditDto(report.getId(), report.getContract(), report.getAnnex(), report.getBusinessToBusiness(),
                 report.getHeandset(), report.getPlay360(), report.getTelevision(), report.getUpSaleOnTheSameDay(),
                 report.getTeleSales(), report.getDisplayProtection(), report.getAccessories(), report.getCreatedTime(),
                 report.getCreatedTime());
    }

}
