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
        log.info("IN UserServiceImpl getById {}", id);
        return userRepository.getOne(id);
    }

    @Override
    public void save(User user) {
        log.info("In UserServiceImpl save {}", user);
        userRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        log.info("In UserServiceImpl delete {}", id);
        userRepository.deleteById(id);
    }

    @Override
    public List<User> getAll() {
        log.info("In UserServiceImpl getAll");
        return userRepository.findAll();
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }
}
