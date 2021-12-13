package com.company.reservation.service;

import com.company.reservation.dao.CustomerDao;
import com.company.reservation.entity.Address;
import com.company.reservation.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CustomerService {
    @Autowired
    private CustomerDao customerDao;

    public List<Customer> findAllCustomers() {
        return customerDao.findAll();
    }

    public Customer findOne(Long id) {
        Optional<Customer> customerOptional = customerDao.findById(id);
        try {
            if(customerOptional.isPresent()) {
                return customerOptional.get();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addCustomer(Customer customer) {
        Customer newCustomer=new Customer();
        newCustomer.setFirstname(customer.getFirstname().trim().toLowerCase());
        newCustomer.setLastname(customer.getLastname().trim().toLowerCase());
        newCustomer.setPhone(customer.getPhone().trim());
        customerDao.save(newCustomer);
    }


}
