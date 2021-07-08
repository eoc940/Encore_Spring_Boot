package com.encore.spring.test;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/*
 * SqlSessionFactory 하나 받아오는 녀석
 */
public class FactoryService {
	
	private static SqlSessionFactory factory;
	
	static {
		try {
			Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
			
			factory = new SqlSessionFactoryBuilder().build(r);
		} catch (Exception e) {
			
		}
	}
	
	public static SqlSessionFactory getFactory() {
		return factory;
	}
	
}
