package com.tiny.ecommerce.TinyEcommerce.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tiny.ecommerce.TinyEcommerce.entity.UserEntity;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<UserEntity, Serializable>{

	UserEntity findByUsername(String name);
	
}
