package com.polarbooksshop.catalogservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //Rest/HTTP 엔드포인트를 위한 핸들러를 정의하는 클래스로 인식
public class HomeController {

	@GetMapping("/") // 루트 엔트포인트로 GET 요청을 처리
	public String getGreeting() {
		return "Welcome to the book catalog!";
	}

}
