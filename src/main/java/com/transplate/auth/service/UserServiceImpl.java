package com.transplate.auth.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.transplate.auth.dto.JoinDto;
import com.transplate.auth.dto.LoginDto;
import com.transplate.auth.model.User;
import com.transplate.auth.repository.UserRepository;
import com.transplate.auth.util.EncryptionUtil;
import com.transplate.auth.util.TokenUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
	
	private final UserRepository userRepository;
	
	private final EncryptionUtil encryptionUtil;
	
	private final TokenUtil tokenUtil;
	
	@Override
	public String login(LoginDto dto) throws Exception {
		Optional<User> wrapped = userRepository.findByUserIdAndPasswordAndIsDeletedFalse(dto.getUserId(), encryptionUtil.encrypt(dto.getPassword()));
		if(wrapped.isPresent()) {
			return tokenUtil.generateToken(wrapped.get());
		} else {
			return "LoginFailed";
		}
	}
	
	@Override
	public boolean join(JoinDto dto) throws Exception {
		Optional<User> wrapped = userRepository.findByUserIdAndIsDeletedFalse(dto.getUserId());
		if(!wrapped.isPresent()) {
			User user = new User();
			user.setUuid(UUID.randomUUID().toString());
			user.setUserId(dto.getUserId());
			user.setPassword(encryptionUtil.encrypt(dto.getPassword()));
			user.setRole("ROLE_USER");
			userRepository.save(user);
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public User getUserByUserId(String userId) {
		return userRepository.findByUserIdAndIsDeletedFalse(userId).orElseGet(null);
	}
}
