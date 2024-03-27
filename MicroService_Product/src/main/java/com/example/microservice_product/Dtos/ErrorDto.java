package com.example.microservice_product.Dtos;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class ErrorDto {
    public String  setMessage(String message) {

        return "Product not found";
    }
}
