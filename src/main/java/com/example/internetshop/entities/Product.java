package com.example.internetshop.entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Product {
    public Integer getId() {
        return id;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Category getCategory() {
        return category;
    }
    public String toString(){
        return String.format("product{name : %s, price: %d, category: %s}\n", name, price, category.getName());
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Collection<Detail> getDetails() {
        return details;
    }

    public void setDetails(Collection<Detail> details) {
        this.details = details;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private String description;

    private Integer price;

    private String photo;

    @ManyToOne(optional=false, cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "product")
    private Collection<Detail> details;
}