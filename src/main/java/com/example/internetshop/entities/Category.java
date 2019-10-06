package com.example.internetshop.entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    @OneToMany(mappedBy = "category")
    private Collection<Product> product;

    public Integer getId() {
        return id;
    }
    public String toString(){
        return name;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Product> getProduct() {
        return product;
    }

    public void setProduct(Collection<Product> product) {
        this.product = product;
    }
}
