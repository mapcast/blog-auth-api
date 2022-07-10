package com.transplate.auth.service;

import com.transplate.auth.dto.JoinDto;
import com.transplate.auth.dto.LoginDto;

public interface UserService {

	boolean join(JoinDto dto);

	String login(LoginDto dto) throws Exception;

}
