package com.company.reservation.service;

import com.company.reservation.dao.AddressDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    @Autowired
    private AddressDao addressDao;
}
