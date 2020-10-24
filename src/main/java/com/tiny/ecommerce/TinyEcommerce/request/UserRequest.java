package com.tiny.ecommerce.TinyEcommerce.request;

public class UserRequest {

    private Long id;

    private String username;

    private String surname;

    private String dni;

    private String password;

    private String email;

    public UserRequest(Long id, String username, String surname, String dni, String password, String email) {
        this.id = id;
        this.username = username;
        this.surname = surname;
        this.dni = dni;
        this.password = password;
        this.email = email;
    }

    public UserRequest() {

    }

    public String getUsername() {
        return username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
