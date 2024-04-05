package com.scaler.apr2.CustomExceptions;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.flogger.Flogger;

@Getter
@Setter
public class ProductNotFoundException extends RuntimeException{
    private Long Id;

    public ProductNotFoundException(Long Id , String message){
        super(message);
        this.Id = Id;
    }
}
