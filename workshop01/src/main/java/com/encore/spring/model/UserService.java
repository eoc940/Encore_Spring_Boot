package com.encore.spring.model;

import java.sql.SQLException;

import com.encore.spring.domain.UserVO;

public interface UserService {
	
	
	public UserVO login(String userId, String password) throws SQLException;
}
