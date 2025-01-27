package org.example.service;


import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.example.entity.Customer;
import org.example.repos.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

@Transactional
public class CustomerService {

    private final CustomerRepository customerRepository;

    public List<Customer> findAllandSave() {

        //napravi novu listu i radi sa njom
        List<Customer> customers1 =  customerRepository.findAll().stream()
                .map(cs -> new Customer(cs.getId(),cs.getName(),cs.getBirthYear()))
                .toList();

        for(Customer customer : customers1) {
            if(customer.getName().equals("Test3")){
                customer.setName("KOsata");
            }
        }
        customerRepository.saveAll(customers1) ;
        return null;
    }
}
