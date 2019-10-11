package com.example.internetshop.controllers;


import com.example.internetshop.entities.Category;
import com.example.internetshop.entities.Product;
import com.example.internetshop.repositories.CategoryRepository;
import com.example.internetshop.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class CategoryController {
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    ProductRepository productRepository;
    @GetMapping("/all_categories")
    public @ResponseBody
    Set<String> getAllCategories(){
        Iterable<Category> iterable = categoryRepository.findAll();
        Set<String> categories = new TreeSet<>();
        for(Category category: iterable){
            categories.add(category.getName());
        }
        return categories;
    }
    @GetMapping("/product_category_by_id")
    public @ResponseBody String getCategoryById(@RequestParam int id){
        return productRepository.findById(id).get().getCategory().getName();
    }

}
