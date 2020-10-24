package com.tiny.ecommerce.TinyEcommerce.model;

import java.util.List;

import com.tiny.ecommerce.TinyEcommerce.entity.RoleEntity;

public class UserModel {

	private Long id;

	private String username;
	
	private String surname;

	private String dni;

	private List<RoleModel> roles;

	private String email;

	public UserModel() {}

	public UserModel(Long id, String username, String surname, String dni, List<RoleModel> roles, String email) {
		this.id = id;
		this.username = username;
		this.surname = surname;
		this.dni = dni;
		this.roles = roles;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public List<RoleModel> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleModel> roles) {
		this.roles = roles;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
