package com.shopee.ecom.service;

import com.shopee.ecom.dto.CategoryRequest;
import com.shopee.ecom.dto.CategoryResponse;
import com.shopee.ecom.entity.Category;
import com.shopee.ecom.exceptions.CategoryNotFoundException;
import com.shopee.ecom.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public CategoryResponse addCategory(CategoryRequest category) {

        Category categoryEntity = new Category();

        //set the category
        categoryEntity.setCategoryName(category.getCategory());

        Category save = categoryRepository.save(categoryEntity);

        CategoryResponse categoryResponse = new CategoryResponse();
        categoryResponse.setId(save.getId());
        categoryResponse.setCategoryName(save.getCategoryName());
        return categoryResponse;
    }


    public List<CategoryResponse> getCategories() {

        ArrayList<CategoryResponse> responses = new ArrayList<>();

        List<Category> all = categoryRepository.findAll();


        for (Category response : all) {

            CategoryResponse categoryResponse = new CategoryResponse();
            categoryResponse.setId(response.getId());
            categoryResponse.setCategoryName(response.getCategoryName());
            categoryResponse.setProducts(response.getProducts());
            responses.add(categoryResponse);
        }

        return responses;
    }

    public CategoryResponse getCategoryById(Long categoryId) {

        Optional<Category> byId = categoryRepository.findById(categoryId);
        if (byId.isEmpty()) {
            throw new CategoryNotFoundException(categoryId);
        }

        Category response = byId.get();

        CategoryResponse categoryResponse = new CategoryResponse();
        categoryResponse.setId(response.getId());
        categoryResponse.setCategoryName(response.getCategoryName());
        categoryResponse.setProducts(response.getProducts());

        return categoryResponse;
    }

}
