package com.tiny.ecommerce.TinyEcommerce.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity(name="USERS")
public class UserEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8683183059249081842L;

	@Id
	@GeneratedValue
	@Column(name="user_id", unique = true, nullable = false)
	private Long id;

	@Column(name="username", unique=true, nullable=false)
	private String username;
	
	@Column
	private String surname;
	
	@Column(name="password", nullable=false)
	private String password;
	
	@Column
	private String dni;

	@Column
	private String email;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_role",
			joinColumns = {@JoinColumn(name = "user_id")},
			inverseJoinColumns = {@JoinColumn(name = "role_id")})
	private List<RoleEntity> roles;

	public UserEntity() {}

	public UserEntity(Long id, String username, String surname, String password, String dni, String email, List<RoleEntity> roles) {
		this.id = id;
		this.username = username;
		this.surname = surname;
		this.password = password;
		this.dni = dni;
		this.email = email;
		this.roles = roles;
	}

	public String getUserName() {
		return username;
	}

	public void setUserName(String username) {
		this.username = username;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public List<RoleEntity> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleEntity> roles) {
		this.roles = roles;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
