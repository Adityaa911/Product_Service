package com.example.microservice_product.Dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProductRequestDto {
    private Long id;
    private String Title;
    private String Description;
    private String Image;
    private Double Price;
    private String Category;

}
