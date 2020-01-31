package com.cos.springlegacy;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.springlegacy.dto.RequestJsonDto;

@Controller
public class JsonController {

	// 스프링은 form의 name값 혹은 쿼리스트링만 오브젝트로 자동변환!!
	@RequestMapping(value="/jsonTest", method=RequestMethod.POST)
	public @ResponseBody RequestJsonDto jsonTest(@RequestBody RequestJsonDto requestJsonDto) { // {제이슨}
		// RequestBody쓰면 BufferedReader(가 실행되기에) 안써도 됨
		System.out.println(requestJsonDto.getId());
		
		return requestJsonDto;
	}
	
	// http://localhost:8080/springlegacy/jsonHome/* - 해당주소 이후로 들어오는 모든 주소 받음
	@RequestMapping(value="/jsonHome/{num}", method=RequestMethod.POST)
	public String jsonHome(@PathVariable int num) { 
		// {}안의 이름과 동일해야함(아닐경우 @PathVariable("num") 해야함
		
		System.out.println("num: "+num);
		return "jsonHome";
	}
	
	// BufferedReader통한 형 변환
	/* @RequestMapping(value="/jsonHome", method=RequestMethod.POST) 
	 * public String jsonHome(HttpServletRequest req) { 
	 * try { BufferedReader br = req.getReader(); 
	 * String input = null; StringBuffer sb = new StringBuffer();
	 * while((input = br.readLine()) != null) { sb.append(input); } 
	 * Gson gson = new Gson(); RequestJsonDto RequestJsonDto = 
	 * gson.fromJson(sb.toString(), RequestJsonDto.class); 
	 * System.out.println("id: "+ RequestJsonDto.getId()); 
	 * } catch (IOException e) { e.printStackTrace(); }
	 * return "jsonHome"; }
	 * // System.out.println("id : "+ data.get("id")); ← Map<String, Object> data 
	 */
}
