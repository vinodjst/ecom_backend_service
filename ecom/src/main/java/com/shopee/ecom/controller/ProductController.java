package com.shopee.ecom.controller;

import com.shopee.ecom.annotation.AdminOnly;
import com.shopee.ecom.dto.ProductRequest;
import com.shopee.ecom.dto.ProductResponse;
import com.shopee.ecom.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@CrossOrigin("http://localhost:5173")
public class ProductController {

    @Autowired
    ProductService productService;
    //new ProductService(); when it is created
    // there is IOC  -- i will create an object  you can use


    @PostMapping("/add")
    public ResponseEntity<ProductResponse> addProduct(@RequestBody ProductRequest request) {

        ProductResponse productResponse = productService.saveProduct(request);

        return ResponseEntity.ok(productResponse);
    }

    @PutMapping("/update/{productId}")
    public ResponseEntity<ProductResponse> updateProduct(@PathVariable long productId, @RequestBody ProductRequest productRequest) {

        return ResponseEntity.ok(productService.updateProduct(productId, productRequest));
    }

    @AdminOnly
    @DeleteMapping("/remove/{productId}")
    public ResponseEntity<String> deleteProduct(@PathVariable long productId) {

        productService.removeProduct(productId);
        return ResponseEntity.ok("Product removed successfully");
    }

    @GetMapping("/fetchAll")
    public ResponseEntity<List<ProductResponse>> fetchProducts() {

        return ResponseEntity.ok(productService.findAllProducts());

    }

    @GetMapping("/fetch/{productId}")
    public ResponseEntity<ProductResponse> fetchProducts(@PathVariable long productId) {

        return ResponseEntity.ok(productService.findProduct(productId));

    }

}
