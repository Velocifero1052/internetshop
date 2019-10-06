package com.example.internetshop.controllers;

import com.example.internetshop.entities.Category;
import com.example.internetshop.entities.Product;
import com.example.internetshop.forms.ProductForm;
import com.example.internetshop.repositories.CategoryRepository;
import com.example.internetshop.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.Collections;

@Controller
public class AddProductController {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping("/show_products")
    public @ResponseBody String show_products(){
        return productRepository.findAll().toString();
    }

    @GetMapping("/add_product")
    public String add_product(Model model){
        model.addAttribute("productFields", new ProductForm());
        return "addProductPage";
    }
    @PostMapping("/add_product")
    public
    String submitAddition(@Valid ProductForm productFields, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "addProductPage";
        }

        Product product = new Product();

        product.setName(productFields.getName());
        product.setDescription(productFields.getDescription());
        product.setPhoto(productFields.getPhoto());
        product.setPrice(productFields.getPrice());

        Category category = new Category();
        category.setName(productFields.getCategoryName());
        category.setProduct(Collections.singletonList(product));

        product.setCategory(category);

        categoryRepository.save(category);
        productRepository.save(product);

        return "result";
    }
}
