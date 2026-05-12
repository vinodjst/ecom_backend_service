package com.shopee.ecom.dto;

import com.shopee.ecom.entity.Category;

public class ProductResponse {

    private Long id;

    private String productName;

    private double productPrice;

    private String productDesc;

    private Long categoryId;




    public ProductResponse(Long id, String productName, double productPrice, String productDesc, Long categoryId) {
        this.id = id;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productDesc = productDesc;
        this.categoryId = categoryId;
    }

    public ProductResponse(Long id, String productName, double productPrice, String productDesc) {
        this.id = id;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productDesc = productDesc;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }
}
