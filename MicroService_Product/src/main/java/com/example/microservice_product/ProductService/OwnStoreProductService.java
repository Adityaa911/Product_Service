package com.example.microservice_product.ProductService;

import com.example.microservice_product.Models.Category;
import com.example.microservice_product.Models.Product;
import com.example.microservice_product.Repositorys.CategoryRepository;
import com.example.microservice_product.Repositorys.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("OwnProductService")
public class OwnStoreProductService implements ProductService{

    ProductRepository productRepository;
    CategoryRepository categoryRepository;

    OwnStoreProductService (ProductRepository productRepository,CategoryRepository categoryRepository){
        this.productRepository=productRepository;
        this.categoryRepository=categoryRepository;
    }
    @Override
    public Optional<Product> GetSingleProduct(Long ProductId) {
        return productRepository.findById(ProductId);
    }

    @Override
    public List<Product> GetAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Product CreateProduct(String title, String description, String image, String category, Double price) {
        Product product = new Product();
        product.setTitle(title);
        product.setDescription(description);
        product.setPrice(price);
        product.setImageUrl(image);

        Category categoryFromDb = categoryRepository.findByTitle(category);
        if (categoryFromDb == null){
            Category newCategory = new Category();
            newCategory.setTitle(category);
            categoryFromDb = categoryRepository.save(newCategory);
        }
        product.setCategory(categoryFromDb);

        return productRepository.save(product);
    }

    @Override
    public Product UpdateProduct(String title, String description, String image, String category, Double price) {

        Product existingProduct = productRepository.findById();
        if (existingProduct.getTitle() != null) {
            existingProduct.setTitle(existingProduct.getTitle());
        }
        if (existingProduct.getImageUrl() != null) {
            existingProduct.setImageUrl(existingProduct.getImageUrl());
        }
        if (existingProduct.getDescription() != null) {
            existingProduct.setDescription(existingProduct.getDescription());
        }
        if (Double.valueOf(existingProduct.getPrice()) != 0.0) {
            existingProduct.setPrice(existingProduct.getPrice());
        }
        if (existingProduct.getCategory() != null) {
            Category newCategory = new Category();
            newCategory.setTitle(existingProduct.getCategory().getTitle());
            existingProduct.setCategory(newCategory);
        }
        productRepository.save(existingProduct);
        return existingProduct;
    }



    @Override
    public String DeleteProduct(Long Id) {
        productRepository.delete(Id);
        return "This item is Deleted";
    }

    @Override
    public List<Category> GetAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public List<Product> GetAllProductsByCategory(String category) {
        Category newCategory = categoryRepository.findByTitle(category);
        return productRepository.findByCategory(newCategory);
    }
}
