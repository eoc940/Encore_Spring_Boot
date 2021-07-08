package com.encore.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ViewResolverController {

	@RequestMapping("register.do")
	public ModelAndView register() {
		System.out.println("register() calling");
		return new ModelAndView("register_result", "info", "InternalResourceViewResolver....");
	}
	
	//BeanNameViewResolver와 컨트롤러가 어떻게 연결되는지..
	@RequestMapping("findBoard.do")
	public ModelAndView findBoard() {
		System.out.println("findBoard() calling");
		return new ModelAndView("board_result"); // board/result/find_ok.jsp
	}
	
	@RequestMapping("findProduct.do")
	public ModelAndView findProduct() {
		System.out.println("findProduct() calling");
		return new ModelAndView("product_result"); // board/result/find_ok.jsp
	}
}
