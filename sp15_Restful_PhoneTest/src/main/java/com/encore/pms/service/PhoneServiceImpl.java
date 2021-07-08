package com.encore.pms.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.encore.pms.dao.IPhoneDAO;
import com.encore.pms.dto.Phone;
import com.encore.pms.dto.UserInfo;

@Service
public class PhoneServiceImpl implements IPhoneService{

	@Autowired
	private IPhoneDAO iPhoneDAO;
	
	@Transactional // 이 어노테이션만 붙이면 알아서 트랜잭션 처리 된다
	@Override
	public int insert(Phone phone) {
		return iPhoneDAO.insert(phone);
	}

	@Transactional
	@Override
	public int delete(List<String> list) {
		return iPhoneDAO.delete(list);
	}

	@Override
	public Phone select(Phone phone) {
		return iPhoneDAO.select(phone);
	}

	@Override
	public List<Phone> select() {
		return iPhoneDAO.select();
	}

	@Override
	public UserInfo select(UserInfo user) {
		return iPhoneDAO.select(user);
	}

	@Override
	public int update(Phone phone) {
		return iPhoneDAO.update(phone);
	}

}
