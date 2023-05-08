package com.myc.spring.webmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class HomeController {
	@RequestMapping(method=RequestMethod.GET)
	public String home() {
		return "home";
	}
	

//	@RequestMapping(value="profile", method=RequestMethod.GET)
//	public String userProfile(Model model) {
//		
//		String name="Virat Kohli";
//		model.addAttribute("userName",name);
//		
//		return "usrProfile";
//		
//	}
//	
//	@RequestMapping(value="profile", method=RequestMethod.GET)
//	public String hello1(@RequestParam String firstName, 
//			@RequestParam String lastName,Model model) {
//		
//		String name= firstName+lastName;
//		model.addAttribute("userName",name);
//		
//		return "usrProfile";
//		
//	}
//	
//	@RequestMapping(value="profile/{name}", method=RequestMethod.GET)
//	public String hello2(@PathVariable String name,Model model) {
//		
//		model.addAttribute("userName",name);
//		
//		return "usrProfile";
//		
//	}
}
