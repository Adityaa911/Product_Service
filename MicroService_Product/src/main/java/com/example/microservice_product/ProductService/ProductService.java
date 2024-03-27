package com.example.microservice_product.ProductService;

import com.example.microservice_product.Models.Category;
import com.example.microservice_product.Models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

     Optional<Product> GetSingleProduct(Long ProductId);

     List<Product> GetAllProduct();

     Product CreateProduct(String title,String description,String image,String category,Double price);

     Product UpdateProduct(String title,String description,String image,String category,Double price);

     String DeleteProduct(Long id);

     List<Category> GetAllCategory();


     List<Product> GetAllProductsByCategory(String category);
}
