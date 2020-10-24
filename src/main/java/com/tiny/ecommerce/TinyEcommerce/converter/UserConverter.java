package com.tiny.ecommerce.TinyEcommerce.converter;

import java.util.ArrayList;
import java.util.List;

import com.tiny.ecommerce.TinyEcommerce.entity.UserEntity;
import com.tiny.ecommerce.TinyEcommerce.model.UserModel;

public class UserConverter {

	public static UserModel convertUserEntityToUserModel(UserEntity entity) {
		UserModel model = new UserModel();
		model.setId(entity.getId());
		model.setUsername(entity.getUsername());
		model.setSurname(entity.getSurname());
		model.setDni(entity.getDni());
		model.setRoles(RoleConverter.convertRoleEntityToRoleModel(entity.getRoles()));
		model.setEmail(entity.getEmail());
		return model;
	}
	
	public static List<UserModel> convertUserEntityToUserModel(List<UserEntity> entities) {
		List<UserModel> userModel = new ArrayList<UserModel>();
		
		entities.forEach(entity -> {
			userModel.add(convertUserEntityToUserModel(entity));
		});
		
		return userModel;
	}
}
