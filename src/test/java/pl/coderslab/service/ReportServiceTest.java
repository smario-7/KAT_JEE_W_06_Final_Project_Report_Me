package pl.coderslab.service;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import pl.coderslab.beans.Report;
import pl.coderslab.dto.ReportDto;
import pl.coderslab.repository.ReportRepository;
import pl.coderslab.repository.ShopRepository;
import pl.coderslab.repository.UserRepository;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@Ignore("Do poprawy")
class ReportServiceTest {

    ReportRepository reportRepositoryMock = mock(ReportRepository.class);
    UserRepository userRepositoryMock = mock(UserRepository.class);
    ShopRepository shopRepositoryMock = mock(ShopRepository.class);

    @Test
    void shouldAddReportToDatabase() throws Exception {

        //given
        // when
        ReportDto reportDto = new ReportDto(
                1, 2, 3, 4, 5, 6, 7,
                8, 9, 10);

        ReportService reportService = new ReportService(reportRepositoryMock, userRepositoryMock, shopRepositoryMock);

        //when
        reportService.add(reportDto);
        ArgumentCaptor<Report> reportArgumentCaptor = ArgumentCaptor.forClass(Report.class);

        //then
        verify(reportRepositoryMock).save(reportArgumentCaptor.capture());
        Report saveReport = reportArgumentCaptor.getValue();
        assertThat(saveReport).isSameAs(reportDto);

    }


}