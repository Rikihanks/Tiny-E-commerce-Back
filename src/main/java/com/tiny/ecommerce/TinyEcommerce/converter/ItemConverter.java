package com.tiny.ecommerce.TinyEcommerce.converter;

import com.tiny.ecommerce.TinyEcommerce.entity.ItemEntity;
import com.tiny.ecommerce.TinyEcommerce.model.ItemModel;

import java.util.ArrayList;
import java.util.List;

public class ItemConverter {

    public static ItemModel convertItemEntityToItemModel(ItemEntity entity) {
        ItemModel model = new ItemModel();
        model.setId(entity.getId());
        model.setItemName(entity.getItemName());
        model.setItemPrice(entity.getItemPrice());
        model.setItemPictureUrl(entity.getItemPictureUrl());
        model.setDescription(entity.getDescription());
        model.setCategory(entity.getCategory());
        return model;
    }

    public static List<ItemModel>  convertItemEntityToItemModel(List<ItemEntity> entities) {
        List<ItemModel> itemModels = new ArrayList<>();
        for (ItemEntity entity : entities) {
            itemModels.add(convertItemEntityToItemModel(entity));
        }
        return itemModels;
    }
}
