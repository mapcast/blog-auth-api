package com.transplate.auth.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JoinDto {
	private String userId;
	private String password;
	private String userName;
}
