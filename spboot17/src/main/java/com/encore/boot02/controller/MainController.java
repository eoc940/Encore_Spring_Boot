package com.encore.boot02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("index.do")
	public String index(Model model) {
		model.addAttribute("message", "Boot Test 2~~!!");
		return "find_ok";
	}
}
