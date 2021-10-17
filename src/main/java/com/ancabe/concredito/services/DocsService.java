package com.ancabe.concredito.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ancabe.concredito.models.Docs;
import com.ancabe.concredito.repositories.DocsRepository;

@Service
public class DocsService {

	@Autowired
	private DocsRepository docsRepository;
	
	public List<Docs> saveAllDoc(List<Docs> docs) {
		return docsRepository.saveAll(docs);
	}
}
