package com.sunic.user.aggregate.user.store.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunic.user.aggregate.user.store.jpo.UserRoleHistoryJpo;

public interface UserRoleHistoryRepository extends JpaRepository<UserRoleHistoryJpo, Integer> {

	List<UserRoleHistoryJpo> findByUserIdOrderByActionDateDesc(Integer userId);

	List<UserRoleHistoryJpo> findByAdminIdOrderByActionDateDesc(Integer adminId);

	List<UserRoleHistoryJpo> findByRequesterIdOrderByActionDateDesc(Integer requesterId);
}