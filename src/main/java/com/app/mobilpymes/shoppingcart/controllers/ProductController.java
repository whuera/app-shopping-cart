package com.app.mobilpymes.shoppingcart.controllers;

import com.app.mobilpymes.shoppingcart.entity.Category;
import com.app.mobilpymes.shoppingcart.entity.Product;
import com.app.mobilpymes.shoppingcart.services.ProductService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api")
public
class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public
    String healthPage ( ) {
        return "Status Ok";
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/products")
    public
    ResponseEntity < List < Product > > getAllProducts ( ) {
        return ResponseEntity.ok ( productService.listAllProduct ( ) );
    }

    @GetMapping("/listproducts")
    public
    ResponseEntity < List < Product > > listProduct (@RequestParam(name = "categoryId", required = false) Long categoryId) {
        List < Product > products = new ArrayList <> ( );
        if ( null == categoryId ) {
            products = productService.listAllProduct ( );
            if ( products.isEmpty ( ) ) {
                return ResponseEntity.noContent ( ).build ( );
            }
        } else {
            products = productService.findByCategory ( Category.builder ( ).id ( categoryId ).build ( ) );
            if ( products.isEmpty ( ) ) {
                return ResponseEntity.notFound ( ).build ( );
            }
        }

        return ResponseEntity.ok ( products );
    }

    @GetMapping(value = "/product/{id}")
    public
    ResponseEntity < Product > getProduct (@PathVariable("id") Long id) {
        Product product = productService.getProduct ( id );
        if ( null == product ) {
            return ResponseEntity.notFound ( ).build ( );
        }
        return ResponseEntity.ok ( product );
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public
    ResponseEntity < Product > createProduct (@Valid @RequestBody Product product, BindingResult result) {
        if ( result.hasErrors ( ) ) {
            throw new ResponseStatusException ( HttpStatus.BAD_REQUEST, this.formatMessage ( result ) );
        }
        Product productCreate = productService.createProduct ( product );
        return ResponseEntity.status ( HttpStatus.CREATED ).body ( productCreate );
    }

    private
    String formatMessage (BindingResult result) {
        List < Map < String, String > > errors = result.getFieldErrors ( ).stream ( )
                .map ( err -> {
                    Map < String, String > error = new HashMap <> ( );
                    error.put ( err.getField ( ), err.getDefaultMessage ( ) );
                    return error;

                } ).collect ( Collectors.toList ( ) );
        ErrorMessage errorMessage = ErrorMessage.builder ( )
                .code ( "01" )
                .messages ( errors ).build ( );
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
