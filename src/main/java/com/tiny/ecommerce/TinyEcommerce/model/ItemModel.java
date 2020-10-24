package com.tiny.ecommerce.TinyEcommerce.model;


import javax.persistence.Column;

public class ItemModel {

    private Long id;

    private String itemName;

    private Float itemPrice;

    private String itemPictureUrl;

    private String description;

    private String category;


    public ItemModel() {
    }

    public ItemModel(Long id, String itemName, Float itemPrice, String itemPictureUrl, String description, String category) {
        this.id = id;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemPictureUrl = itemPictureUrl;
        this.description = description;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Float getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Float itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getItemPictureUrl() {
        return itemPictureUrl;
    }

    public void setItemPictureUrl(String itemPictureUrl) {
        this.itemPictureUrl = itemPictureUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
