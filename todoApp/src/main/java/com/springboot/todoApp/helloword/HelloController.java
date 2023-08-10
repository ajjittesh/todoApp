package com.springboot.todoApp.helloword;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

	
	@RequestMapping("say-hey")
	@ResponseBody
	public String helloword() {
		return "hi whats's up with you workingg na???";
	}
	
	@RequestMapping("say-heyhtml")
	@ResponseBody
	public String hellowordhtml() {
		StringBuffer sb= new StringBuffer();
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<title>My first html tag</title>");
		sb.append("</head>");
		sb.append("<body>");
		sb.append("My first html body");
		sb.append("</body>");
		sb.append("</html>");
		return sb.toString();
	}
	@RequestMapping("say-heyjsp")
	public String hellowordjsp() {
		return "sayHello";
	}
}
