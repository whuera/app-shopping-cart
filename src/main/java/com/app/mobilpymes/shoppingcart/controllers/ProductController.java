package com.app.mobilpymes.shoppingcart.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public
class ProductController {

    @GetMapping
    public
    String healthPage ( ) {
        return "Status Ok";
    }
}
