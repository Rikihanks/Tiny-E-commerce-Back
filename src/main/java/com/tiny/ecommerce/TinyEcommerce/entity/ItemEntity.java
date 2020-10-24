package com.tiny.ecommerce.TinyEcommerce.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity(name="ITEMS")
public class ItemEntity implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name="item_id", unique = true, nullable = false)
    private Long id;

    @Column(name="name")
    private String itemName;

    @Column(name="price")
    private Float itemPrice;

    @Column(name ="picture_url")
    private String itemPictureUrl;

    @Column(name ="description")
    private String description;

    @Column(name = "category")
    private String category;


    public ItemEntity(Long id, String itemName, Float itemPrice, String itemPictureUrl, String description, String category) {
        this.id = id;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemPictureUrl = itemPictureUrl;
        this.description = description;
        this.category = category;
    }

    public ItemEntity() {
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
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
