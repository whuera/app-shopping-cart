package com.app.mobilpymes.shoppingcart.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@Builder
@AllArgsConstructor @NoArgsConstructor
public
class ErrorMessage {
    private String code;
    private List < Map < String, String > > messages;
}
