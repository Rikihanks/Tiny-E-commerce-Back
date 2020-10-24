package com.tiny.ecommerce.TinyEcommerce.model;


import java.util.List;

public class OrderModel {

    private Long id;

    private String country;

    private String address;

    private String creditCardNumber;

    private UserModel user;

    private Boolean processed;

    private List<ItemModel> items;

    private String postalCode;

    public OrderModel(Long id, String country, String address, String creditCardNumber, UserModel user, Boolean processed, List<ItemModel> items, String postalCode) {
        this.country = country;
        this.address = address;
        this.creditCardNumber = creditCardNumber;
        this.user = user;
        this.processed = processed;
        this.items = items;
        this.postalCode = postalCode;
        this.id = id;
    }

    public OrderModel() {
    }

    public String getPostalCode() {
        return postalCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
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

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public Boolean getProcessed() {
        return processed;
    }

    public void setProcessed(Boolean processed) {
        this.processed = processed;
    }

    public List<ItemModel> getItems() {
        return items;
    }

    public void setItems(List<ItemModel> items) {
        this.items = items;
    }
}
