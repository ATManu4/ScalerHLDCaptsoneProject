package com.example.productservice.Controllers;

import com.example.productservice.DTO.ProductResponseDTO;
import com.example.productservice.Interfaces.ProductService;
import com.example.productservice.Models.Products;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products/{id}")
    public ProductResponseDTO getProductById(@PathVariable("id") long id) {
        Products products = productService.getProductById(id);

        return ProductResponseDTO.from(products);
    }
}
