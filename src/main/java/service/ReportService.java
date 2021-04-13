package service;

import beans.Report;
import beans.Shop;
import beans.User;
import dto.ReportDto;
import dto.ReportReadDto;
import org.springframework.stereotype.Service;
import repository.ReportRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReportService {
    private final ReportRepository reportRepository;

    public ReportService(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    public void add(ReportDto reportDto) {
        Report newRepost = new Report();
        User userId = new User();
        userId.setId(1L);
        Shop shopId = new Shop();
        shopId.setId(1L);
        newRepost.setContract(reportDto.getContract());
        newRepost.setAnnex(reportDto.getAnnex());
        newRepost.setBusinessToBusiness(reportDto.getBusinessToBusiness());
        newRepost.setHeandset(reportDto.getHeandset());
        newRepost.setPlay360(reportDto.getPlay360());
        newRepost.setTelevision(reportDto.getTelevision());
        newRepost.setUpSaleOnTheSameDay(reportDto.getUpSaleOnTheSameDay());
        newRepost.setTeleSales(reportDto.getTeleSales());
        newRepost.setDisplayProtection(reportDto.getDisplayProtection());
        newRepost.setAccessories(reportDto.getAccessories());
        newRepost.setUserId(userId);
        newRepost.setShopId(shopId);

        reportRepository.save(newRepost);
    }

    public List<ReportReadDto> findAll() {
        return reportRepository.findAll()
                .stream()
                .map(report -> new ReportReadDto(report.getUserId(), report.getShopId(), report.getContract(),
                        report.getAnnex(), report.getBusinessToBusiness(), report.getHeandset(), report.getPlay360(),
                        report.getTelevision(), report.getUpSaleOnTheSameDay(), report.getTeleSales(),
                        report.getDisplayProtection(),report.getAccessories())
                    )
                .collect(Collectors.toList());

    }
}
