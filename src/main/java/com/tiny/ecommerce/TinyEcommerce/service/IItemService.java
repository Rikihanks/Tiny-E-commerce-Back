package com.tiny.ecommerce.TinyEcommerce.service;


import com.tiny.ecommerce.TinyEcommerce.entity.ItemEntity;

import java.util.List;

public interface IItemService {

    ItemEntity add(String itemName, Float itemPrice, String itemPictureUrl, String description);

    Integer deleteById(int id);

    List<ItemEntity> findAll();

    ItemEntity update(Long id, String itemName, Float itemPrice, String itemPictureUrl, String description);

    ItemEntity findById(Long id);
}
