package com.codesystem.service;

import java.util.List;

import com.codesystem.model.UserInfo;

public interface UserService {

	String addUser(UserInfo userInfo);

	List<UserInfo> getAllUsers();

	UserInfo getUserById(int id);

}
