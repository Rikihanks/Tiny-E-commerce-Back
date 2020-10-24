package com.tiny.ecommerce.TinyEcommerce.controller;

import com.tiny.ecommerce.TinyEcommerce.converter.OrderConverter;
import com.tiny.ecommerce.TinyEcommerce.entity.ItemEntity;
import com.tiny.ecommerce.TinyEcommerce.entity.OrderEntity;
import com.tiny.ecommerce.TinyEcommerce.entity.UserEntity;
import com.tiny.ecommerce.TinyEcommerce.model.OrderModel;
import com.tiny.ecommerce.TinyEcommerce.request.OrderRequest;
import com.tiny.ecommerce.TinyEcommerce.service.IItemService;
import com.tiny.ecommerce.TinyEcommerce.service.IOrderService;
import com.tiny.ecommerce.TinyEcommerce.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/private/orders")
@CrossOrigin(origins = "http://localhost:4200")
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class OrderController {

    @Qualifier("orderServiceImpl")
    @Autowired
    private IOrderService orderService;

    @Qualifier("userServiceImpl")
    @Autowired
    private IUserService userService;

    @Qualifier("itemServiceImpl")
    @Autowired
    private IItemService itemService;

    HttpHeaders headers = new HttpHeaders();

    @GetMapping("getOrders")
    public ResponseEntity<List<OrderModel>> getAllOrders() {

        List<OrderEntity> response = orderService.findAll();

        return ResponseEntity.accepted().headers(headers).body(OrderConverter.convertOrderEntityToOrderModel(response));
    }

    @GetMapping("getOrderById")
    public ResponseEntity<OrderModel> getOrderById(@RequestParam Long id) {

        OrderEntity response = orderService.findById(id);

        return ResponseEntity.accepted().headers(headers).body(OrderConverter.convertOrderEntityToOrderModel(response));
    }

    @PostMapping(path = "createOrder", consumes = "application/json", produces = "application/json")
    public ResponseEntity<OrderModel> createOrder(@RequestBody OrderRequest orderRequest) {
        OrderEntity persistedOrder = null;
        try {
            UserEntity orderUser = userService.findById(orderRequest.getUserId());;
            List<ItemEntity> orderItems = new ArrayList<>();
            orderRequest.getItemIds().forEach(itemId -> orderItems.add(itemService.findById(itemId)));

            persistedOrder = orderService.add(orderRequest.getCountry(), orderRequest.getAddress(), orderRequest.getCreditCardNumber(),
                    orderUser, false, orderItems, orderRequest.getPostalCode());
        }catch (Exception e) {
            System.out.println("unable to persist order");
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
        return ResponseEntity.accepted().headers(headers).body(OrderConverter.convertOrderEntityToOrderModel(persistedOrder));
    }

    @PostMapping(path = "updateOrder", consumes = "application/json", produces = "application/json")
    public ResponseEntity<OrderModel> updateOrder(@RequestBody OrderRequest orderRequest) {
        OrderEntity updatedOrder = null;
        try {
            UserEntity orderUser = userService.findById(orderRequest.getUserId());;
            List<ItemEntity> orderItems = new ArrayList<>();
            orderRequest.getItemIds().forEach(itemId -> orderItems.add(itemService.findById(itemId)));

            updatedOrder = orderService.update(orderRequest.getId(), orderRequest.getCountry(), orderRequest.getAddress(), orderRequest.getCreditCardNumber(),
                    orderUser, orderRequest.getProcessed(), orderItems);
        }catch (Exception e) {
            System.out.println("unable to update order");
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
        return ResponseEntity.accepted().headers(headers).body(OrderConverter.convertOrderEntityToOrderModel(updatedOrder));
    }

}
