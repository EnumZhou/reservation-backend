package com.company.reservation.dao;

import com.company.reservation.entity.Customer;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerDao extends BaseDao<Customer> {
    Optional<Customer> findByPhoneAndLastname(String phone,String lastname);
}
