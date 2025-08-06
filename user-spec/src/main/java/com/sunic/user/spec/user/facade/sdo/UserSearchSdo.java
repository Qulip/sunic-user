package com.sunic.user.spec.user.facade.sdo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class UserSearchSdo {
	private Integer adminId;
	private String name;
	private String email;
	private String phone;
	private Integer workspaceId;
}