package com.app.mobilpymes.shoppingcart.repository;

import com.app.mobilpymes.shoppingcart.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository < Product, Long> {
}
