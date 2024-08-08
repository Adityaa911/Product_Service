package com.example.microservice_product.ProductController;

import com.example.microservice_product.Commons.AutheticationCommon;
import com.example.microservice_product.Dtos.CreateProductRequestDto;
import com.example.microservice_product.Dtos.UserDto;
import com.example.microservice_product.Exceptions.InvalidTokenException;
import com.example.microservice_product.Models.Category;
import com.example.microservice_product.Models.Product;
import com.example.microservice_product.ProductService.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {

    private ProductService productService;
    private AutheticationCommon autheticationCommon;

    public ProductController(@Qualifier("OwnProductService") ProductService productService,AutheticationCommon autheticationCommon){
        this
                .autheticationCommon=autheticationCommon;
        this.productService=productService;
    }

    @GetMapping("/Products")
    public List<Product> GetAllProduct(){
      return productService. GetAllProduct();
    }


    @GetMapping("/Products/{id}/{token}")
    public Optional<Product> GetSingleProduct(@PathVariable("id")Long ProductId,@PathVariable("token") String token) throws InvalidTokenException {

        UserDto userDto = autheticationCommon.validateToken(token);
        if(userDto==null){
            throw new InvalidTokenException("this is invalid token and please login before for further process");
        }
        return productService.GetSingleProduct(ProductId);
    }

    @GetMapping("/products/categories")
    public List<Category>  GetAllCategory() {
         return productService.GetAllCategory();
    }

    @GetMapping("/products/categories/{category}")
    public List<Product> GetAllProductsByCategory(@PathVariable ("category") String category){
          return productService.GetAllProductsByCategory(category);
    }
@PostMapping("/product")
    public Product CreateProduct(@RequestBody CreateProductRequestDto request){
        return productService.CreateProduct(
                request.getTitle(),
                request.getDescription(),
                request.getImage(),
                request.getCategory(),
                request.getPrice()
        );
    }
    @PostMapping("/products")
    public Product UpdateProduct(@RequestBody CreateProductRequestDto request){
        return productService.UpdateProduct(
                request.getTitle(),
                request.getDescription(),
                request.getImage(),
                request.getCategory(),
                request.getPrice()
         );

    }
    @DeleteMapping("ProductId")
    public String DeleteProduct(){
      return "This Product is deleted";
    }
}
