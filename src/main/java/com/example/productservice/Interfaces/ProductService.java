package com.example.productservice.Interfaces;

import com.example.productservice.Exceptions.ProductNotFoundException;
import com.example.productservice.Models.Products;

import java.util.List;

public interface ProductService {

    Products getProductById(long id) throws ProductNotFoundException;

    List<Products> getAllProducts();

    Products createProduct(String name, String description, double price, String category, String imageUrl);
}
