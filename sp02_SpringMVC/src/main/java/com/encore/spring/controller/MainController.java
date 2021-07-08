package com.encore.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class MainController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView(); // 결과페이지 이름과 데이터를 저장할 수 있다
		mv.setViewName("result");
		mv.addObject("info", "MainController ComponentBean..");
		return mv;
	}

	
	
}
