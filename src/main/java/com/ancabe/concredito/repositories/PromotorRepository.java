package com.ancabe.concredito.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ancabe.concredito.models.Promotor;
import org.springframework.stereotype.Repository;

@Repository
public interface PromotorRepository extends JpaRepository<Promotor, Integer> {
	public Promotor findByEmail(String email);
}
