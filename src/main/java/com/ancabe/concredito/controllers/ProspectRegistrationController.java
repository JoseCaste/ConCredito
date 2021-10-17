package com.ancabe.concredito.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.ancabe.concredito.models.Docs;
import com.ancabe.concredito.models.Evaluation;
import com.ancabe.concredito.services.DocsService;
import com.ancabe.concredito.services.EvaluationServices;

@Controller
public class ProspectRegistrationController {
	@Autowired
	private DocsService docsService;
	@Autowired
	private EvaluationServices evaluationServices;

	@GetMapping("/prospect-registration")
	public String prospectRegistration(@ModelAttribute(name = "prospect") Evaluation prospect) {
		return "prospect_form";
	}

	@PostMapping("/saveProspect")
	public String saveProspect(Model model, @ModelAttribute(name = "prospect") Evaluation prospect,
			BindingResult result, MultipartFile[] files, HttpSession session) {
		List<MultipartFile> files_ = new ArrayList<>();
		addFilesList(files,files_);
		
		List<Docs> docs = files_.stream().map(item -> {
			try {
				return new Docs(item.getOriginalFilename(), item.getContentType(), item.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			}
		}).collect(Collectors.toList());
		prospect.setStatus(Evaluation.SENDS);
		prospect=evaluationServices.save(prospect);
		for (Docs docs_ : docs) {
			docs_.setEvaluation(prospect);
		}
		docs = docsService.saveAllDoc(docs);
		//docs = docsService.saveAllDoc(docs);
		model.addAttribute("save_success", "Prospecto guardado");
		return "prospect_form";
	}

	private List<MultipartFile>  addFilesList(MultipartFile[] files, List<MultipartFile> files_) {
		// TODO Auto-generated method stub
		for (MultipartFile multipartFile : files) {
			files_.add(multipartFile);
		}
		return files_;
	}
}
