package com.example.productservice.Controllers;

import com.example.productservice.DTO.CreateFakeStoreProductRequestDTO;
import com.example.productservice.DTO.ProductResponseDTO;
import com.example.productservice.Exceptions.ProductNotFoundException;
import com.example.productservice.Interfaces.ProductService;
import com.example.productservice.Models.Products;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products/{id}")
    public ProductResponseDTO getProductById(@PathVariable("id") long id) throws ProductNotFoundException {
        Products products = productService.getProductById(id);

        return ProductResponseDTO.from(products);
    }

//    @ExceptionHandler(NullPointerException.class)
//    public ErrorDTO handleNullPointerException(NullPointerException npe) {
//        ErrorDTO errorDTO = new ErrorDTO();
//        errorDTO.setStatus("Failure");
//        errorDTO.setMessage("Product can not be null");
//        return errorDTO;
//    }

    @GetMapping("/products")
    public List<ProductResponseDTO> getAllProducts() {
        List<ProductResponseDTO> productResponseDTOList = new ArrayList<>();
        List<Products> productsList = productService.getAllProducts();

        for (Products products : productsList) {
            productResponseDTOList.add(ProductResponseDTO.from(products));
        }

        return productResponseDTOList;
    }

    @PostMapping("/products")
    public ResponseEntity<ProductResponseDTO> createProduct(
            @RequestBody CreateFakeStoreProductRequestDTO productRequestDTO) {
        Products product = productService.createProduct(
                productRequestDTO.getName(),
                productRequestDTO.getDescription(),
                productRequestDTO.getPrice(),
                productRequestDTO.getCategory(),
                productRequestDTO.getImageUrl()
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(ProductResponseDTO.from(product));
    }
}
