package com.narvee.usit.controller;

import java.security.Principal;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.narvee.usit.entity.User;
import com.narvee.usit.entity.UserRequest;
import com.narvee.usit.entity.UserResponse;
import com.narvee.usit.service.IUserService;
import com.narvee.usit.util.JwtUtil;

@RestController
@RequestMapping("/user")
public class UserRestController {
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private IUserService service;

	@Autowired
	private JwtUtil jwtUtil;

	@PostMapping("/save")
	public ResponseEntity<String> saveUser(@RequestBody User user) {
		Integer id=service.saveUser(user);
		return ResponseEntity.ok("User saved with id"+id);
	}

	@PostMapping("/login")
	public ResponseEntity<UserResponse> loginUser(@RequestBody UserRequest userRequest)
	{

		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
						userRequest.getUsername(),
						userRequest.getPassword()
						)
				);

		String token=jwtUtil.generateToken(userRequest.getUsername());

		return ResponseEntity.ok(new UserResponse(token,"GENERATED T"));
	}

	@GetMapping("/welcome")
	public ResponseEntity<String> accessUserData(Principal p) {
		return ResponseEntity.ok("Hello user:"+p.getName());
	}
	
}
