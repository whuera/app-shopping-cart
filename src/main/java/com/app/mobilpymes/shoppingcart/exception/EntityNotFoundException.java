package com.app.mobilpymes.shoppingcart.exception;

public
class EntityNotFoundException extends RuntimeException {

    public
    EntityNotFoundException (Long id) {
    }

    public
    EntityNotFoundException (String message) {
        super ( message );
    }
}
