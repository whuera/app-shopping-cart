package com.app.mobilpymes.shoppingcart.exception.handler;


import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public
class AppExceptionHandler {

    /*@ExceptionHandler(value = {EntityNotFoundException.class})
    public
    ResponseEntity < Object > entityNotFoundException (EntityNotFoundException ex) {
        ErrorMessage errorMessage = ErrorMessage ( );
               *//* .message ( ex.getMessage ( ) )
                .timestamp ( new Date ( ) )
                .code ( 404 )
                .build ( );*//*
        return new ResponseEntity <> ( errorMessage, HttpStatus.NOT_FOUND );
    }*/

    /*@ExceptionHandler(value = {EntityAlreadyExistsException.class})
    public
    ResponseEntity < Object > entityNotFoundException (EntityAlreadyExistsException ex) {
        ErrorMessage errorMessage = ErrorMessage.builder ( )
                .message ( ex.getMessage ( ) )
                .timestamp ( new Date ( ) )
                .code ( 409 )
                .build ( );
        return new ResponseEntity <> ( errorMessage, HttpStatus.CONFLICT );
    }*/
}

