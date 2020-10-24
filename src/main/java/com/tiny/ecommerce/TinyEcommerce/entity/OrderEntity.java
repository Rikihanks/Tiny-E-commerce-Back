package com.tiny.ecommerce.TinyEcommerce.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity(name="ORDERS")
public class OrderEntity implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name="order_id", unique = true, nullable = false)
    private Long id;

    @Column(name = "country")
    private String country;

    @Column(name = "address")
    private String address;

    @Column(name = "credit_card_number")
    private String creditCardNumber;

    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private UserEntity user;

    @Column(name="processed")
    private Boolean processed;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "order_item",
            joinColumns = {@JoinColumn(name = "order_id")},
            inverseJoinColumns = {@JoinColumn(name = "item_id")})
    private List<ItemEntity> items;

    @Column(name="postal_code")
    private String postalCode;


    public OrderEntity() {
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public Boolean getProcessed() {
        return processed;
    }

    public void setProcessed(Boolean processed) {
        this.processed = processed;
    }

    public List<ItemEntity> getItems() {
        return items;
    }

    public void setItems(List<ItemEntity> items) {
        this.items = items;
    }
}
