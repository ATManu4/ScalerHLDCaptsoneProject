package com.example.productservice.Services;

import com.example.productservice.DTO.FakeStoreResponseDTO;
import com.example.productservice.Interfaces.ProductService;
import com.example.productservice.Models.Products;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FakeStoreProductService implements ProductService {

    RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Products getProductById(long id) {

        FakeStoreResponseDTO fakeStoreResponseDTO =  restTemplate.getForObject(
                "https://fakestoreapi.com/products/" + id,
                FakeStoreResponseDTO.class);

        return fakeStoreResponseDTO.toProducts();
    }
}
