package com.transplate.auth.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginDto {
	private String userId;
	private String password;
}
