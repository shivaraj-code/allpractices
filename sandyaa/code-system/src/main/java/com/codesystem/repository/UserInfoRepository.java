package com.codesystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.codesystem.model.UserInfo;

public interface UserInfoRepository extends JpaRepository<UserInfo, Integer> {
	@Query("Select distinct u from UserInfo u where u.name=:username or u.email=:email")
	Optional<UserInfo> findByUsernameOrEmail(String username, String email);

}
