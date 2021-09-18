package com.app.mobilpymes.shoppingcart.services.impl;

import com.app.mobilpymes.shoppingcart.entity.Customer;
import com.app.mobilpymes.shoppingcart.repository.CustomerRepository;
import com.app.mobilpymes.shoppingcart.services.CustomerService;
import com.app.mobilpymes.shoppingcart.utils.ShoppingCartEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public
class CustomerServiceImpl implements CustomerService {

    @Autowired
    private
    CustomerRepository customerRepository;

    @Override
    public
    Customer createCustomer (Customer customer) {
        if ( null == customer ) {
            return null;
        }
        Customer customerDB = getCustomer ( customer.getId ( ) );
        if ( !customerDB.equals ( null ) ) {
            customer.setStatus ( ShoppingCartEnum.CUSTOMER_CREATE.type );
            return customerRepository.save ( customer );
        } else {
            return null;
        }
    }

    @Override
    public
    Customer updateCustomer (Customer customer) {
        Customer customerDB = getCustomer ( customer.getId ( ) );
        if ( null == customerDB ) {
            return null;
        }
        customer.setStatus ( ShoppingCartEnum.CUSTOMER_UPDATE.type );
        return customerRepository.save ( customer );
    }

    @Override
    public
    Customer deleteCustomer (long id) {
        Customer customerDB = getCustomer ( id );
        if ( null == customerDB ) {
            return null;
        }
        customerDB.setStatus ( ShoppingCartEnum.CUSTOMER_DELETE.type );
        return customerRepository.save ( customerDB );
    }

    @Override
    public
    Customer getCustomer (Long id) {
        return customerRepository.findById ( id ).orElse ( null );
    }

    @Override
    public
    List < Customer > listAllCustomer ( ) {
        return customerRepository.findAll ( );
    }
}
