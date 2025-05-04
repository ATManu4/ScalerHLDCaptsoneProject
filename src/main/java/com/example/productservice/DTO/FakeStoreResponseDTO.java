package com.example.productservice.DTO;

import com.example.productservice.Models.Categories;
import com.example.productservice.Models.Products;


public class FakeStoreResponseDTO {
    private long id;
    private String title;
    private double price;
    private String description;
    private String image;
    private String category;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Products toProducts() {
        Products products = new Products();
        products.setProductId(id);
        products.setProductName(title);
        products.setProductDescription(description);
        products.setProductImagePath(image);
        products.setProductPrice(price);

        Categories categories = new Categories();
        categories.setName(category);
        products.setProductCategory(categories);

        return products;
    }
}
