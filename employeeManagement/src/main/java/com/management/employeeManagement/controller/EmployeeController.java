package com.management.employeeManagement.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.management.employeeManagement.comparators.DashboardDetailsComparator;
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
	
	@RequestMapping(value="/user/sortDashDataAscending", method=RequestMethod.POST)
	public String sortAscending(HttpSession session, @RequestParam("fieldName") String field) {
		DataholderBean bean = (DataholderBean) session.getAttribute("bean");
		System.out.println(field);
		List<DashboardDetails> dashList=bean.getDashboardDTOList();
		DashboardDetailsComparator comparator = new DashboardDetailsComparator(field);
		Collections.sort(dashList,comparator);
		bean.setDashboardDTOList(dashList);
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
		
		DashboardDetails dashboardDetails4 = new DashboardDetails();
		dashboardDetails4.setFirstName("FIAT");
		dashboardDetails4.setLastName("Schewner");
		DashboardDetails dashboardDetails5 = new DashboardDetails();
		dashboardDetails5.setFirstName("Rumble");
		dashboardDetails5.setLastName("Schewner");
		DashboardDetails dashboardDetails6 = new DashboardDetails();
		dashboardDetails6.setFirstName("Gumble");
		dashboardDetails6.setLastName("Dot");
		DashboardDetails dashboardDetails7 = new DashboardDetails();
		dashboardDetails7.setFirstName("Desk");
		dashboardDetails7.setLastName("Table");
		DashboardDetails dashboardDetails8 = new DashboardDetails();
		dashboardDetails8.setFirstName("Mod");
		dashboardDetails8.setLastName("Add");
		DashboardDetails dashboardDetails9 = new DashboardDetails();
		dashboardDetails9.setFirstName("Firen");
		dashboardDetails9.setLastName("Nos");
		DashboardDetails dashboardDetails10 = new DashboardDetails();
		dashboardDetails10.setFirstName("Jack");
		dashboardDetails10.setLastName("Schewner");
		dashList.add(dashboardDetails1);
		dashList.add(dashboardDetails2);
		dashList.add(dashboardDetails3);
		dashList.add(dashboardDetails4);
		dashList.add(dashboardDetails5);
		dashList.add(dashboardDetails6);
		dashList.add(dashboardDetails7);
		dashList.add(dashboardDetails8);
		dashList.add(dashboardDetails9);
		dashList.add(dashboardDetails10);
		bean.setDashboardDTOList(dashList);
	}
}
