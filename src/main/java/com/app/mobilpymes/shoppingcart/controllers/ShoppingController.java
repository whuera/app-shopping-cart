package com.app.mobilpymes.shoppingcart.controllers;

import com.app.mobilpymes.shoppingcart.entity.CartItem;
import com.app.mobilpymes.shoppingcart.entity.Customer;
import com.app.mobilpymes.shoppingcart.services.CartItemsService;
import com.app.mobilpymes.shoppingcart.services.CustomerService;
import com.app.mobilpymes.shoppingcart.utils.ShoppingCartHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api-shopping")
@CrossOrigin
public
class ShoppingController {

    @Autowired
    private
    CartItemsService cartItemsService;

    @Autowired
    private
    CustomerService customerService;

    @GetMapping
    public
    String healthPage ( ) {
        return "Shopping cart status Ok";
    }

    @GetMapping("/cartitems")
    public
    ResponseEntity < List < CartItem > > getShoppingCart (@RequestParam(name = "customerId", required = true) Long customerId) {
        Customer customerBD = customerService.getCustomer ( customerId );
        return ResponseEntity.ok ( cartItemsService.listCartItems ( customerBD ) );
    }

    @PostMapping
    public
    ResponseEntity < CartItem > createCartShopping (@Valid @RequestBody CartItem cartItem, BindingResult result) {
        if ( result.hasErrors ( ) ) {
            throw new ResponseStatusException ( HttpStatus.BAD_REQUEST, ShoppingCartHelper.formatMessage ( result ) );
        }
        CartItem cartItemCreate = cartItemsService.createCartShopping ( cartItem );
        return ResponseEntity.status ( HttpStatus.CREATED ).body ( cartItemCreate );

    }

}
