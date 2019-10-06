package com.example.internetshop.entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer amount;

    private Date issued;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Date getIssued() {
        return issued;
    }

    public void setIssued(Date issued) {
        this.issued = issued;
    }

    public Date getDue() {
        return due;
    }

    public void setDue(Date due) {
        this.due = due;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Collection<Payment> getPayment() {
        return payment;
    }

    public void setPayment(Collection<Payment> payment) {
        this.payment = payment;
    }

    private Date due;

    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "ord_id")
    private Order order;

    @OneToMany(mappedBy = "invoice")
    private Collection<Payment> payment;
}
