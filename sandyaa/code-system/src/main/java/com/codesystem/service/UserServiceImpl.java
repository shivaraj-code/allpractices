package com.codesystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.codesystem.model.UserInfo;
import com.codesystem.repository.UserInfoRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
    private UserInfoRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

	@Override
	public String addUser(UserInfo userInfo) {
		userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        repository.save(userInfo);
        return "user added to system ";
	}

	@Override
	public List<UserInfo> getAllUsers() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public UserInfo getUserById(int id) {
		// TODO Auto-generated method stub
		return repository.getById(id);
	}
	

}
