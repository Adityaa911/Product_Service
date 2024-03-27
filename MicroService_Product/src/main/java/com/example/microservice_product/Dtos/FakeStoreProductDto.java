package com.example.microservice_product.Dtos;

import com.example.microservice_product.Models.Product;
import com.example.microservice_product.Models.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FakeStoreProductDto {
   private Long id;
   private String Title;
   private String Description;
   private String Image;
   private Double Price;
   private String Category;

    public Product toProduct(){
        Product product = new Product();
        product.setId(id);
        product.setTitle(Title);
        product.setDescription(Description);
        product.setPrice(Price);
        product.setImageUrl(Image);

        Category ProductCategory =  new Category();

        ProductCategory.setTitle(Category);

        product.setCategory(ProductCategory);

  return product;
    }


}
