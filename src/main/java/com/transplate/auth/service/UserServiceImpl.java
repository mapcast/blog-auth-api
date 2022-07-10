package com.transplate.auth.service;

import java.util.Optional;
import java.util.UUID;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;

import com.transplate.auth.dto.JoinDto;
import com.transplate.auth.dto.LoginDto;
import com.transplate.auth.model.User;
import com.transplate.auth.repository.UserRepository;
import com.transplate.auth.util.EncryptionUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
	
	private final UserRepository userRepository;
	
	private final EncryptionUtil encryptionUtil;
	
	@Override
	public boolean join(JoinDto dto) {
		try {
			User user = new User();
			user.setUuid(UUID.randomUUID().toString());
			user.setUserId(dto.getUserId());
			user.setPassword(encryptionUtil.encrypt(dto.getPassword()));
			userRepository.save(user);
			return true;
		} catch(Exception e) {
			return false;
		}
	}
	
	@Override
	public String login(LoginDto dto) throws Exception {
		Optional<User> wrapped = userRepository.findByUserIdAndUserPassword(dto.getUserId(), encryptionUtil.encrypt(dto.getPassword()));
		if(wrapped.isPresent()) {
			
			return "";
		} else {
			return "LoginFailed";
		}
	}
}
