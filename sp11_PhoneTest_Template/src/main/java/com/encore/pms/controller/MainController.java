package com.encore.pms.controller;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.encore.pms.dto.Phone;
import com.encore.pms.dto.UserInfo;
import com.encore.pms.service.IPhoneService;



@Controller
public class MainController {	
	
	@Autowired
	private IPhoneService iPhoneService;
	
	@GetMapping("login.do") // get방식 요청이라는 것을 나타냄
	public String getLoginForm() {
		
		return "Login";
	}
	
	@PostMapping("login.do") // get, post 다르면 요청경로가 같아도 괜찮음
	public String doLogin(UserInfo user, Model model, HttpSession session) {
		try {
			UserInfo selected = iPhoneService.select(user);
			if(selected != null) { // 로그인 성공
				session.setAttribute("loginUser", selected);
				
				// 모든 폰이 검색된 결과 페이지로 이동...
				return "redirect:searchPhone.do"; // redirect 반드시 해야하는 경우이다. 클라이언트에서 다시 서블릿을 거쳐 들어와야 하기 때문이다
			}	
			return "Login"; // 로그인 실패.. 다시 로그인 하도록
		}catch(Exception e){ // 비즈니스 로직 수행중 에러남
			model.addAttribute("title", "핸드폰 관리 - 로그인 실패");
			model.addAttribute("message","문제 내용 - 로그인 중 오류가 발생했습니다.");
			return "Error";
		}
		
	}
	
	@GetMapping("searchPhone.do") // 전체 폰 목록을 보여주는 기능... 결과 페이지는 PhoneList.jsp
	public String showPhoneList(Model model) {
		try {
			List<Phone> phoneList = iPhoneService.select();
			model.addAttribute("phoneList", phoneList);
			model.addAttribute("title", "핸드폰 관리 - 폰 리스트");
			return "PhoneList";
		}catch(Exception e) {
			model.addAttribute("title", "핸드폰 관리 - 에러");
			model.addAttribute("message","폰 목록 조회 중 오류가 발생했습니다");
			return "Error";
		}
		
	}
	
	@GetMapping("regPhone.do")
	public String getRegForm() {
		
		return "PhoneReg";
	}
	
	@PostMapping("savePhone.do")
	public String registerPhone(Phone phone, Model model) {
		try {
			iPhoneService.insert(phone);
			model.addAttribute("title", "핸드폰 등록 성공");
			model.addAttribute("message", "등록이 완료되었습니다");
			return "Result";
		} catch(Exception e) {
			model.addAttribute("title", "핸드폰 등록 - 에러");
			model.addAttribute("message","폰 등록 중 오류가 발생했습니다");
			return "Error";
		}
	}
	
	@GetMapping("detail.do")
	public String doDetail(Phone phone, Model model) {
		try {
			Phone selected = iPhoneService.select(phone);
			model.addAttribute("title", "핸드폰 관리 - 핸드폰 상세조회 성공");
			model.addAttribute("phone", selected);
			System.out.println(selected);
			return "PhoneView";
		}catch(Exception e) {
			model.addAttribute("title", "핸드폰 관리 - 핸드폰 상세조회 성공");
			model.addAttribute("message", "문제 내용 - 상세 조회중 오류가 발생했습니다");
			
			return "Error";
		}
	}
	
	@GetMapping("logout.do")
	public String logout(HttpSession session, Model model) {
		try {
			session.invalidate();
			return "index";
		}catch(Exception e) {
			model.addAttribute("message", "문제 내용 - 로그아웃 중 오류가 발생했습니다");
			return "Error";
		}
		
	}

	@PostMapping("delete.do")
	public String deletePhones(String[] values, Model model) {
		
		System.out.println(Arrays.toString(values));
		try {
			for(String phone : values) {
				System.out.println(phone);
				iPhoneService.delete(phone);
			}
			System.out.println("통과");
			return "JsonView";
		}catch(Exception e) {
			model.addAttribute("message", "문제 내용 - 삭제 중 오류 발생");
			return "Error";
		}
			
	}
	
	
	
}





