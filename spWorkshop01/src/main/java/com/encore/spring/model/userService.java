package com.encore.spring.model;

import com.encore.spring.domain.User;

public interface userService {
	User getUser(String userId) throws Exception;
}
