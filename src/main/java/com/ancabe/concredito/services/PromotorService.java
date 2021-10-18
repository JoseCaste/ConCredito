package com.ancabe.concredito.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ancabe.concredito.models.Promotor;
import com.ancabe.concredito.repositories.PromotorRepository;

@Service
public class PromotorService{
	@Autowired
	private PromotorRepository promotorRepository;
	
	public Promotor findByEmail(String email) {
		return promotorRepository.findByEmail(email);
	}

    public Promotor save(Promotor promotor) {
		return promotorRepository.save(promotor);
    }
}
