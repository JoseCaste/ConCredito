package com.ancabe.concredito.controllers;

import com.ancabe.concredito.models.Promotor;
import com.ancabe.concredito.services.PromotorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController{
	@Autowired
	private PromotorService promotorService;
	@GetMapping({"/signin","/","/login"})
	public String signin(Model model) {
		return "login";
	}
	@GetMapping("/sign-up")
	public String signup(Model model, @ModelAttribute(name="promotor")Promotor promotor){
		return "sign-up";
	}
	@PostMapping("/sign-up")
	public String createAccount(Model model, @ModelAttribute(name="promotor")Promotor promotor, RedirectAttributes redirectAttributes){
		promotor.setPassword(ControlPanelController.getMd5(promotor.getPassword()));
		promotorService.save(promotor);
		redirectAttributes.addFlashAttribute("save_success","Promotor creado con éxito");
		return "redirect:/sign-up";
	}
}
