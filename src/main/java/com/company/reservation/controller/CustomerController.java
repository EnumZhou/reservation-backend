package com.company.reservation.controller;

import com.company.reservation.annotation.AccessLog;
import com.company.reservation.entity.Customer;
import com.company.reservation.service.CustomerService;
import com.company.reservation.util.MessageResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("customer")
@Slf4j
public class CustomerController extends BaseController {
    @Autowired
    private CustomerService customerService;


    @GetMapping("/all")
    @AccessLog(operation = "Get all Customers")
    public MessageResult getAllCustomers() {
        return success("Successfully",customerService.findAllCustomers());
    }


    @GetMapping("/{id}")
    @AccessLog(operation = "Get specific customer's information")
    public MessageResult findOne(@PathVariable Long id) {

        try {
           return success(customerService.findOne(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return error("Can't find customer");
    }

    @PostMapping("/add")
    @AccessLog(operation = "Post a new customer")
    public MessageResult addCustomer(@RequestBody Customer customer) {
        customerService.addCustomer(customer);
        return success("Successfully added a new customer");
    }
}
