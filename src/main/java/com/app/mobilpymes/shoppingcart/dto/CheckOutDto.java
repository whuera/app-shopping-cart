package com.app.mobilpymes.shoppingcart.dto;

import com.app.mobilpymes.shoppingcart.entity.CartItem;
import com.app.mobilpymes.shoppingcart.entity.Customer;

import java.util.Date;

public
class CheckOutDto {
    private
    Customer customer;
    private String sessionId;
    private String status;
    private
    CartItem cartItem;
    private Date dateCreateChechout;
}
