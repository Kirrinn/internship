package org.example;

import lombok.RequiredArgsConstructor;
import org.example.entity.Customer;
import org.example.repos.CustomerRepository;
import org.example.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor

public class SpringBootConsoleApplication implements CommandLineRunner {


    private final CustomerService customerService;

    public static void main(String[] args) {

        SpringApplication.run(SpringBootConsoleApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {

        List<Customer> customers = customerService.findAllandSave();
//        for (Customer customer : customers) {
//            System.out.println(customer.getName());
//        }


        System.out.println("Hello World");
    }
}
