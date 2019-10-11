package com.example.internetshop.controllers;

import com.example.internetshop.entities.Detail;
import com.example.internetshop.entities.Invoice;
import com.example.internetshop.entities.Order;
import com.example.internetshop.entities.Product;
import com.example.internetshop.repositories.*;
import com.fasterxml.jackson.core.io.JsonEOFException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;

@RestController
public class OrderController {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    InvoiceRepository invoiceRepository;
    @Autowired
    DetailRepository detailRepository;
    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/make_order")
    public @ResponseBody
    String makeOrder(@RequestParam int customer_id, @RequestParam int product_id, @RequestParam int quantity) throws Exception {
        JSONObject jsonObject = new JSONObject();

        if(!customerRepository.existsById(customer_id) || !productRepository.existsById(product_id)) {
            jsonObject.put("status", Boolean.FALSE);
            jsonObject.put("invoice_number", -1);
            return jsonObject.toString();
        }else{
            Order order = new Order();
            Product product = productRepository.findById(product_id).get();
            order.setCustomer(customerRepository.findById(customer_id).get());
            order.setDate(new Date(System.currentTimeMillis()));
            Invoice invoice = new Invoice();

            invoice.setAmount(product.getPrice() * quantity);
            invoice.setOrder(order);

            Date issued = new Date(System.currentTimeMillis());
            Calendar c = Calendar.getInstance();
            c.setTime(issued);
            c.add(Calendar.YEAR, 3);
            Date due = new Date(c.getTimeInMillis());

            invoice.setIssued(issued);
            invoice.setDue(due);

            Detail detail = new Detail();

            detail.setOrder(order);
            detail.setProduct(product);

            orderRepository.save(order);
            invoiceRepository.save(invoice);
            detailRepository.save(detail);

            jsonObject.put("status", Boolean.TRUE);
            jsonObject.put("invoice_number", invoice.getId());

            return jsonObject.toString();
        }
    }
    @GetMapping("/order_details_by_id")
    public @ResponseBody String
    getDetailsById(@RequestParam int order_id)throws Exception{
        if(!orderRepository.existsById(order_id))
            return "{\"no_such_order\"}";
        Order order = orderRepository.findById(order_id).get();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("given", order.getDate());

        List<Detail> details = (List)order.getDetails();

        jsonObject.put("details", details);

        Detail detail = details.get(0);
        jsonObject.put("product_name", productRepository.findById(detail.getProduct().getId()).get().getName());

        return jsonObject.toString();

    }

}
