package com.encore.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class IndexController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView(); // �������� �̸�, �̵����(����Ʈ�� forward), ������ ���ε����� �� �Ҽ��ִ� ���̺귯��
		mv.setViewName("result"); // Ȯ���� �Ƚᵵ ��
		mv.addObject("message", "Hello SpringMVC Framework!!");
		return mv;
	}
	
	
	
	
}
