package com.myc.spring.webmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.myc.spring.model.Employee;
import com.myc.spring.service.EmployeeService;

@Controller
@RequestMapping(value="/test")
public class TestController {
	
	@Autowired
	EmployeeService empService;
	
	@RequestMapping(value="/hello")
	public String hello() {
		
		return "helloworld";
		
	}
	
	@RequestMapping(value="/profile", method=RequestMethod.GET)
	public String hello1(@RequestParam String name,Model model) {
		
		model.addAttribute("userName",name);
		
		return "helloworld";
		
	}
	
	

	
	@RequestMapping(value="/profile/{name}", method=RequestMethod.GET)
	public String hello2(@PathVariable String name,Model model) {
		
		model.addAttribute("userName",name);
		
		
		return "helloworld";
		
	}
	
	
	@RequestMapping(value="/addUser", method=RequestMethod.GET)
	public String hello3(@RequestParam String name,Model model) {
		
		String username="Gautam Gambhir";
		
		Employee emp=new Employee();
		emp.setEmployeeName(username);
		
		empService.addEmployee(emp);
		
		model.addAttribute("userName",name);
		
		return "helloworld";
		
	}
	
	@RequestMapping(value="/getUser", method=RequestMethod.GET)
	public String hello3(@RequestParam Integer id,Model model) {
		
	Employee emp=empService.getEmployee(id);
		
		model.addAttribute("userName",emp.getEmployeeName());
		
		return "helloworld";
		
	}
	
}
