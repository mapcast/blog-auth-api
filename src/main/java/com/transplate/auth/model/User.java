package com.transplate.auth.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rownumber")
    private Long rownumber;
	
	@Column(name = "uuid", nullable = false, unique = true, length = 36)
    private String uuid;
	
	@Column(name = "user_id")
	private String userId;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "user_name")
	private String userName;
	
	@Column(name = "role")
	private String role;
	
	@Column(name = "last_login")
	private Date lastLogin;
	
	@Column(name = "created_time_at")
	@CreationTimestamp
	private Date createdTimeAt;
}
