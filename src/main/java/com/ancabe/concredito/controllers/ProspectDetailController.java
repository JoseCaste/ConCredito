package com.ancabe.concredito.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ancabe.concredito.models.Docs;
import com.ancabe.concredito.models.Evaluation;
import com.ancabe.concredito.pojo.EvaluationDetails;
import com.ancabe.concredito.pojo.ProspectEvaluation;
import com.ancabe.concredito.repositories.DocsRepository;
import com.ancabe.concredito.services.EvaluationDetailServices;
import com.ancabe.concredito.services.EvaluationServices;

@Controller
@RequestMapping("/prospect-details")
public class ProspectDetailController {

	@Autowired
	private EvaluationDetailServices detailServices;
	@Autowired EvaluationServices evaluationServices;
	@Autowired
	private DocsRepository docsRepository;
	
	@GetMapping("/{id}")
	public String prospectDetails(Model model, HttpSession session, @PathVariable (name ="id") Integer id) {
		EvaluationDetails evaluationDetails= detailServices.findById(id);
		model.addAttribute("evaluation_details", evaluationDetails);
		model.addAttribute("list",evaluationDetails.getDocs_name());
		return "prospect-detail";
	}
	@GetMapping("/evaluateProspect")
	public String evaluateProspect(Model model, HttpSession session,@ModelAttribute(name="prospect") Evaluation evaluation) {
		List<ProspectEvaluation> evaluations= detailServices.findAll();
		model.addAttribute("prospects", evaluations);
		return "prospect-evaluation";
	}
	@PostMapping("/evaluateProspect")
	public String saveChangeEvaluation(Model model, HttpSession session,@ModelAttribute(name="prospect") Evaluation evaluation) {
		//System.out.println(evaluation.toString());
		return "prospect-evaluation";
	}
	@GetMapping("/specificProspect")
	public String searchProspect(Model model, HttpSession session, @ModelAttribute(name="prospect") Evaluation prospect) {
		Evaluation evaluation= evaluationServices.findById(prospect.getId_evaluation());
		EvaluationDetails evaluation_= new EvaluationDetails(prospect.getId_evaluation(),evaluation.getName(), evaluation.getFirst_lastname(), evaluation.getSecond_lastname(), evaluation.getAddress(), evaluation.getAddress_number(), evaluation.getColonia(), evaluation.getPostal_code(), evaluation.getContact(), evaluation.getRfc(), evaluation.getStatus(), evaluation.getObservations());
		System.out.println(evaluation_.toString());
		List<ProspectEvaluation> evaluations= detailServices.findAll();
		model.addAttribute("prospects", evaluations);
		model.addAttribute("prospect_found", evaluation_);
		return "prospect-evaluation";
	}
	@GetMapping("/download/{id}")
	public ResponseEntity<Resource> dowloadFile(Model model, HttpSession session, @PathVariable (name ="id") Integer id) {
		Docs docs=docsRepository.findById(id).get();
		return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(docs.getType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + docs.getName() + "\"")
                .body(new ByteArrayResource(docs.getFile()));
	}
}
