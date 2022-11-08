package com.app.mobilpymes.shoppingcart.services.impl;

import com.app.mobilpymes.shoppingcart.dto.ErrorModel;
import com.app.mobilpymes.shoppingcart.services.ErrorControlService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public
class ErrorControlServiceImpl implements ErrorControlService {

    ErrorModel errorModel = new ErrorModel ( );

    @Override
    public
    List < ErrorModel > getData ( ) {
        try {
            List < ErrorModel > listErrors = new ArrayList < ErrorModel > ( );
            File file = new ClassPathResource ( "static/ErrorMap.json" ).getFile ( );
            ObjectMapper objectMapper = new ObjectMapper ( );
            listErrors = Arrays.asList ( objectMapper.readValue ( file, ErrorModel[].class ) );
            listErrors.stream ( )
                    .map ( a -> {
                        log.info ( "valor lista " + a );
                        return a;
                    } )
                    .collect ( Collectors.toList ( ) );
            return listErrors;
        } catch (Exception e) {
            return null;
        }
    }


}
