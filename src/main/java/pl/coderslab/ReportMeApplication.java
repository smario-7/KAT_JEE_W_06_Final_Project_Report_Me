package pl.coderslab;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.coderslab.config.SecurityConfig;

@SpringBootApplication
public class ReportMeApplication implements CommandLineRunner {


    public static void main(String[] args) {
        SpringApplication.run(ReportMeApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("test");
    }
}
