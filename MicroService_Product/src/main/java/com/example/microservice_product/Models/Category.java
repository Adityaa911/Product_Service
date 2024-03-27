package com.example.microservice_product.Models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Category extends BaseModel{
    //private Long id;
 @Id
    private String Title;

@OneToMany(mappedBy = "category" ,cascade = CascadeType.REMOVE)
     List<Product> products;
}
