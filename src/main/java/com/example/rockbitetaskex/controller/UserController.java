package com.example.rockbitetaskex.controller;

import com.example.rockbitetaskex.model.User;
import com.example.rockbitetaskex.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/controller")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getCustomer(@PathVariable("id") Long id) {
        User user = this.userService.getById(id);

        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> saveCustomer(@RequestBody @Validated User user) {
        HttpHeaders httpHeaders = new HttpHeaders();

        if (user == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        this.userService.save(user);
        return new ResponseEntity<>(user, httpHeaders, HttpStatus.OK);
    }

//    @RequestMapping(value = "", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Customer> updateCustomer(@RequestBody @Validated Customer customer, UriComponentsBuilder builder) {
//        HttpHeaders headers = new HttpHeaders();
//
//        if (customer == null) {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//        this.customerService.save(customer);
//
//        return new ResponseEntity<>(customer, headers, HttpStatus.OK);
//    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> deleteCustomer(@PathVariable("id") Long id) {
        User user = this.userService.getById(id);

        if (user == null) {
            return new ResponseEntity<>((HttpStatus.NOT_FOUND));
        }
        this.userService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = this.userService.getAll();

        if (users.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public User updateCustomer(@PathVariable("id") Long id, @RequestBody User customer) {
        customer.setId(id);
        return userService.updateCustomer(customer);
    }

}
