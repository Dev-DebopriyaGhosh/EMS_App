package com.management.employeeManagement.model;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;



public class UserDTO {

	private UserDetails loginUserDetails;
	private List<String> permissions;
	private String userQueue;
	public UserDetails getLoginUserDetails() {
		return loginUserDetails;
	}
	public void setLoginUserDetails(UserDetails loginUserDetails) {
		this.loginUserDetails = loginUserDetails;
	}
	public List<String> getPermissions() {
		return permissions;
	}
	public void setPermissions(List<String> permissions) {
		this.permissions = permissions;
	}
	public String getUserQueue() {
		return userQueue;
	}
	public void setUserQueue(String userQueue) {
		this.userQueue = userQueue;
	}
}
