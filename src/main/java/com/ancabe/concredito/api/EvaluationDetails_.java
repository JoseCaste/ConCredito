package com.ancabe.concredito.api;

import java.util.NoSuchElementException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.ancabe.concredito.pojo.EvaluationDetails;

@RestController
public class EvaluationDetails_ {

	@GetMapping("/evaluation-details/{id}")
	public ResponseEntity<EvaluationDetails> evaluationDetails(@PathVariable("id") Integer id){
		//DocsPojo(item.getName(), item.getType(), item.getFile());
		try {
			/*Evaluation entity=evaluationServices.findById(id);
			List<String> docs_name= entity.getDocs().stream().map(item ->{
				return String.format("%s", item.getName());
			}).collect(Collectors.toList());
			EvaluationDetails evauluation=null;/*= new EvaluationDetails(entity.getName(),entity.getFirst_lastname(),
					entity.getSecond_lastname(),entity.getAddress(),entity.getAddress_number(),
					entity.getColonia(),entity.getPostal_code(),entity.getContact(),entity.getRfc(),entity.getStatus(),
					docs_name) ;*/
			//return new ResponseEntity<EvaluationDetails>(evauluation, HttpStatus.FOUND);
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} catch (NoSuchElementException e) {
			// TODO: handle exception
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}
	}
}
