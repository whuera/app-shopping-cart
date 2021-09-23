package com.app.mobilpymes.shoppingcart.repository;

import com.app.mobilpymes.shoppingcart.entity.CartItem;
import com.app.mobilpymes.shoppingcart.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public
interface CartItemsRepository extends JpaRepository < CartItem, Long > {
    public
    List < CartItem > findByCustomer (Customer customer);

    Collection < Object > findAllById (Long id);
}
