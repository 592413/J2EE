package com.myc.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myc.spring.dao.EmployeeDao;
import com.myc.spring.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeDao empDao;

	@Override
	public void addEmployee(Employee emp) {
		empDao.addEmployee(emp);

	}

	@Override
	public Employee getEmployee(int empId) {
		
		return empDao.getEmployee(empId);
	}

}
