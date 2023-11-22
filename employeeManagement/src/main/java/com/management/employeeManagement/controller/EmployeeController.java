package com.management.employeeManagement.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class EmployeeController {

	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	@RequestMapping(value="/user/welcome", method=RequestMethod.GET)
	public String welcome(Authentication auth,Model model) {
		UserDetails user = (UserDetails) auth.getPrincipal();
		model.addAttribute("userName", user.getUsername());
		return "success";
	}
	
	@RequestMapping(value="/user/wel", method=RequestMethod.GET)
	@ResponseBody
	public String welcome2(Model model) {
		return "Welcome to application page 2";
	}
	
	@RequestMapping(value="/admin/welcome", method=RequestMethod.POST)
	public String welcomeAdmin(Model model) {
		return "success";
	}
}
