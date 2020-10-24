package com.tiny.ecommerce.TinyEcommerce.controller;

import com.tiny.ecommerce.TinyEcommerce.converter.ItemConverter;
import com.tiny.ecommerce.TinyEcommerce.converter.UserConverter;
import com.tiny.ecommerce.TinyEcommerce.entity.ItemEntity;
import com.tiny.ecommerce.TinyEcommerce.entity.UserEntity;
import com.tiny.ecommerce.TinyEcommerce.model.ItemModel;
import com.tiny.ecommerce.TinyEcommerce.model.UserModel;
import com.tiny.ecommerce.TinyEcommerce.request.ItemRequest;
import com.tiny.ecommerce.TinyEcommerce.request.UserRequest;
import com.tiny.ecommerce.TinyEcommerce.service.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/private/items")
@CrossOrigin(origins = "http://localhost:4200")
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ItemController {

    @Qualifier("itemServiceImpl")
    @Autowired
    private IItemService itemService;

    @GetMapping("getItems")
    public ResponseEntity<List<ItemModel>> getAllItems() {
        HttpHeaders headers = new HttpHeaders();

        List<ItemEntity> response = itemService.findAll();

        return ResponseEntity.accepted().headers(headers).body(ItemConverter.convertItemEntityToItemModel(response));
    }

    @GetMapping("getItemById")
    public ResponseEntity<ItemModel> getEntityById(@RequestParam Long id) {
        HttpHeaders headers = new HttpHeaders();

        ItemEntity response = itemService.findById(id);

        return ResponseEntity.accepted().headers(headers).body(ItemConverter.convertItemEntityToItemModel(response));
    }

    @PostMapping(path = "createItem", consumes = "application/json", produces = "application/json")
    public ResponseEntity<ItemModel> createItem(@RequestBody ItemRequest itemRequest) {
        HttpHeaders headers = new HttpHeaders();
        ItemEntity persistedItem = null;
        try {
            persistedItem =	itemService.add(itemRequest.getItemName(), itemRequest.getItemPrice(), itemRequest.getItemPictureUrl(), itemRequest.getDescription());
        }catch (Exception e) {
            System.out.println("unable to persist user");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
        return ResponseEntity.accepted().headers(headers).body(ItemConverter.convertItemEntityToItemModel(persistedItem));
    }
}
