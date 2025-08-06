package com.sunic.user.aggregate.user.store.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sunic.user.aggregate.user.store.jpo.UserJpo;
import com.sunic.user.spec.user.entity.Role;

public interface UserRepository extends JpaRepository<UserJpo, Integer> {
	boolean existsByEmail(String email);

	Optional<UserJpo> findByEmail(String email);

	@Query("SELECT u FROM UserJpo u WHERE u.lastLoginTime < :oneYearAgo OR u.lastLoginTime IS NULL")
	List<UserJpo> findUsersInactiveForMoreThanOneYear(@Param("oneYearAgo") LocalDateTime oneYearAgo);

    List<UserJpo> findByRoleNot(Role role);

    @Query("SELECT DISTINCT u FROM UserJpo u LEFT JOIN u.userWorkspaces uw " +
        "WHERE u.role != :excludeRole " +
        "AND (:name IS NULL OR LOWER(u.name) LIKE LOWER(CONCAT('%', :name, '%'))) " +
        "AND (:email IS NULL OR LOWER(u.email) LIKE LOWER(CONCAT('%', :email, '%'))) " +
        "AND (:phone IS NULL OR u.phone LIKE CONCAT('%', :phone, '%')) " +
        "AND (:workspaceId IS NULL OR uw.id = :workspaceId)")
    List<UserJpo> searchNonAdminUsers(
        @Param("excludeRole") Role excludeRole,
        @Param("name") String name,
        @Param("email") String email,
        @Param("phone") String phone,
        @Param("workspaceId") Integer workspaceId
    );
}