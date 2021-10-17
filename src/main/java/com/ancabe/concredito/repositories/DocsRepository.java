package com.ancabe.concredito.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ancabe.concredito.models.Docs;
import com.ancabe.concredito.models.Evaluation;

public interface DocsRepository extends JpaRepository<Docs, Integer>{

	public List<Docs> findByEvaluation(Evaluation evaluation);
}
