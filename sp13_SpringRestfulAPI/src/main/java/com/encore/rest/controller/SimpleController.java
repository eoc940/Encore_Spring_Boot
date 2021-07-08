package com.encore.rest.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.encore.rest.dto.Customer;

/*
 * @Controller
 * @RequestMapping의 실행결과로 결과페이지 정보가 반환된다
 * 
 * 
 * @RestController
 * @RequestMapping의 실행결과로 데이터가 반환된다
 * @RequestMapping 대신 Rest API 서비스를 사용해서 요청한다
 * 		C : insert :: doPost
 * 		R : select :: doGet
 * 		U : update :: doPut
 * 		D : delete :: doDelete
 */
@RestController
@RequestMapping("/simple") //http://127.0.0.1.8888/rest/simple/hello ---> 브라우저에 "Hello Restful Service!!" 가 반환된다
public class SimpleController {

	// http://127.0.0.1.8888/rest/hello ---> 브라우저에 "Hello Restful Service!!" 가 반환된다
	@GetMapping("/hello")
	public String sayHello() {
		return "Hello Restful Service!!";
	}
	
	// http://127.0.0.1.8888/rest/simple/custom
	// 객체가 리턴되는 경우에는 JSON으로 변환해서 리턴하기 때문에 라이브러리를 반드시 추가해야 한다. pom.xml에 추가
	@GetMapping("/custom")
	public Customer detail() {
		//비지니스 로직 수행한 결과로 Customer 객체가 리턴되었다고 가정하자
		Customer customer = new Customer("아이유", "새벽거리를 걸었어요");
		return customer;
	}
	
	@GetMapping("/allCustom")
	public List<Customer> allCustom() {
		// 비지니스로직 수행한 결과로 List 객체가 리턴... 가정하자
		List<Customer> list = new ArrayList<Customer>();
		for(int i=0; i<3; i++) {
			Customer vo = new Customer();
			vo.setName("동이," + i);
			vo.setMessage("새벽길을 걸어요, " + i);
			list.add(vo);
		}
		return list;
	}
	
	@GetMapping("/mapCustom")
	public Map<Integer, Customer> sendCustom() {
		// 비지니스로직 수행한 결과로 Map 객체가 리턴... 가정하자
		Map<Integer, Customer> map = new HashMap<Integer, Customer>();
		map.put(1, new Customer("아이유", "새벽길을 걸어요"));
		map.put(2, new Customer("나", "산책길을 걸어요"));
		return map;
	}
	
	
	
}
