package com.company.reservation;

import com.company.reservation.dao.CustomerDao;
import com.company.reservation.entity.Customer;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerTest {
    @Autowired
    private CustomerDao customerDao;

    @Test
    public void test1() {
        System.out.println("hhhh");
    }

    @Test
    public void findCustomerByPhoneAndLastnameTest() throws Exception {
        Customer customer=customerDao.findByPhoneAndLastname("9292588287","Zhou")
                .orElseThrow(() -> new Exception("Customer Not Found!"));
        System.out.println(customer.getFirstname());
        Assert.assertNotNull(customer);
    }
}
