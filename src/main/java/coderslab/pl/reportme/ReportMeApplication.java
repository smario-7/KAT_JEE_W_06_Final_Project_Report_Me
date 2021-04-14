package coderslab.pl.reportme;

import config.SecurityConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
public class ReportMeApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReportMeApplication.class, args);
    }

}
