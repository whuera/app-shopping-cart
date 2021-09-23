package com.app.mobilpymes.shoppingcart.services.impl;

import com.app.mobilpymes.shoppingcart.entity.CartItem;
import com.app.mobilpymes.shoppingcart.entity.Customer;
import com.app.mobilpymes.shoppingcart.repository.CartItemsRepository;
import com.app.mobilpymes.shoppingcart.services.CartItemsService;
import com.app.mobilpymes.shoppingcart.utils.ShoppingCartEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public
class CartItemsServiceImpl implements CartItemsService {

    @Autowired
    private
    CartItemsRepository cartItemsRepository;

    @Override
    public
    List < CartItem > listCartItems (Customer customer) {
        return cartItemsRepository.findByCustomer ( customer );
    }

    @Transactional
    @Override
    public
    CartItem createCartShopping (CartItem cartItem) {
        if ( null != cartItem ) {
            cartItem.setStatusCart ( ShoppingCartEnum.CART_ACTIVE.name ( ) );
            cartItem.setCreateCart ( new Date ( ) );
            CartItem cartItemCreate = cartItemsRepository.save ( cartItem );
            return cartItemCreate;
        } else {
            return null;
        }

    }
}
