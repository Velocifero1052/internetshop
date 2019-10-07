package com.example.internetshop.controllers;

import com.example.internetshop.entities.Product;
import com.example.internetshop.forms.OrderForm;
import com.example.internetshop.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class OrderProductController {
    @Autowired
    ProductRepository productRepository;
    @GetMapping("/order_product")
    public String orderProduct(@RequestParam Integer pr_id, Model model){
        Product product = productRepository.findById(pr_id).get();
        model.addAttribute("product", product);
        model.addAttribute("orderForm", new OrderForm());

        return "order";
    }

    @PostMapping("/order_product")
    public @ResponseBody
    String orderSubmit(@ModelAttribute OrderForm orderForm){
        return orderForm.toString();
    }
}
