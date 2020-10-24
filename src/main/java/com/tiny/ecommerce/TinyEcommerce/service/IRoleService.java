package com.tiny.ecommerce.TinyEcommerce.service;

import com.tiny.ecommerce.TinyEcommerce.entity.RoleEntity;

public interface IRoleService {

    RoleEntity findbyId(Long id);
    Integer deleteById(Long id);
    RoleEntity add(String roleName);
}
