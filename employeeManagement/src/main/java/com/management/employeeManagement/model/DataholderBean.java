package com.management.employeeManagement.model;

import java.util.List;

public class DataholderBean {

	private UserDTO userDetails;
	private List<DashboardDetails> dashboardDTOList;
	public UserDTO getUserDetails() {
		return userDetails;
	}
	public void setUserDetails(UserDTO userDetails) {
		this.userDetails = userDetails;
	}
	public List<DashboardDetails> getDashboardDTOList() {
		return dashboardDTOList;
	}
	public void setDashboardDTOList(List<DashboardDetails> dashboardDTOList) {
		this.dashboardDTOList = dashboardDTOList;
	}
}
