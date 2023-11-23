package com.management.employeeManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.management.employeeManagement.model.User;
import com.management.employeeManagement.services.UserDetailsServiceImpl;

@Controller
public class EmployeeController {
	
	@Autowired
	private UserDetailsService userService;

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
	
	@RequestMapping(value="/signup", method=RequestMethod.GET)
	public String signup(@ModelAttribute("user") User user) {
		return "signup";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST, produces = "text/html")
	@ResponseBody
	public String register(User user) {
		boolean result=false;
		try {
			result= ((UserDetailsServiceImpl) userService).saveUser(user);
		} catch (Exception e) {
			System.out.println("Exception while registering :"+e.getMessage());	
		}
		if(result)
			return "<h3>Successfully Registered</h3>";
		else
			return "Registration Failed ! Please try again.";
	}
}
