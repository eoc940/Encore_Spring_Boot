package com.encore.spring.model;


import com.encore.spring.domain.User;


public interface userDAO {
	User getUser(String userId) throws Exception;
}
