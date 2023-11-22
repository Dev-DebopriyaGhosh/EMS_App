package com.management.employeeManagement.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.management.employeeManagement.DAO.UserDAO;
import com.management.employeeManagement.model.User;
import com.management.employeeManagement.userDetails.EMSUserDetails;

public class UserDetailsServiceImpl implements UserDetailsService{
	
	
	@Autowired
	@Qualifier("em.userDao")
	private UserDAO userDao;

	public UserDAO getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDao.getUserUsingUsername(username);
		if(user==null) {
			throw new UsernameNotFoundException("Could not found user !");
		}
		EMSUserDetails userDetails = new EMSUserDetails(user);
		return userDetails;
	}

}
