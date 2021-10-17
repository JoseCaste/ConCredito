package com.ancabe.concredito.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ancabe.concredito.models.Evaluation;

public interface EvaluationRepository extends JpaRepository<Evaluation, Integer> {

}
