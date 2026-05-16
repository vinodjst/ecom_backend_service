package com.shopee.ecom.dto;

import com.shopee.ecom.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.mapstruct.Mapping;

@Data
public class ProductResponse {
    /*Kept all the request dtos same as Product Entity fields because mapstruct does n't
    automatically know how to do the mapping due to different field names (e.g productName in ProductRequest and name in Product Entity)
    if you want that behaviour then you need to explicitly map the fields using below annotation
    @Mapping(source = "productName", target = "name")*/
    private Long id;

    private String name;

    private double price;

    private String description;

    private Long categoryId;

}
