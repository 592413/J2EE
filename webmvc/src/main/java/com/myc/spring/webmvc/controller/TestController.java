package com.myc.spring.webmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value="/test")
public class TestController {
	
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
}
