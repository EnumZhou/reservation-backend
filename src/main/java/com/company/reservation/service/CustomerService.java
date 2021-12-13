package com.company.reservation.service;

import com.company.reservation.dao.CustomerDao;
import com.company.reservation.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerDao customerDao;

    public List<Customer> findAllCustomers() {
        return customerDao.findAll();
    }
}
