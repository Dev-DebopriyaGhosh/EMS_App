package com.management.employeeManagement.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.management.employeeManagement.model.DashboardDetails;
import com.management.employeeManagement.model.DataholderBean;
import com.management.employeeManagement.model.User;
import com.management.employeeManagement.model.UserDTO;
import com.management.employeeManagement.services.UserDetailsServiceImpl;

@Controller
@SessionAttributes("bean")
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
		
		populateBean(user,model);
		
		model.addAttribute("userName", user.getUsername());
		return "success";
	}
	
	//@ModelAttribute("dataHolderbean")
	public void populateBean(UserDetails user,Model model) {
		// TODO Auto-generated method stub
		UserDTO userDto = new UserDTO();
		userDto.setLoginUserDetails(user);
		
		
		DataholderBean bean = new DataholderBean();
		
		bean.setUserDetails(userDto);
		
		
		model.addAttribute("bean", bean);
		//return bean;
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
	
	@RequestMapping(value="/user/loadDashboard", method=RequestMethod.GET)
	public String loadDashboard(HttpSession session) {
		DataholderBean bean = (DataholderBean) session.getAttribute("bean");
		populateStaticData(bean);
		return "dashboard";
	}

	private void populateStaticData(DataholderBean bean) {
		List<DashboardDetails> dashList= new ArrayList<DashboardDetails>();
		DashboardDetails dashboardDetails1 = new DashboardDetails();
		dashboardDetails1.setFirstName("Test");
		dashboardDetails1.setLastName("TEMP");
		
		DashboardDetails dashboardDetails2 = new DashboardDetails();
		dashboardDetails2.setFirstName("MIMO");
		dashboardDetails2.setLastName("TEMP");
		
		DashboardDetails dashboardDetails3 = new DashboardDetails();
		dashboardDetails3.setFirstName("FIAT");
		dashboardDetails3.setLastName("Schewner");
		dashList.add(dashboardDetails1);
		bean.setDashboardDTOList(dashList);
	}
}
