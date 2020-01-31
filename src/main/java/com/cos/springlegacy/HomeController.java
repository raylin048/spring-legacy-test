package com.cos.springlegacy;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cos.springlegacy.dto.RequestInfoDto;

// http://localhost:8080/springlegacy/
// Controller 어노테이션은 페이지를 리턴하는 어노테이션이다.
@Controller
public class HomeController {
	/*
	 * 1. 데이터 전달 - 쿼리스트링, Form데이터, Json 
	 * 2. 데이터 받기 - 쿼리스트링, Form데이터, Json 
	 * 3. Pathvariable 사용해보기
	 */
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String home(Model model) {
		// Controller 어노테이션이 있는 클래스에서 함수가 return하는 순간
		// ViewResolver가 관여하여 prefix와 suffix를 만들어서
		// 페이지를 return해준다.
		
		// request에 담기 => model = request+requestDispatcher
		String username = "ssar";
		model.addAttribute("username", username);
		
		return "home";
	}
	
	@RequestMapping(value = "/hello", method = RequestMethod.POST)
	public String hello(Model model, @RequestParam("id") String id, @RequestParam String pw) {
		// RequestParam으로 받을 수 있는 것은 QueryString, x-www-formurlencoded 데이터만 받을 수 있음
		// String id로 받는 값과 입력값이 같으면 RequestParam생략가능
		
		System.out.println("id :"+id);
		System.out.println("pw :"+pw);
		
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		
		return "hello";
	}
	
	@RequestMapping(value = "/goodbye", method = RequestMethod.GET)
	public String goodbye(RequestInfoDto requestInfoDto) {
		System.out.println("addr :"+ requestInfoDto.getAddr());
		System.out.println("hobby :"+ requestInfoDto.getHobby());
		
		return "goodbye";
	}
	
}
