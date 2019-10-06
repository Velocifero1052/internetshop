package com.example.internetshop.controllers;

import com.example.internetshop.FormFilter;
import com.example.internetshop.entities.Product;
import com.example.internetshop.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class IndexController {
    @Autowired
    ProductRepository productRepository;

    @GetMapping("/")
    public String greetingForm(@RequestParam(required = false) String searchText, Model model) {
        Iterable<Product> productsList = productRepository.findAll();


        model.addAttribute("productsList", productsList);


        return "index";
    }

    @PostMapping("/")
    public String greetingSubmit(@ModelAttribute FormFilter formFilter, Model model) {
        model.addAttribute("ff", formFilter);

        return "result";
    }

}
