package org.example.livedemoiot2025.controllers;


import org.example.livedemoiot2025.models.Customer;
import org.example.livedemoiot2025.models.Kpi;
import org.example.livedemoiot2025.repos.CustomerRepo;
import org.example.livedemoiot2025.repos.KpiRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    private CustomerRepo repo;
    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    public CustomerController(CustomerRepo repository) {
        this.repo = repository;
    }


    @RequestMapping("/customer")
    public List<Customer> getALlBooks(){
        return repo.findAll();
    }

    @RequestMapping("/customer/{id}")
    public Customer getCustomerById(@PathVariable Long id){
        return repo.findById(id).get();
    }



    @RequestMapping("/customer/delete/{id}")
    public List<Customer> deleteCustomerById(@PathVariable Long id){
        repo.deleteById(id);
        return repo.findAll();
    }

    @PostMapping("/customer/add")
    public List<Customer> addCustomer(@RequestBody Customer b){
        repo.save(b);
        return repo.findAll();
    }


}
