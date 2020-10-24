package com.tiny.ecommerce.TinyEcommerce.repository;

import com.tiny.ecommerce.TinyEcommerce.entity.RoleEntity;
import com.tiny.ecommerce.TinyEcommerce.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("roleRepository")
public interface RoleRepository extends JpaRepository<RoleEntity, Serializable>{
	
}
