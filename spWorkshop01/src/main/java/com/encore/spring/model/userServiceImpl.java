package com.encore.spring.model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.encore.spring.domain.User;
@Service
public class userServiceImpl implements userService{
	
	@Autowired
	private userDAO userDAO;
	@Autowired
	public void setUserDAO(userDAO userDAO) {
		this.userDAO = userDAO;
	}

	
	@Override
	public User getUser(String userId) throws Exception {
		return userDAO.getUser(userId);
	}

	

}
