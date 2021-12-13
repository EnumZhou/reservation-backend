package com.company.reservation.dao;

import com.company.reservation.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;
@Repository
public interface AddressDao extends BaseDao<Address> {

}
