package com.sunic.user.spec.user.entity;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class UserRoleHistory {
	private Integer id;
	private Integer userId;
	private Role role;
	private UserRoleHistoryType actionType;
	private Integer adminId;
	private Integer requesterId;
	private LocalDateTime actionDate;

	public static UserRoleHistory create(Integer userId, Role role, UserRoleHistoryType actionType, Integer adminId,
		Integer requesterId) {
		return UserRoleHistory.builder()
			.userId(userId)
			.role(role)
			.actionType(actionType)
			.adminId(adminId)
			.requesterId(requesterId)
			.actionDate(LocalDateTime.now())
			.build();
	}
}
