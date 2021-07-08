package com.encore.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class FormController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * 1. 폼값 받아서
		 * 2. vo 생성
		 * 3. dao호출
		 * 4. 리턴하는 값 바인딩
		 * 5. 네비게이션
		 */
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String addr = request.getParameter("addr");
		
		
		
		return new ModelAndView("WEB-INF/views/form_result.jsp", "info", name+"님이 사는 곳은 "+addr);
	}

		
}
