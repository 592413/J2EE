package com.myc.spring.resulSet;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.myc.spring.model.Employee;

public class EmployeeMapper implements RowMapper<Employee> {

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		Employee emp = new Employee();
		
		emp.setEmployeeName(rs.getString("EmployeeName"));
		emp.setEmpId(rs.getInt("EmpId"));
		
		return emp;
	}

}
