package com.tiny.ecommerce.TinyEcommerce.converter;

import java.util.ArrayList;
import java.util.List;

import com.tiny.ecommerce.TinyEcommerce.entity.RoleEntity;
import com.tiny.ecommerce.TinyEcommerce.model.RoleModel;

public class RoleConverter {

	public static RoleModel convertRoleEntityToRoleModel(RoleEntity entity)  {
		RoleModel rModel = new RoleModel();
		rModel.setId(entity.getId());
		rModel.setName(entity.getName());
		return rModel;
	}
	
	public static List<RoleModel> convertRoleEntityToRoleModel(List<RoleEntity> entities) {
		List<RoleModel> rModel = new ArrayList<RoleModel>();
		
		entities.forEach(entity -> {
			rModel.add(convertRoleEntityToRoleModel(entity));
		});
		
		return rModel;
	}
}
