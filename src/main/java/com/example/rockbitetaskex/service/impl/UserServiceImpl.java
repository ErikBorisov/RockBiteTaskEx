package com.example.rockbitetaskex.service.impl;

import com.example.rockbitetaskex.model.User;
import com.example.rockbitetaskex.repository.UserRepository;
import com.example.rockbitetaskex.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User getById(Long id) {
        log.info("IN CustomerServiceImpl getById {}", id);
        return userRepository.getOne(id);
    }

    @Override
    public void save(User customer) {
        log.info("In CustomerServiceImpl save {}", customer);
        userRepository.save(customer);
    }

    @Override
    public void delete(Long id) {
        log.info("In CustomerServiceImpl delete {}", id);
        userRepository.deleteById(id);
    }

    @Override
    public List<User> getAll() {
        log.info("In CustomerServiceImpl getAll");
        return userRepository.findAll();
    }

    @Override
    public User updateCustomer(User customer) {
        return userRepository.save(customer);
    }
}
