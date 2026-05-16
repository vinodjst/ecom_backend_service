package com.shopee.ecom.dto;

import com.shopee.ecom.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class ProductResponse {

    private Long id;

    private String productName;

    private double productPrice;

    private String productDesc;

    private Long categoryId;

}
