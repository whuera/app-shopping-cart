package com.app.mobilpymes.shoppingcart.utils;

import com.app.mobilpymes.shoppingcart.exception.ErrorMessage;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.validation.BindingResult;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public
class ShoppingCartHelper {

    public static
    String formatMessage (BindingResult result) {
        List < Map < String, String > > errors = result.getFieldErrors ( ).stream ( )
                .map ( err -> {
                    Map < String, String > error = new HashMap <> ( );
                    error.put ( err.getField ( ), err.getDefaultMessage ( ) );
                    return error;

                } ).collect ( Collectors.toList ( ) );
        ErrorMessage errorMessage = new ErrorMessage (  );
        //errorMessage.setCode ( "01" );
        //errorMessage.setMessages ( errors );
        ObjectMapper mapper = new ObjectMapper ( );
        String jsonString = "";
        try {
            jsonString = mapper.writeValueAsString ( errorMessage );
        } catch (JsonProcessingException e) {
            e.printStackTrace ( );
        }
        return jsonString;
    }
}
