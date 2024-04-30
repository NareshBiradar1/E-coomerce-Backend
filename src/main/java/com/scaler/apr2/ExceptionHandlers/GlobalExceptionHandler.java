package com.scaler.apr2.ExceptionHandlers;

import com.scaler.apr2.CustomExceptions.ProductNotFoundException;
import com.scaler.apr2.DTO.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ExceptionDto> handleArithmeticException(){
        ExceptionDto newException = new ExceptionDto();
        newException.setMessage("new Arithmetic Ecxeption");
        newException.setResolution("check for division by Zero");
        ResponseEntity<ExceptionDto> responseEntity = new ResponseEntity<>(newException, HttpStatus.BAD_REQUEST);
        return responseEntity;
    }

    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    public ResponseEntity<ExceptionDto> handleArrayIndexOutOfBoundsException() {
        ExceptionDto dto = new ExceptionDto();
        dto.setMessage("Something went wrong");
        dto.setResolution("ArrayIndexOutOfBoundsException");
        ResponseEntity<ExceptionDto> response = new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
        return response;
    }


    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ExceptionDto> handleProductNotFoundException(ProductNotFoundException productNotFoundException){
        ExceptionDto newException = new ExceptionDto();
        newException.setMessage("Product id "+productNotFoundException.getId() + " is invalid");
        newException.setResolution("Enter correct Product Id and retry");
        ResponseEntity<ExceptionDto> responseEntity = new ResponseEntity<>(newException, HttpStatus.BAD_REQUEST);
        return responseEntity;
    }

}
