package com.example.microservice_product.Repositorys;

import com.example.microservice_product.Models.Category;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category,Long> {
    public Category findByTitle(String title);
    List<Category> findAll();
}
