package com.example.internetshop.controllers.api;

import com.example.internetshop.entities.Detail;
import com.example.internetshop.entities.Product;
import com.example.internetshop.repositories.CategoryRepository;
import com.example.internetshop.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
public class ProductsController {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @GetMapping("/get_all_products")
    public @ResponseBody
    List<String> getAllProducts(){
        List<String> listOfProducts = new ArrayList<>();
        Iterable<Product> products = productRepository.findAll();
        for(Product product: products){
            listOfProducts.add(product.toString());
        }
        return listOfProducts;
    }
    @GetMapping("/details_by_id")
    public @ResponseBody
    Collection<Detail> getDetailsById(@RequestParam int id){
        return productRepository.findById(id).get().getDetails();
    }

}
