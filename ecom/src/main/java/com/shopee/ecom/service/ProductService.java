package com.shopee.ecom.service;

import com.shopee.ecom.dto.ProductRequest;
import com.shopee.ecom.dto.ProductResponse;
import com.shopee.ecom.entity.Category;
import com.shopee.ecom.entity.Product;
import com.shopee.ecom.exceptions.ProductNotFoundException;
import com.shopee.ecom.mapper.ProductMapper;
import com.shopee.ecom.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {


    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductMapper productMapper;

    public ProductResponse saveProduct(ProductRequest productRequest) {

        Product productEntity = productMapper.toEntity(productRequest);

        Category category = new Category();
        category.setId(productRequest.getCategory().getId());
        productEntity.setCategory(category);
        Product save = productRepository.save(productEntity);
        ProductResponse response = productMapper.toResponse(save);
        return response;

    }

    public ProductResponse findProduct(Long productId) {

        Optional<Product> productById = productRepository.findById(productId);
        if (productById.isEmpty())
            throw new ProductNotFoundException(productId);

        if (productById.isPresent()) {
            Product product = productById.get();
            ProductResponse productResponse = productMapper.toResponse(product);
            return productResponse;
        }
        return null;
    }

    public List<ProductResponse> findAllProducts() {

        ArrayList<ProductResponse> productResponses = new ArrayList<ProductResponse>();
        List<Product> all = productRepository.findAll();

        for (Product product : all) {
            ProductResponse productResponse = productMapper.toResponse(product);
            productResponses.add(productResponse);
        }
        return productResponses;
    }

    public void removeProduct(Long productId) {

        productRepository.deleteById(productId);
    }

    public ProductResponse updateProduct(Long productId, ProductRequest productRequest) {

        Optional<Product> byId = productRepository.findById(productId);
        if (byId.isEmpty()) {
            throw new ProductNotFoundException(productId);
        }
        Product productEntity = byId.get();
        productEntity.setName(productRequest.getProductName());
        productEntity.setDescription(productRequest.getProductDesc());
        productEntity.setPrice(productRequest.getProductPrice());
        Product save = productRepository.save(productEntity);

        ProductResponse productResponse = productMapper.toResponse(save);
        return productResponse;
    }


}
