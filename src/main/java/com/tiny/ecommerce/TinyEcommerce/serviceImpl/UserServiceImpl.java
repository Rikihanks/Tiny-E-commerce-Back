package com.tiny.ecommerce.TinyEcommerce.serviceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.tiny.ecommerce.TinyEcommerce.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.tiny.ecommerce.TinyEcommerce.converter.UserConverter;
import com.tiny.ecommerce.TinyEcommerce.entity.RoleEntity;
import com.tiny.ecommerce.TinyEcommerce.entity.UserEntity;
import com.tiny.ecommerce.TinyEcommerce.model.UserModel;
import com.tiny.ecommerce.TinyEcommerce.repository.UserRepository;
import com.tiny.ecommerce.TinyEcommerce.service.IUserService;

@Service
public class UserServiceImpl implements IUserService, UserDetailsService{

	@Autowired
	@Qualifier("userRepository")
	private UserRepository repository;

	@Autowired
	@Qualifier("roleRepository")
	private RoleRepository roleRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity user = repository.findByUsername(username);
		List<GrantedAuthority> authorities = buildAuthorities(user.getRoles());
		return buildUser(user, authorities);
	}

	@Override
	public UserEntity findByUsername(String userName) {
		UserEntity user = repository.findByUsername(userName);
		return user;
	}

	private UserDetails buildUser(UserEntity user, List<GrantedAuthority> authorities) {
		return new User(user.getUserName(), user.getPassword(), true, true, true, true, authorities);
	}

	private List<GrantedAuthority> buildAuthorities(List<RoleEntity> roles) {
		List<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
		
		for (RoleEntity role : roles) {
			auths.add(new SimpleGrantedAuthority(role.getName()));
		}
		
		return new ArrayList<GrantedAuthority>(auths);
	}

	@Override
	public UserEntity add(String name, String surname, String dni, String password, String email) {
		UserEntity persistedUser = null;
		try {
			UserEntity user = new UserEntity();
			user.setUserName(name);
			user.setSurname(surname);
			user.setDni(dni);
			user.setPassword(passwordEncoder.encode(password));
			user.setEmail(email);

			Optional<RoleEntity> role = roleRepository.findById(999L);

			user.setRoles(Arrays.asList(role.get()));
			persistedUser = repository.save(user);
		}catch (Exception e) {
			System.out.println("error guardando el usuario");
		}
		return persistedUser;
	}

	@Override
	public Integer deleteById(int id) {
		try {
			repository.deleteById(id);
		}catch (Exception e) {
			System.out.println("unable to delete user");
			return null;
		}
		return id;
	}

	@Override
	public List<UserEntity> findAll() {
		List<UserEntity> users = null;
		try {
			users = repository.findAll();
		}catch (Exception e) {
			System.out.println("Unable to retrieve users");
		}
		return users;
	}

	@Override
	public UserEntity update(Long id, String username, String surname, String dni, String password, String email) {
		Optional<UserEntity> optionalUserEntity = repository.findById(id);
		UserEntity entity = null;
		if(optionalUserEntity.isPresent()) {
			entity = optionalUserEntity.get();
			entity.setUserName(username);
			entity.setPassword(passwordEncoder.encode(password));
			entity.setDni(dni);
			entity.setSurname(surname);
			entity.setEmail(email);
		}

		return entity;
	}

	@Override
	public UserEntity findById(Long id) {
		Optional<UserEntity> optionalUserEntity = repository.findById(id);
		UserEntity entity = null;
		if(optionalUserEntity.isPresent()) {
			entity = optionalUserEntity.get();
		}
		return entity;
	}
}
