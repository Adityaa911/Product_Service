package com.example.microservice_product.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Product extends BaseModel{
@Id
   // private Long id;
    private String Description;
    private  String Title;
    private  String imageUrl;
    private Double price;

    @ManyToOne(cascade ={CascadeType.PERSIST})
    private Category category;

}
