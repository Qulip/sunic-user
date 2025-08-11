package com.sunic.user.spec.user.facade;

import org.springframework.http.ResponseEntity;

import com.sunic.user.spec.common.CommonResponse;
import com.sunic.user.spec.user.facade.sdo.UserActivateSdo;
import com.sunic.user.spec.user.facade.sdo.UserDeactivateByAdminSdo;
import com.sunic.user.spec.user.facade.sdo.UserJoinSdo;
import com.sunic.user.spec.user.facade.sdo.UserLoginSdo;
import com.sunic.user.spec.user.facade.sdo.UserRegisterSdo;
import com.sunic.user.spec.user.facade.sdo.UserSearchSdo;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "User API", description = "register, login, join workspace etc")
public interface UserFacade {

	@Operation(summary = "register", description = "register API")
	@ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Success")})
	ResponseEntity<CommonResponse> registerUser(UserRegisterSdo userRegisterSdo);

	@Operation(summary = "login", description = "login API")
	@ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Success")})
	ResponseEntity<CommonResponse> loginUser(UserLoginSdo userLoginSdo);

	@Operation(summary = "UserActivate", description = "UserActivate API")
	@ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Success")})
	ResponseEntity<CommonResponse> activateUser(UserActivateSdo userActivateSdo);

	@Operation(summary = "deactivateByAdmin", description = "deactivate API")
	@ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Success")})
	ResponseEntity<CommonResponse> deactivateUserByAdmin(UserDeactivateByAdminSdo userDeactivateByAdminSdo);

	@Operation(summary = "deactivateByAdmin", description = "deactivate API")
	@ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Success")})
	ResponseEntity<CommonResponse> deactivateUserByUser(Integer userId);

	@Operation(summary = "deactivateDormancyUser", description = "Deactivate Dormancy User API")
	@ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Success")})
	ResponseEntity<CommonResponse> deactivateDormancyUser();

	@Operation(summary = "join workspace", description = "join workspace API")
	@ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Success")})
	ResponseEntity<CommonResponse> joinWorkspace(UserJoinSdo userJoinSdo);

	@Operation(summary = "get all non-admin users", description = "get all non-admin users API (Admin only)")
	@ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Success")})
	ResponseEntity<CommonResponse> getAllNonAdminUsers(Integer adminId);

	@Operation(summary = "search non-admin users", description = "search non-admin users by name, email, phone, or workspace (Admin only)")
	@ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Success")})
	ResponseEntity<CommonResponse> searchNonAdminUsers(UserSearchSdo userSearchSdo);
}