package com.app.mobilpymes.shoppingcart.dto;

import com.app.mobilpymes.shoppingcart.entity.CartItem;
import com.app.mobilpymes.shoppingcart.entity.Customer;

import java.util.Date;
import java.util.List;

public
class CheckOutDto {
    public
    Customer customer;
    public String sessionId;
    public String status;
    public
    List < CartItem > cartItem;
    public Date dateCreateChechout;
}
