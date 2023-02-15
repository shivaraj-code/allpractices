package com.codesystem.config;

import com.codesystem.model.UserInfo;
import com.codesystem.repository.UserInfoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserInfoUserDetailsService implements UserDetailsService {

	@Autowired
	private UserInfoRepository repository;

	@Override
	public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
		Optional<UserInfo> userInfo = repository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail);
		return userInfo.map(UserInfoUserDetails::new)
				.orElseThrow(() -> new UsernameNotFoundException("user not found " + usernameOrEmail));

	}
}
