package com.tiny.ecommerce.TinyEcommerce.serviceImpl;

import com.tiny.ecommerce.TinyEcommerce.entity.ItemEntity;
import com.tiny.ecommerce.TinyEcommerce.entity.UserEntity;
import com.tiny.ecommerce.TinyEcommerce.repository.ItemRepository;
import com.tiny.ecommerce.TinyEcommerce.repository.UserRepository;
import com.tiny.ecommerce.TinyEcommerce.service.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl  implements IItemService {

    @Autowired
    @Qualifier("itemRepository")
    private ItemRepository repository;


    @Override
    public ItemEntity add(String itemName, Float itemPrice, String itemPictureUrl, String description) {
        ItemEntity persistedEntity = null;
        try{
            ItemEntity entity = new ItemEntity();
            entity.setItemName(itemName);
            entity.setDescription(description);
            entity.setItemPictureUrl(itemPictureUrl);
            entity.setItemPrice(itemPrice);
            persistedEntity = repository.save(entity);
        }catch (Exception e) {
            System.out.println("unable to persist item");
        }

        return persistedEntity;
    }

    @Override
    public Integer deleteById(int id) {
        try {
            repository.deleteById(id);
        }catch (Exception e) {
            System.out.println("unable to delete user");
            return null;
        }
        return id;
    }

    @Override
    public List<ItemEntity> findAll() {
        List<ItemEntity> items = null;
        try {
            items = repository.findAll();
        }catch (Exception e) {
            System.out.println("Unable to retrieve items");
        }
        return items;
    }

    @Override
    public ItemEntity update(Long id,  String itemName, Float itemPrice, String itemPictureUrl, String description) {
        Optional<ItemEntity> optionalItemEntity = repository.findById(id);
        ItemEntity entity = null;
        if(optionalItemEntity.isPresent()) {
            entity = optionalItemEntity.get();
            entity.setItemName(itemName);
            entity.setItemPrice(itemPrice);
            entity.setItemPictureUrl(itemPictureUrl);
            entity.setDescription(description);
        }

        return entity;
    }

    @Override
    public ItemEntity findById(Long id) {
        Optional<ItemEntity> optionalItemEntity = repository.findById(id);
        ItemEntity entity = null;
        if(optionalItemEntity.isPresent()) {
            entity = optionalItemEntity.get();
        }
        return entity;
    }
}
