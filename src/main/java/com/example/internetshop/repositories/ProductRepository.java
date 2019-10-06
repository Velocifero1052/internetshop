package com.example.internetshop.repositories;

import com.example.internetshop.entities.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {

}
