package com.example.internetshop.forms;

import org.hibernate.validator.constraints.CreditCardNumber;

import javax.validation.constraints.*;

public class OrderForm {

    @NotBlank(message = "name is required")
    private String name;

    @NotBlank(message = "country is required")
    private String country;

    @Override
    public String toString() {
        return "OrderForm{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", creditCard='" + creditCard + '\'' +
                ", ccExpiration='" + ccExpiration + '\'' +
                ", ccCVV='" + ccCVV + '\'' +
                '}';
    }

    @NotBlank(message = "address is required")
    private String address;
    @NotBlank(message = "phone number is required")
    @Pattern(regexp = "\\\\+\\\\d{3}-\\\\d{2}-\\\\d{3}-\\\\d{2}-\\\\d{2}", message="must be formatted +000-00-000-00-00")
    private String phone;

    @CreditCardNumber(message="not valid credit card number")
    private String creditCard;

    @Pattern(regexp = "^(0[1-9]|1[0-2])([\\\\/])([1-9][0-9])$", message ="expiration date must be formatted MM/YY")
    private String ccExpiration;

    @NotBlank(message = "СVV is required")
    @Digits(integer=3, fraction=0, message="Invalid CVV")
    private String ccCVV;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }

    public String getCcExpiration() {
        return ccExpiration;
    }

    public void setCcExpiration(String ccExpiration) {
        this.ccExpiration = ccExpiration;
    }

    public String getCcCVV() {
        return ccCVV;
    }

    public void setCcCVV(String ccCVV) {
        this.ccCVV = ccCVV;
    }
}
