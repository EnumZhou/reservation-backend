package com.company.reservation.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long customer_id;
    private String address_line_one;
    private String address_line_two;
    private String city;
    private String state;
    private String postal;

    @ManyToOne
    @JoinColumn(name="customer_id",insertable = false,updatable = false)
    private Customer customer;

}
