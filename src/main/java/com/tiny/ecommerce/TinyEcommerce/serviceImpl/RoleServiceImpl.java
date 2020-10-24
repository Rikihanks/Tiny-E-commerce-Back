package com.tiny.ecommerce.TinyEcommerce.serviceImpl;

import com.tiny.ecommerce.TinyEcommerce.entity.RoleEntity;
import com.tiny.ecommerce.TinyEcommerce.repository.RoleRepository;
import com.tiny.ecommerce.TinyEcommerce.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleServiceImpl  implements IRoleService {

    @Autowired
    @Qualifier("roleRepository")
    private RoleRepository repository;

    @Override
    public RoleEntity findbyId(Long id) {
        RoleEntity entity = null;
        Optional<RoleEntity> role = repository.findById(id);
        if(role.isPresent()) {
            entity = role.get();
        }
        return entity;

    }

    @Override
    public Integer deleteById(Long id) {
        try {
            repository.deleteById(id);
        }catch (Exception e) {
            System.out.println("unable to delete role");
            return null;
        }
        return id.intValue();
    }

    @Override
    public RoleEntity add(String name) {
        RoleEntity persistedRole = null;
        try {
            RoleEntity role = new RoleEntity();
            role.setName(name);
            persistedRole = repository.save(role);
        }catch (Exception e) {
            System.out.println("unable to save role");
        }
        return persistedRole;
    }
}
