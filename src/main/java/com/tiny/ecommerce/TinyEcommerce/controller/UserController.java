package com.tiny.ecommerce.TinyEcommerce.controller;

import java.util.List;

import com.tiny.ecommerce.TinyEcommerce.converter.UserConverter;
import com.tiny.ecommerce.TinyEcommerce.entity.UserEntity;
import com.tiny.ecommerce.TinyEcommerce.request.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.tiny.ecommerce.TinyEcommerce.model.UserModel;
import com.tiny.ecommerce.TinyEcommerce.service.IUserService;

@Controller
@RequestMapping("/private/users")
@CrossOrigin(origins = "http://localhost:4200")
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class UserController {

	@Qualifier("userServiceImpl")
	@Autowired
	private IUserService userService;
	
	@GetMapping("getUsers")
	public ResponseEntity<List<UserModel>> getAllUsers() {
		HttpHeaders headers = new HttpHeaders();
		
		List<UserEntity> response = userService.findAll();
        
        return ResponseEntity.accepted().headers(headers).body(UserConverter.convertUserEntityToUserModel(response));
	}
	
	@GetMapping("getUsersById")
	public ResponseEntity<UserModel> getUserById(@RequestParam Long id) {
		HttpHeaders headers = new HttpHeaders();
		
		UserEntity response = userService.findById(id);

        return ResponseEntity.accepted().headers(headers).body(UserConverter.convertUserEntityToUserModel(response));
	}

    @GetMapping(value = "currentUser")
    public ResponseEntity<Object> getCurrentUser(){
        final Authentication auth= SecurityContextHolder.getContext().getAuthentication();
        if(!(auth instanceof AnonymousAuthenticationToken)) {
        	HttpHeaders headers = new HttpHeaders();
        	 return ResponseEntity.accepted().headers(headers).body(auth.getPrincipal());
        }else {
        	 return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }

    }

	@GetMapping(value = "getUserDetails")
	public ResponseEntity<UserModel> getUserDetails(@RequestParam String userName){
		try {
			HttpHeaders headers = new HttpHeaders();
			UserEntity userEntity = null;
			userEntity = userService.findByUsername(userName);
			return ResponseEntity.accepted().headers(headers).body(UserConverter.convertUserEntityToUserModel(userEntity));
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}

	}



	@PostMapping(path = "createUser", consumes = "application/json", produces = "application/json")
	public ResponseEntity<UserModel> createUser(@RequestBody UserRequest userRequest) {
		HttpHeaders headers = new HttpHeaders();
		UserEntity persistedUser = null;
		try {
			persistedUser =	userService.add(userRequest.getUsername(), userRequest.getSurname(), userRequest.getDni(), userRequest.getPassword(), userRequest.getEmail());
		}catch (Exception e) {
			System.out.println("unable to persist user");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
		return ResponseEntity.accepted().headers(headers).body(UserConverter.convertUserEntityToUserModel(persistedUser));
	}
}
