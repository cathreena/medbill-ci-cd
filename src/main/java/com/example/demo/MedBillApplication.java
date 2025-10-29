package com.example.demo;

import com.example.demo.service.BillService;
import com.example.demo.model.Bill;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MedBillApplication {

    public static void main(String[] args) {
        SpringApplication.run(MedBillApplication.class, args);
    }

    @Bean
    public CommandLineRunner seed(BillService service) {
        return args -> {
            service.addBill(new Bill(1, "John Doe", "X-ray", 2000.50));
            service.addBill(new Bill(2, "Alice Smith", "Consultation", 500.00));
            service.addBill(new Bill(3, "Bob Johnson", "Blood Test", 750.25));
        };
    }
}
