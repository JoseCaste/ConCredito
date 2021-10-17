package com.ancabe.concredito.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ancabe.concredito.models.Evaluation;
import com.ancabe.concredito.repositories.DocsRepository;
import com.ancabe.concredito.repositories.EvaluationRepository;

@Service
public class EvaluationServices {
	@Autowired
	private EvaluationRepository evaluationRepository;
	@Autowired
	private DocsRepository docsRepository;
	public Evaluation save(Evaluation evaluation) {
		return evaluationRepository.save(evaluation);
	}
	public List<Evaluation> findAll() {
		// TODO Auto-generated method stub
		return evaluationRepository.findAll();
	}
	public Evaluation findById(Integer id){
		// TODO Auto-generated method stub
		Evaluation eval= evaluationRepository.findById(id).orElseThrow(()->new NoSuchElementException());
		eval.setDocs(docsRepository.findByEvaluation(eval));
		return eval;
	}
}
