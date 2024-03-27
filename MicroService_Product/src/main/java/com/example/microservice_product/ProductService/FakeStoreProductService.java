package com.example.microservice_product.ProductService;

import com.example.microservice_product.Dtos.FakeStoreProductDto;
import com.example.microservice_product.Models.Category;
import com.example.microservice_product.Models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("FakeStoreProductService")
public class FakeStoreProductService implements ProductService{
@Autowired
    private RestTemplate restTemplate;

   public FakeStoreProductService(RestTemplate restTemplate){
       this.restTemplate=restTemplate;
   }


    @Override
    public Optional<Product> GetSingleProduct(Long ProductId) {
       ResponseEntity<FakeStoreProductDto> FakeStoreProduct = 
     restTemplate.getForEntity("https://fakestoreapi.com/products" +ProductId,
             FakeStoreProductDto.class
     );
     return Optional.ofNullable(FakeStoreProduct.getBody().toProduct());
    }


    @Override
    public List<Product> GetAllProduct() {
       FakeStoreProductDto[] fakeStoreProductDto =
               restTemplate.getForEntity("https://fakestoreapi.com/products",
                      FakeStoreProductDto[].class ).getBody();

       List<Product> allProducts = new ArrayList<>() ;
       for (FakeStoreProductDto dto : fakeStoreProductDto){
           allProducts.add(dto.toProduct());
       }
          return allProducts;

    }

    /**
     * @param title
     * @param description
     * @param image
     * @param category
     * @param price
     * @return
     */
    @Override
    public Product CreateProduct(String title, String description, String image, String category, Double price) {
        FakeStoreProductDto fakeStoreProduct = new FakeStoreProductDto();
        fakeStoreProduct.setTitle(title);
        fakeStoreProduct.setDescription(description);
        fakeStoreProduct.setImage(image);
        fakeStoreProduct.setPrice(price);
        fakeStoreProduct.setCategory(category);

        FakeStoreProductDto response = restTemplate.postForObject("https://fakestoreapi.com/products", fakeStoreProduct,
                FakeStoreProductDto.class);
        return response.toProduct();
    }


    @Override
    public Product UpdateProduct(String title, String description, String image, String category, Double price) {
        FakeStoreProductDto fakeStoreProduct = new FakeStoreProductDto();
        fakeStoreProduct.setTitle(title);
        fakeStoreProduct.setDescription(description);
        fakeStoreProduct.setImage(image);
        fakeStoreProduct.setPrice(price);
        fakeStoreProduct.setCategory(category);

        FakeStoreProductDto response = restTemplate.postForObject("https://fakestoreapi.com/products/", fakeStoreProduct,
                FakeStoreProductDto.class);
        return response.toProduct();

    }


    @Override
    public String DeleteProduct(Long id) {
        restTemplate.delete("https://fakestoreapi.com/products/"+id);
        return null;
    }


    @Override
    public List<Category> GetAllCategory() {
        List<String> categories = restTemplate.getForObject("https://fakestoreapi.com/products/categories",
                List.class);

        List<Category> finalList = new ArrayList<>();
        for(String i : categories){
            Category tempCategory = new Category();
            tempCategory.setTitle(i);
            finalList.add(tempCategory);
        }
        return finalList;
    }



    @Override
    public List<Product> GetAllProductsByCategory(String category) {
        List<Product> productList = new ArrayList<>();
        List<FakeStoreProductDto> fakeStoreProductDto = restTemplate.exchange("https://fakestoreapi.com/products/category/"+category, HttpMethod.GET, null, new ParameterizedTypeReference<List<FakeStoreProductDto>>() {
        }).getBody();

        for(FakeStoreProductDto i : fakeStoreProductDto){
            Product tempProduct = new Product();
            Category tempCategory = new Category();
            tempProduct.setId(i.getId());
            tempProduct.setTitle(i.getTitle());
            tempProduct.setDescription(i.getDescription());
            tempProduct.setPrice(i.getPrice());
            tempCategory.setTitle(i.getCategory());
            tempProduct.setCategory(tempCategory);
            tempProduct.setImageUrl(i.getImage());
            productList.add(tempProduct);
        }
        return productList;
    }

    }


