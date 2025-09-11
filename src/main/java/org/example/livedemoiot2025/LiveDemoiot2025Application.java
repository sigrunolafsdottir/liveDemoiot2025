package org.example.livedemoiot2025;

import org.example.livedemoiot2025.models.Customer;
import org.example.livedemoiot2025.models.Kpi;
import org.example.livedemoiot2025.repos.CustomerRepo;
import org.example.livedemoiot2025.repos.KpiRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LiveDemoiot2025Application {

    public static void main(String[] args) {
        SpringApplication.run(LiveDemoiot2025Application.class, args);
    }

    @Bean
    public CommandLineRunner createData (KpiRepo kpiRepo, CustomerRepo customerRepo) {
        return args -> {

            /*
            Customer c1 = new Customer("Melody", "mello@fdsf.com", new Kpi(98));
            Customer c2 = new Customer("BUrt", "burt@fdsf.com", new Kpi(33));

            customerRepo.save(c1);
            customerRepo.save(c2);
*/
/*
            Kpi kpi1 = new Kpi(67 );
            Kpi kpi2 = new Kpi(98 );
            Kpi kpi3 = new Kpi(234 );

            kpiRepo.save(kpi1);
            kpiRepo.save(kpi2);
            kpiRepo.save(kpi3);

            Customer c1 = new Customer("Mick", "mick@fdsf.com", kpi1);
            Customer c2 = new Customer("Rianna", "rianna@fdsf.com", kpi2);
            Customer c3 = new Customer("Maple", "maple@fdsf.com", kpi3);

            customerRepo.save(c1);
            customerRepo.save(c2);
            customerRepo.save(c3);
*/

        };
    }





    /*
    @Bean
    public CommandLineRunner createData (BookRepository repo) {
        return args -> {
            repo.save(new Book("Le Seigneur des Anneaux", "J.R.R. Tolkien"));
            repo.save(new Book("1984", "George Orwell"));
            repo.save(new Book("Harry Potter à l'école des sorciers", "J.K. Rowling"));
            repo.save(new Book("Le Petit Prince", "Antoine de Saint-Exupéry"));
        };
    }
*/
}
