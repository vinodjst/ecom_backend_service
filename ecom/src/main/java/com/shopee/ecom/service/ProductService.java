package com.shopee.ecom.service;

import com.shopee.ecom.dto.ProductRequest;
import com.shopee.ecom.dto.ProductResponse;
import com.shopee.ecom.entity.Product;
import com.shopee.ecom.exceptions.ProductNotFoundException;
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

    public ProductResponse saveProduct(ProductRequest productRequest){
        //call  Db//request - entity
            Product product = new Product();
            product.setName(productRequest.getProductName());
            product.setDesc(productRequest.getProductDesc());
            product.setPrice(productRequest.getProductPrice());
            Product save = productRepository.save(product);
            ProductResponse productResponse = new ProductResponse(save.getId(), save.getName(), save.getPrice(), save.getDesc());
       return productResponse;
    }

    public ProductResponse findProduct(Long productId){

        Optional<Product> productById = productRepository.findById(productId);
        if(productById.isEmpty())
            throw new ProductNotFoundException(productId);

        if(productById.isPresent()){
            Product product = productById.get();
            ProductResponse productResponse = new ProductResponse(product.getId(), product.getName(), product.getPrice(), product.getDesc());
            return productResponse;
        }
        return null;
    }

    public List<ProductResponse> findAllProducts(){

        ArrayList<ProductResponse> productResponses = new ArrayList<ProductResponse>();
        List<Product> all = productRepository.findAll();

        for(Product product : all){
            ProductResponse productResponse = new ProductResponse(product.getId(), product.getName(), product.getPrice(), product.getDesc());
            productResponses.add(productResponse);
        }
        return productResponses;
    }

    public void removeProduct(Long productId){

        productRepository.deleteById(productId);
    }

    public ProductResponse updateProduct(Long productId,ProductRequest productRequest){

        Optional<Product> byId = productRepository.findById(productId);
        if(byId.isEmpty()){
            throw new ProductNotFoundException(productId);
        }

        Product productEntity = byId.get();
        productEntity.setName(productRequest.getProductName());
        productEntity.setDesc(productRequest.getProductDesc());
        productEntity.setPrice(productRequest.getProductPrice());
        Product save = productRepository.save(productEntity);

        ProductResponse productResponse = new ProductResponse(save.getId(), save.getName(), save.getPrice(), save.getDesc());
        return productResponse;
    }





}
