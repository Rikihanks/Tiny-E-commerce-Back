package com.tiny.ecommerce.TinyEcommerce.service;

import com.tiny.ecommerce.TinyEcommerce.entity.ItemEntity;
import com.tiny.ecommerce.TinyEcommerce.entity.OrderEntity;
import com.tiny.ecommerce.TinyEcommerce.entity.UserEntity;

import java.util.List;

public interface IOrderService {

    OrderEntity add(String country, String address, String creditCardNumber, UserEntity user, Boolean processed, List<ItemEntity> items, String postalCode);

    Integer deleteById(int id);

    List<OrderEntity> findAll();

    OrderEntity update(Long id, String country, String address, String creditCardNumber, UserEntity user, Boolean processed, List<ItemEntity> items);

    OrderEntity findById(Long id);
}
