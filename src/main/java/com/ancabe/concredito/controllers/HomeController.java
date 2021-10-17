package com.ancabe.concredito.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController{
	@GetMapping({"/signin","/","/login"})
	public String signin(Model model) {
		return "login";
	}
}
