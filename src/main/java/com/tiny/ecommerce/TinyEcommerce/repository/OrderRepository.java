package com.tiny.ecommerce.TinyEcommerce.repository;

import com.tiny.ecommerce.TinyEcommerce.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("orderRepository")
public interface OrderRepository extends JpaRepository<OrderEntity, Serializable> {

}
