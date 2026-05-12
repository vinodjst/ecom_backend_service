package com.shopee.ecom.dto;

import com.shopee.ecom.entity.Product;

import java.util.List;

public class CategoryResponse {

    private  Long id;

    private String categoryName;

    private List<Product> products;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
