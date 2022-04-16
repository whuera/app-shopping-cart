package com.app.mobilpymes.shoppingcart.services;

import com.app.mobilpymes.shoppingcart.dto.ErrorModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public
interface ErrorControlService {
    public
    List < ErrorModel > getData ( );

}
