package com.sunic.user.aggregate.user.store.jpo;

import java.time.LocalDateTime;

import com.sunic.user.spec.user.entity.Role;
import com.sunic.user.spec.user.entity.UserRoleHistory;
import com.sunic.user.spec.user.entity.UserRoleHistoryType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user_role_history")
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class UserRoleHistoryJpo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "user_id", nullable = false)
	private Integer userId;

	@Enumerated(EnumType.STRING)
	@Column(name = "role", nullable = false)
	private Role role;

	@Enumerated(EnumType.STRING)
	@Column(name = "action_type", nullable = false)
	private UserRoleHistoryType actionType;

	@Column(name = "admin_id", nullable = false)
	private Integer adminId;

	@Column(name = "requester_id", nullable = false)
	private Integer requesterId;

	@Column(name = "action_date", nullable = false)
	private LocalDateTime actionDate;

	public static UserRoleHistoryJpo fromDomain(UserRoleHistory userRoleHistory) {
		return UserRoleHistoryJpo.builder()
			.id(userRoleHistory.getId())
			.userId(userRoleHistory.getUserId())
			.role(userRoleHistory.getRole())
			.actionType(userRoleHistory.getActionType())
			.adminId(userRoleHistory.getAdminId())
			.requesterId(userRoleHistory.getRequesterId())
			.actionDate(userRoleHistory.getActionDate())
			.build();
	}

	public UserRoleHistory toDomain() {
		return UserRoleHistory.builder()
			.id(this.id)
			.userId(this.userId)
			.role(this.role)
			.actionType(this.actionType)
			.adminId(this.adminId)
			.requesterId(this.requesterId)
			.actionDate(this.actionDate)
			.build();
	}
}