package com.encore.bootprac.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("main.do")
	public String mainPage(Model model) {
		model.addAttribute("message", "스프링 부트");
		return "main";
	}
}
