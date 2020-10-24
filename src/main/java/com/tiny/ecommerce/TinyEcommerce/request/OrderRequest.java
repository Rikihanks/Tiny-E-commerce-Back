package com.tiny.ecommerce.TinyEcommerce.request;


import java.util.List;

public class OrderRequest {

    private Long id;

    private String country;

    private String address;

    private String creditCardNumber;

    private Long userId;

    private Boolean processed;

    private List<Long> itemIds;

    private String postalCode;

    public OrderRequest(Long id, String country, String address, String creditCardNumber, Long userId, Boolean processed, List<Long> itemIds, String postalCode) {
        this.country = country;
        this.address = address;
        this.creditCardNumber = creditCardNumber;
        this.userId = userId;
        this.processed = processed;
        this.itemIds = itemIds;
        this.postalCode = postalCode;
        this.id = id;
    }

    public OrderRequest() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPostalCode() {
        return postalCode;
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Boolean getProcessed() {
        return processed;
    }

    public void setProcessed(Boolean processed) {
        this.processed = processed;
    }

    public List<Long> getItemIds() {
        return itemIds;
    }

    public void setItemIds(List<Long> itemIds) {
        this.itemIds = itemIds;
    }
}
