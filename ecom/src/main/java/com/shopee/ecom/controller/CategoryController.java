package com.shopee.ecom.controller;

import com.shopee.ecom.dto.CategoryRequest;
import com.shopee.ecom.dto.CategoryResponse;
import com.shopee.ecom.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {


    @Autowired
    private CategoryService categoryService;

    @PostMapping("/add")
    public ResponseEntity<CategoryResponse> addCategory(@Valid @RequestBody CategoryRequest request) {

        return ResponseEntity.ok(categoryService.addCategory(request));

    }

    @GetMapping("/fetchAll")
    public ResponseEntity<List<CategoryResponse>> getCategories() {
        return ResponseEntity.ok(categoryService.getCategories());
    }

}
