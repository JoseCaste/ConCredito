package com.ancabe.concredito.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ancabe.concredito.models.Evaluation;
import com.ancabe.concredito.pojo.DocsPojo;
import com.ancabe.concredito.pojo.EvaluationDetails;
import com.ancabe.concredito.pojo.ProspectEvaluation;
import com.ancabe.concredito.repositories.DocsRepository;
import com.ancabe.concredito.repositories.EvaluationRepository;

@Service
public class EvaluationDetailServices {

	@Autowired
	private EvaluationRepository evaluationRepository;
	@Autowired
	private DocsRepository docsRepository;
	
	public EvaluationDetails findById(Integer id) {
		try {
			Evaluation entity=evaluationRepository.findById(id).get();
			List<DocsPojo> docs_name= docsRepository.findByEvaluation(entity).stream().map(item ->{
				return new DocsPojo(item.getId_doc(), String.format("%s", item.getName()));
			}).collect(Collectors.toList());
			EvaluationDetails evaluationPojo= new EvaluationDetails(entity.getId_evaluation(),entity.getName(),entity.getFirst_lastname(),
					entity.getSecond_lastname(),entity.getAddress(),entity.getAddress_number(),
					entity.getColonia(),entity.getPostal_code(),entity.getContact(),entity.getRfc(),entity.getStatus(),entity.getObservations(),
					docs_name);
			return evaluationPojo;
		} catch (NoSuchElementException e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
			
		}
	}

	public List<ProspectEvaluation> findAll() {
		// TODO Auto-generated method stub
		return evaluationRepository.findAll().stream().map(item->{
			return new ProspectEvaluation(item.getId_evaluation(),item.getName(), item.getFirst_lastname(), item.getSecond_lastname());
		}).collect(Collectors.toList());
	}
}
