package com.app.mobilpymes.shoppingcart.services;

import com.app.mobilpymes.shoppingcart.entity.CartItem;
import com.app.mobilpymes.shoppingcart.entity.Customer;

import java.util.List;

public
interface CartItemsService {
    public
    List < CartItem > listCartItems (Customer customer);

    public
    CartItem createCartShopping (CartItem cartItem);
}
