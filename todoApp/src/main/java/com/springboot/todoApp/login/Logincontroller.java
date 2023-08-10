package com.springboot.todoApp.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class Logincontroller {
	
	@RequestMapping(value="say-heylogin", method= RequestMethod.GET)
	public String loginword() {
		
		return "login";
	}
	@RequestMapping(value="say-heylogin", method= RequestMethod.POST)
	public String welcomewrd(@RequestParam String name,@RequestParam String password, ModelMap model) {
		model.put("name", name);
		model.put("password", password);
		return "Welcome";
	}
}
