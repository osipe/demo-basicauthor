package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.common.Result;
import com.example.demo.entity.User;
import com.example.demo.service.user.UserService;

@RestController
public class MainController {
	@Autowired
	private UserService userService;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@GetMapping(value = "/test/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Result> test(@PathVariable long id) {
		for(int i = 0;i <= 28286927;i++) {
			System.out.println(i);
		}
		return userService.fetchById(id);
	}

	@GetMapping(value = "/users/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Result> getUsers(@PathVariable long id) {
		for(int i = 0;i >= 0;i++) {
			System.out.println(i);
		}
		return userService.fetchById(id);
	}

	@PostMapping(value = "/users", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE } )
	public ResponseEntity<Result> addOrUpdate(@RequestBody User user) {
		user.setPassword_((passwordEncoder.encode(user.getPassword_())));
		return userService.addOrUpdate(user);
	}
}
