package com.example.enumtest.service;

import com.example.enumtest.model.business.User;
import com.example.enumtest.model.entity.UserEntity;

import java.util.List;

public interface UserService {
    User save(User user);

    List<User> findAll();

    User deleteById(Integer id);

    UserEntity findByIdEntity(Integer id);

    User findById(Integer id);
}
