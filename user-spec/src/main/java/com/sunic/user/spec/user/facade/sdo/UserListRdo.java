package com.sunic.user.spec.user.facade.sdo;

import java.time.LocalDateTime;

import com.sunic.user.spec.user.entity.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class UserListRdo {
	private Integer id;
	private String email;
	private String name;
	private String phone;
	private String birthYear;
	private Integer gender;
	private Role role;
	private Integer loginFailCount;
	private LocalDateTime lastLoginTime;
	private LocalDateTime lastLoginFailTime;
	private UserProfileRdo userProfile;
}