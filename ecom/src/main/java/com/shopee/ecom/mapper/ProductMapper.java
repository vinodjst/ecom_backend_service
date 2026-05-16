package com.shopee.ecom.mapper;

import com.shopee.ecom.dto.ProductRequest;
import com.shopee.ecom.dto.ProductResponse;
import com.shopee.ecom.entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    Product toEntity(ProductRequest productRequest);

    ProductResponse toResponse(Product product);
}
