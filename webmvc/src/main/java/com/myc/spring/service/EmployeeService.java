package com.myc.spring.service;

import com.myc.spring.model.Employee;

public interface EmployeeService {

	public void addEmployee(Employee emp);
	
	public Employee getEmployee(int empId);
}
