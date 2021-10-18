package com.ancabe.concredito.api;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import com.ancabe.concredito.models.Evaluation;
import com.ancabe.concredito.services.EvaluationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.ancabe.concredito.pojo.EvaluationDetails;

@RestController
public class EvaluationDetails_ {

	@Autowired
	private EvaluationServices evaluationServices;
	@GetMapping("/evaluation-details/{id}")
	public ResponseEntity<EvaluationDetails> evaluationDetails(@PathVariable("id") Integer id){
		try {
			Evaluation entity=evaluationServices.findById(id);
			List<String> docs_name= entity.getDocs().stream().map(item ->{
				return String.format("%s", item.getName());
			}).collect(Collectors.toList());
			EvaluationDetails evauluation= new EvaluationDetails(entity.getName(),entity.getFirst_lastname(),
					entity.getSecond_lastname(),entity.getAddress(),entity.getAddress_number(),
					entity.getColonia(),entity.getPostal_code(),entity.getContact(),entity.getRfc(),entity.getStatus(),
					docs_name) ;
			return new ResponseEntity<EvaluationDetails>(evauluation, HttpStatus.FOUND);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
