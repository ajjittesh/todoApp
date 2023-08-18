package com.springboot.todoApp.login;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class Welcomecontroller {

	@RequestMapping("/")
	public String gotoWelcome(ModelMap model) {
		model.put("name", getLoggedinUsername());
		// model.put("password", password);
		return "Welcome";
	}

	private String getLoggedinUsername() {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		return authentication.getName();
	}
}
