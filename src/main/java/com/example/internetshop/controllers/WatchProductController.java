package com.example.internetshop.controllers;

import com.example.internetshop.entities.Product;
import com.example.internetshop.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class WatchProductController {
    @Autowired
    ProductRepository productRepository;

    @GetMapping("/watch_product")
    public String watchByClick(@RequestParam Integer pr_id, Model model){
        Optional<Product> productOptional = productRepository.findById(pr_id);
        Product product = productOptional.get();
        model.addAttribute("product", product);

        return "watchProduct";
    }
}
