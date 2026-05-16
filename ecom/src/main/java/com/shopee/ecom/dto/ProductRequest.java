package com.shopee.ecom.dto;

import com.shopee.ecom.entity.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class ProductRequest {
    /*Kept all the request dtos same as Product Entity fields because mapstruct does n't
    automatically know how to do the mapping due to different field names (e.g productName in ProductRequest and name in Product Entity)
    if you want that behaviour then you need to explicitly map the fields using below annotation
    @Mapping(source = "productName", target = "name")*/
    @NotBlank
    private String name;

    private double price;

    @Size(min = 3,max = 6)
    private String description;

    //included the category id instead of category object
    private Long categoryId;


}
