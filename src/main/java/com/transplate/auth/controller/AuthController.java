package com.transplate.auth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.transplate.auth.dto.JoinDto;
import com.transplate.auth.dto.LoginDto;
import com.transplate.auth.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
	
	private final UserService userService;
	
	@GetMapping("/login")
	public String login(LoginDto dto) throws Exception {
		String token = userService.login(dto);
		return token; 
	}
	
	@GetMapping("/join")
	public String join(JoinDto dto) throws Exception {
		userService.join(dto);
		return "SUCCESS";
	}
}
