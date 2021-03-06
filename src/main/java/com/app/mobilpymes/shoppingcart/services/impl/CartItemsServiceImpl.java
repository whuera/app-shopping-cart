package com.app.mobilpymes.shoppingcart.services.impl;

import com.app.mobilpymes.shoppingcart.dto.CheckOutDto;
import com.app.mobilpymes.shoppingcart.entity.CartItem;
import com.app.mobilpymes.shoppingcart.entity.Customer;
import com.app.mobilpymes.shoppingcart.repository.CartItemsRepository;
import com.app.mobilpymes.shoppingcart.repository.CustomerRepository;
import com.app.mobilpymes.shoppingcart.services.CartItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public
class CartItemsServiceImpl implements CartItemsService {

    @Autowired
    private
    CartItemsRepository cartItemsRepository;

    @Autowired
    private
    CustomerRepository customerRepository;

    @Override
    public
    List < CartItem > listCartItems (Customer customer) {
        return cartItemsRepository.findByCustomer ( customer );
    }

    @Transactional
    @Override
    public
    CartItem createCartShopping (CartItem cartItem) {
       /* if ( null != cartItem ) {
            cartItem.setStatusCart ( ShoppingCartEnum.CART_ACTIVE.name ( ) );
            cartItem.setCreateCart ( new Date ( ) );
            CartItem cartItemCreate = cartItemsRepository.save ( cartItem );
            return cartItemCreate;
        } else {
            return null;
        }*/
        return null;

    }

    @Override
    public
    CheckOutDto generateCheckout (Customer customer) {
        Customer customerBD = customerRepository.getById ( customer.getId ( ) );
        CheckOutDto checkoutRespose = new CheckOutDto ( );
        checkoutRespose.customer = customerBD;
        List < CartItem > cartItems = getCartItemByCustomerId ( customerBD.getId ( ) );
        checkoutRespose.cartItem = cartItems;
        return checkoutRespose;
    }

    @Override
    public
    List < CartItem > getCartItemByCustomerId (Long id) {
        List < CartItem > cartItemList = new ArrayList <> ( );

        cartItemsRepository.findAll ( ).stream ( )
                .filter ( cartItem -> cartItem.getCustomer ( ).getId ( ) == id )
                .map ( cartItem -> {
                    CartItem cartItemObject = new CartItem ( );
                    cartItemObject.setProduct ( cartItem.getProduct ( ) );
                    return cartItemList.add ( cartItemObject );
                } )
                .collect ( Collectors.toList ( ) );

        return cartItemList;
    }
}
