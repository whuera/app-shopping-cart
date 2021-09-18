package com.app.mobilpymes.shoppingcart.controllers;

import com.app.mobilpymes.shoppingcart.entity.Customer;
import com.app.mobilpymes.shoppingcart.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/customer")
public
class CustomerController {

    @Autowired
    private
    CustomerService customerService;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public
    ResponseEntity < Customer > createCustomer (@Valid @RequestBody Customer customer, BindingResult result) {
        Customer customerCreate = customerService.createCustomer ( customer );
        return ResponseEntity.status ( HttpStatus.CREATED ).body ( customerCreate );
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/customers")
    public
    ResponseEntity < List < Customer > > getAllCustomers ( ) {
        return ResponseEntity.ok ( customerService.listAllCustomer ( ) );
    }
}
