package com.example.microservice_product.Repositorys;

import com.example.microservice_product.Models.Category;
import com.example.microservice_product.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long > {



    Product save(Product p);
    Product findById();

        List<Product> findAll();

    List<Product> findByCategory_Title(String title);

    List<Product> findByCategory(Category category);

    void delete( Product product);

    void delete(Long id);
}
