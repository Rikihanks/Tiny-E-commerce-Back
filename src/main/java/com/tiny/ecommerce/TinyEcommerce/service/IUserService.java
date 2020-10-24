package com.tiny.ecommerce.TinyEcommerce.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tiny.ecommerce.TinyEcommerce.entity.UserEntity;
import com.tiny.ecommerce.TinyEcommerce.model.UserModel;

@Service
public interface IUserService {
	
	UserEntity add(String name, String surname, String dni, String password, String email);
	
	Integer deleteById(int id);

	List<UserEntity> findAll();
	
	UserEntity update(Long id, String username, String surname, String dni, String password, String email);

	UserEntity findById(Long id);

	UserEntity findByUsername(String username);
	
}
