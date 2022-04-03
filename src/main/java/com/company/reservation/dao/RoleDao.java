package com.company.reservation.dao;

import com.company.reservation.constants.RoleEnum;
import com.company.reservation.entity.Role;

import java.util.Optional;

public interface RoleDao extends BaseDao<Role>{
    Optional<Role> findByName(RoleEnum name);
}


