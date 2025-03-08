package com.in.akshay.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.in.akshay.Entity.Resource;
import com.in.akshay.Service.ResourceService;

@Controller
public class ResourceController {
    @Autowired
	private ResourceService service;
	
	@GetMapping("/register")
	public String resourceRegisterPage() {
		
		return "register";
	}
    
	
	@GetMapping("/research")
	public String searchPage() {
		
		return "research";
	}

	@PostMapping("/resourceRegister")
	public String register(@ModelAttribute Resource res, Model model) {
		
		boolean status= service.regResource(res);
		if(status) {
			model.addAttribute("message", "resource added successfully");
		}
		else {
			model.addAttribute("errmessage", "unsuccessfull");
		}
		
		return "register";
		
	}
	
	@PostMapping("/search")
	public String search(@ModelAttribute Resource redata, Model model) {
		
	        List<Resource> resources = service.getResourcesBySkillsAndExperience(redata.getSkills(),redata.getExperience());

	        model.addAttribute("resources", resources);
		return "profile";
		
	}
}
