package com.company.reservation.controller;

import com.company.reservation.annotation.AccessLog;
import com.company.reservation.entity.Customer;
import com.company.reservation.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/all")
    @AccessLog(operation = "Get all information of Customers")
    public List<Customer> getAllCustomers() {
        return customerService.findAllCustomers();
    }
}
