package com.example.productservice.DTO;

import com.example.productservice.Models.Products;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponseDTO {
    private long id;
    private String name;
    private double price;
    private String description;
    private String imageUrl;
    private String category;

    public static ProductResponseDTO from(Products products){
        ProductResponseDTO productResponseDTO = new ProductResponseDTO();
        productResponseDTO.setId(products.getProductId());
        productResponseDTO.setName(products.getProductName());
        productResponseDTO.setPrice(products.getProductPrice());
        productResponseDTO.setDescription(products.getProductDescription());
        productResponseDTO.setImageUrl(products.getProductImagePath());
        productResponseDTO.setCategory(products.getProductCategory().getName());
        return productResponseDTO;
    }
}
