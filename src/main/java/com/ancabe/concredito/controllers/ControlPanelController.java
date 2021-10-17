package com.ancabe.concredito.controllers;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.ancabe.concredito.models.Promotor;
import com.ancabe.concredito.pojo.EvaluationDetails;
import com.ancabe.concredito.pojo.UserPojo;
import com.ancabe.concredito.services.EvaluationServices;
import com.ancabe.concredito.services.PromotorService;

@Controller
public class ControlPanelController {
	@Autowired 
	private PromotorService promotorService;
	@Autowired 
	private EvaluationServices evaluationServices;
	@GetMapping("/menu")
	public String menu(Model model,HttpSession session) {
		List<EvaluationDetails> prospects=evaluationServices.findAll().stream().map(item ->{
			return new EvaluationDetails(item.getId_evaluation(),item.getName(),item.getFirst_lastname(),item.getSecond_lastname(),item.getStatus());
		}).collect(Collectors.toList());
		model.addAttribute("prospect_list", prospects);
		return "menu";
	}
	@PostMapping("/menu")
	public String authentication(Model model,@ModelAttribute UserPojo user, HttpSession session) {
		Promotor promotor = promotorService.findByEmail(user.getEmail());
		if(promotor!=null &&promotor.getPassword().equals(getMd5(user.getPassword()))) {
			session.setAttribute("user", promotor.getName());
			session.setAttribute("user_id", promotor.getId_promotor());
			List<EvaluationDetails> prospects=evaluationServices.findAll().stream().map(item ->{
				return new EvaluationDetails(item.getId_evaluation(),item.getName(),item.getFirst_lastname(),item.getSecond_lastname(),item.getStatus());
			}).collect(Collectors.toList());
			model.addAttribute("prospect_list", prospects);
			return "menu";
		}
		model.addAttribute("error", "Credenciales incorrectas");
		return "login";
	}
	/*@GetMapping("/prospect-details/{id}")
	public String prospectDetails(@PathVariable String id,Model model, HttpSession session) {
	    return "menu";
	}*/
	@GetMapping("/logout")
	public String loguout(Model model, HttpSession session) {
		session.invalidate();
		return "redirect:/signin";
	}
	public String getMd5(String input)
    {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger no = new BigInteger(1, messageDigest);
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } 
  
        // For specifying wrong message digest algorithms
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
