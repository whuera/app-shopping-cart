package com.app.mobilpymes.shoppingcart.services.impl;

import com.app.mobilpymes.shoppingcart.entity.Category;
import com.app.mobilpymes.shoppingcart.entity.Product;
import com.app.mobilpymes.shoppingcart.repository.ProductRepository;
import com.app.mobilpymes.shoppingcart.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public
class ProductServiceImpl implements ProductService {

    @Autowired
    private
    ProductRepository productRepository;

    @Override
    public
    List < Product > listAllProduct ( ) {
        return productRepository.findAll ( );
    }

    @Override
    public
    Product getProduct (Long id) {
        return productRepository.getById ( id );
    }

    @Override
    public
    Product createProduct (Product product) {
        if ( !product.equals ( null ) ) {
            product.setStatus ( "create" );
        }
        return productRepository.save ( product );
    }

    @Override
    public
    Product updateProduct (Product product) {
        return productRepository.save ( product );
    }

    @Override
    public
    Product deleteProduct (Long id) {

        return null;
    }

    @Override
    public
    List < Product > findByCategory (Category category) {
        return null;
    }

    @Override
    public
    Product updateStock (Long id, Double quantity) {
        return null;
    }
}
