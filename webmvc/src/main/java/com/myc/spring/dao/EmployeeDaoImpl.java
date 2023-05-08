package com.myc.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.myc.spring.model.Employee;
import com.myc.spring.resulSet.EmployeeMapper;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	
	private final String INSERT_EMP="INSERT INTO `myc`.`employee`(`EmployeeName`) VALUES (?)";
	
	private final String GET_SINGLE_EMP= "SELECT * from myc.employee where EmpId=?";
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	

	@Override
	public void addEmployee(Employee emp) {
		
		jdbcTemplate.update(INSERT_EMP, emp.getEmployeeName());

	}

	@Override
	public Employee getEmployee(int empId) {
		
		return jdbcTemplate.queryForObject(GET_SINGLE_EMP, new EmployeeMapper(),empId);
	}

}

/*
 new RowMapper<Employee>() {

			@Override
			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				Employee emp = new Employee();
				
				emp.setEmployeeName(rs.getString("EmployeeName"));
				emp.setEmpId(rs.getInt("EmpId"));
				
				return emp;
			}
			
		}
		*/
