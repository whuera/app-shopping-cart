package com.app.mobilpymes.shoppingcart.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api-product")
public
class itemController {

    @GetMapping("/item")
    public String getItem (){
        return "item slected";
    }
}
