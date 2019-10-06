package com.example.internetshop.entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Date date;
    @ManyToOne(optional=false, cascade=CascadeType.ALL)
    @JoinColumn (name="cust_id")
    private Customer customer;
    @OneToOne(mappedBy = "order")
    private Invoice invoice;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public Collection<Detail> getDetails() {
        return details;
    }

    public void setDetails(Collection<Detail> details) {
        this.details = details;
    }

    @OneToMany(mappedBy = "order")
    private Collection<Detail> details;
}
