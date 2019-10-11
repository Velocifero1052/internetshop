package com.example.internetshop.repositories;

import com.example.internetshop.entities.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Integer> {

}
