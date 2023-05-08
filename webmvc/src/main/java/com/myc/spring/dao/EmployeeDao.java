package com.myc.spring.dao;

import com.myc.spring.model.Employee;

public interface EmployeeDao {

	public void addEmployee(Employee emp);
	
	public Employee getEmployee(int empId);
}
