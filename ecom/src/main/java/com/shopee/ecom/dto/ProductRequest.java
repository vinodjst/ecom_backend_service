package com.shopee.ecom.dto;

import com.shopee.ecom.entity.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class ProductRequest {

    @NotBlank
    private String productName;

    private double productPrice;

    @Size(min = 3,max = 6)
    private String productDesc;

    private Category category;



}
