package com.example.productservice.Services;

import com.example.productservice.DTO.FakeStoreRequestDTO;
import com.example.productservice.DTO.FakeStoreResponseDTO;
import com.example.productservice.Exceptions.ProductNotFoundException;
import com.example.productservice.Interfaces.ProductService;
import com.example.productservice.Models.Products;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements ProductService {

    RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Products getProductById(long id) throws ProductNotFoundException {

        FakeStoreResponseDTO fakeStoreResponseDTO =  restTemplate.getForObject(
                "https://fakestoreapi.com/products/" + id,
                FakeStoreResponseDTO.class);

        if(fakeStoreResponseDTO == null) {
            throw new ProductNotFoundException("Product with id " + id + " not found");
        }

        return fakeStoreResponseDTO.toProducts();
    }

    @Override
    public List<Products> getAllProducts() {
        FakeStoreResponseDTO[] fakeStoreResponseDTOList = restTemplate.getForObject(
                "https://fakestoreapi.com/products/",
                FakeStoreResponseDTO[].class);

        List <Products> productsList = new ArrayList<>();
        for(FakeStoreResponseDTO fakeStoreResponseDTO : fakeStoreResponseDTOList) {

            productsList.add(fakeStoreResponseDTO.toProducts());
        }

        return productsList;
    }

    @Override
    public Products createProduct(String name, String description, double price, String category, String imageUrl) {
        FakeStoreRequestDTO fakeStoreRequestDTO = createDTOFromParams(name, description, price, category, imageUrl);

        FakeStoreResponseDTO fakeStoreResponseDTO = restTemplate.postForObject(
                "https://fakestoreapi.com/products",
                fakeStoreRequestDTO,
                FakeStoreResponseDTO.class);

        return fakeStoreResponseDTO.toProducts();
    }

    private FakeStoreRequestDTO createDTOFromParams(String name, String description, double price, String category, String imageUrl) {
        FakeStoreRequestDTO fakeStoreRequestDTO = new FakeStoreRequestDTO();
        fakeStoreRequestDTO.setTitle(name);
        fakeStoreRequestDTO.setDescription(description);
        fakeStoreRequestDTO.setPrice(price);
        fakeStoreRequestDTO.setCategory(category);
        fakeStoreRequestDTO.setImage(imageUrl);
        return fakeStoreRequestDTO;
    }
}
