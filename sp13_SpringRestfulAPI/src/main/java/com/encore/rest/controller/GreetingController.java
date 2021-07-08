package com.encore.rest.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.encore.rest.dto.Greeting;

@RestController
public class GreetingController {
	//필드추가
	private final AtomicLong counter = new AtomicLong();
	
	
	// http://127.0.0.1.8888/rest/greet
	@GetMapping("/greet")
	public Greeting sayGreet() {
		return new Greeting(314L, "Restful API");
	}
	
	/*
	 * @PathVariable은 단순 파라미터값을 URL 경로에 포함시키는 방법이다
	 * greet/{id} 처럼 {}를 이용해서 매핑되는 URL 경로를 메서드 인자값 옵션인
	 * @PathVariable 어노테이션으로 작성된 인자값 id에 자동 매핑된다
	 */
	// http://127.0.0.1.8888/rest/greet/33
	@GetMapping("/greet/{id}")
	public String showSample(@PathVariable int id) {
		return "Hello Restful API case number..."+id;
	}
	
	// http:127.0.0.1:8888/rest/greet2?msg=ENCORE
	@GetMapping("/greet2")
	public Greeting sayGreet(@RequestParam(value="msg", required=false, defaultValue="world") String name) {
		return new Greeting(counter.incrementAndGet(), name);
	}
}
