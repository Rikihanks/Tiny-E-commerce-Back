package com.tiny.ecommerce.TinyEcommerce.converter;

import com.tiny.ecommerce.TinyEcommerce.entity.OrderEntity;
import com.tiny.ecommerce.TinyEcommerce.model.OrderModel;

import java.util.ArrayList;
import java.util.List;

public class OrderConverter {

    public static OrderModel convertOrderEntityToOrderModel(OrderEntity entity) {
        OrderModel orderModel = new OrderModel();
        orderModel.setId(entity.getId());
        orderModel.setAddress(entity.getAddress());
        orderModel.setCountry(entity.getCountry());
        orderModel.setCreditCardNumber(entity.getCreditCardNumber());
        orderModel.setItems(ItemConverter.convertItemEntityToItemModel(entity.getItems()));
        orderModel.setProcessed(entity.getProcessed());
        orderModel.setUser(UserConverter.convertUserEntityToUserModel(entity.getUser()));
        orderModel.setPostalCode(entity.getPostalCode());
        return orderModel;
    }

    public static List<OrderModel> convertOrderEntityToOrderModel(List<OrderEntity> entities) {
        List<OrderModel> orderModels = new ArrayList<>();
        for (OrderEntity entity : entities) {
            orderModels.add(convertOrderEntityToOrderModel(entity));
        }
        return orderModels;
    }
}
