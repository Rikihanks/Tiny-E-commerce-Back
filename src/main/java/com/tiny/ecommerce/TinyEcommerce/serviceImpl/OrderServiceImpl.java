package com.tiny.ecommerce.TinyEcommerce.serviceImpl;

import com.tiny.ecommerce.TinyEcommerce.entity.ItemEntity;
import com.tiny.ecommerce.TinyEcommerce.entity.OrderEntity;
import com.tiny.ecommerce.TinyEcommerce.entity.UserEntity;
import com.tiny.ecommerce.TinyEcommerce.repository.OrderRepository;
import com.tiny.ecommerce.TinyEcommerce.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    @Qualifier("orderRepository")
    private OrderRepository repository;

    @Override
    public OrderEntity add(String country, String address, String creditCardNumber, UserEntity user, Boolean processed, List<ItemEntity> items, String postalCode) {
        OrderEntity persistedEntity = null;
        try{
            OrderEntity entity = new OrderEntity();
            entity.setCountry(country);
            entity.setAddress(address);
            entity.setCreditCardNumber(creditCardNumber);
            entity.setUser(user);
            entity.setProcessed(processed);
            entity.setItems(items);
            entity.setPostalCode(postalCode);
            persistedEntity = repository.save(entity);
        }catch (Exception e) {
            System.out.println("unable to persist order");
        }

        return persistedEntity;
    }

    @Override
    public Integer deleteById(int id) {
        try {
            repository.deleteById(id);
        }catch (Exception e) {
            System.out.println("unable to delete order");
            return null;
        }
        return id;
    }

    @Override
    public List<OrderEntity> findAll() {
        List<OrderEntity> orders = null;
        try {
            orders = repository.findAll();
        }catch (Exception e) {
            System.out.println("Unable to retrieve items");
        }
        return orders;
    }

    @Override
    public OrderEntity update(Long id, String country, String address, String creditCardNumber, UserEntity user, Boolean processed, List<ItemEntity> items) {
        Optional<OrderEntity> optionalOrderEntity = repository.findById(id);
        OrderEntity entity = null;
        OrderEntity persistedEntity = null;
        if(optionalOrderEntity.isPresent()) {
            entity = optionalOrderEntity.get();
            entity.setCountry(country);
            entity.setAddress(address);
            entity.setCreditCardNumber(creditCardNumber);
            entity.setUser(user);
            entity.setProcessed(processed);
            entity.setItems(items);
        }
        persistedEntity = repository.save(entity);
        return persistedEntity;
    }

    @Override
    public OrderEntity findById(Long id) {
        Optional<OrderEntity> optionalOrderEntity = repository.findById(id);
        OrderEntity entity = null;
        if(optionalOrderEntity.isPresent()) {
            entity = optionalOrderEntity.get();
        }
        return entity;
    }
}
