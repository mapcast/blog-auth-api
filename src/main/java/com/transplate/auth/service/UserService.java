package com.transplate.auth.service;

import com.transplate.auth.dto.JoinDto;
import com.transplate.auth.dto.LoginDto;
import com.transplate.auth.model.User;

public interface UserService {

	boolean join(JoinDto dto) throws Exception;

	String login(LoginDto dto) throws Exception;

	User getUserByUserId(String userId);

}
