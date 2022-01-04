package com.company.reservation.dao;

import com.company.reservation.entity.User;

import java.util.Optional;

public interface UserDao extends BaseDao<User>{
    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}
