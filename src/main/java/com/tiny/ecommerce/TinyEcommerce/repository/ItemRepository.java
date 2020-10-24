package com.tiny.ecommerce.TinyEcommerce.repository;

import com.tiny.ecommerce.TinyEcommerce.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("itemRepository")
public interface ItemRepository extends JpaRepository<ItemEntity, Serializable> {
}
