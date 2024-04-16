package com.example.rockbitetaskex.service;

import com.example.rockbitetaskex.model.User;

import java.util.List;

public interface UserService {

    User getById(Long id);

    void save(User user);

    void delete(Long id);

    List<User> getAll();

    User updateCustomer(User customer);

}
