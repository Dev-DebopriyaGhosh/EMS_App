package com.management.employeeManagement.comparators;

import java.util.Comparator;

import org.springframework.stereotype.Component;

import com.management.employeeManagement.model.DashboardDetails;

public class DashboardDetailsComparator implements Comparator<DashboardDetails> {
	
	private String fieldToSort;


	public DashboardDetailsComparator(String fieldToSort) {
		super();
		this.setFieldToSort(fieldToSort);
	}


	@Override
	public int compare(DashboardDetails o1, DashboardDetails o2) {
		if(getFieldToSort().equalsIgnoreCase("firstName")) {
			return o1.getFirstName().compareTo(o2.getFirstName());
		}else if(getFieldToSort().equalsIgnoreCase("lastName")) {
			return o1.getLastName().compareTo(o2.getLastName());
		}
		return 0;
	}


	public String getFieldToSort() {
		return fieldToSort;
	}


	public void setFieldToSort(String fieldToSort) {
		this.fieldToSort = fieldToSort;
	}

}
