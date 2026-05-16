package com.shopee.ecom.mapper;

import com.shopee.ecom.dto.ProductRequest;
import com.shopee.ecom.dto.ProductResponse;
import com.shopee.ecom.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    /* mapstruct doesn't automatically know how to do the mapping due to different field names (e.g productName in ProductRequest and name in Product Entity)
    if you want that behaviour then you need to explicitly map the fields using below annotation.
    Kept the request and response dto field names same as entity for simplicity*/
//    @Mapping(source = "productName", target = "name")
//    @Mapping(source = "productDesc", target = "description")
//    @Mapping(source = "productPrice", target = "price")
    Product toEntity(ProductRequest productRequest);

//    @Mapping(source = "name", target = "productName")
//    @Mapping(source = "description", target = "productDesc")
//    @Mapping(source = "price", target = "productPrice")
    @Mapping(source = "category.id", target = "categoryId")
    ProductResponse toResponse(Product product);
}
