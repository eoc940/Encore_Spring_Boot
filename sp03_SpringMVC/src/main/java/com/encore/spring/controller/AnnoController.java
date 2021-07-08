package com.encore.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


//<bean name="/anno.do" class="....." /> 태그가 없어짐
@Controller
public class AnnoController {

	// 기존에는 implement controller를 해서 modelandview를 override 해야하지만
	// 어노테이션으로 하면 마음대로 메서드를 지정한다. 제약조건이 없어진 셈이다. 리턴타입만 modelandview로 맞춰준다
	@RequestMapping("anno.do")
	public ModelAndView anno() {
		return new ModelAndView("WEB-INF/views/anno_result.jsp", "info", "Annotation Success!!");
	}
	
	
	
}
