package com.example.microservice_product.Advices;

import com.example.microservice_product.Dtos.ErrorDto;
import com.example.microservice_product.Exceptions.InvalidTokenException;
import com.example.microservice_product.Exceptions.ProductNotFoundExceptions;
import jakarta.xml.ws.Response;
import org.hibernate.engine.spi.EntityEntry;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class ControllerAdvice {
    @ExceptionHandler
    public ResponseEntity<ErrorDto> handleProductNotFoundException(ProductNotFoundExceptions exception) {
        ErrorDto errorDto = new ErrorDto();
        errorDto.setMessage(exception.getMessage());
        ResponseEntity<ErrorDto> responseEntity = new ResponseEntity<>(errorDto, HttpStatus.NOT_FOUND);
        return responseEntity;
    }

    @ExceptionHandler(InvalidTokenException.class)
    public ResponseEntity<ErrorDto>  HandleInvalidTokenException(){
        ErrorDto errorDto = new ErrorDto();
        errorDto.setMessage("Invalid token");
        ResponseEntity<ErrorDto> responseEntity =
                new ResponseEntity<>
                         (errorDto
                ,HttpStatus.NOT_FOUND);
        return responseEntity;
    }
}