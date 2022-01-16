package com.company.reservation.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Builder
@Entity
public class Customer {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstname;
    private String lastname;
    private String phone;
    @OneToMany(mappedBy = "customer_id")
    private Set<Address> addresses;
}
