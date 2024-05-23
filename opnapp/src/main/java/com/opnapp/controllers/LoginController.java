package com.opnapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.opnapp.services.LoginService;
import com.opnapp.utilities.User;
import com.opnapp.utilities.UserInfo;

@CrossOrigin("http://localhost:4200/")
@RestController
@RequestMapping("/login")
public class LoginController {
	@Autowired
	private final LoginService loginService;
	
	LoginController(LoginService loginService){
		this.loginService=loginService;
	}
	
	@PostMapping("/auth")
	public ResponseEntity<UserInfo> authUser(@RequestBody User user) {
		UserInfo userInfo = loginService.authUser(user.getUserType(),user.getEmail(),user.getPassword());
		return ResponseEntity.ok(userInfo);
	}
}
