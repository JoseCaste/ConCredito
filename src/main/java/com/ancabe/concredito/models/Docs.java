package com.ancabe.concredito.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Entity(name="docs")
@Data
@AllArgsConstructor
@ToString
public class Docs {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_doc;
	@Column(name="name_doc")
	private String name;
	private String type;
	@Lob
	private byte[] file;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id_evaluation")
	private Evaluation evaluation;
	
	
	public Docs(String name, String type, byte[] file) {
		this.name = name;
		this.type = type;
		this.file = file;
	}

	public Docs(String name, String type, byte[] file, Evaluation evaluation) {
		this.name = name;
		this.type = type;
		this.file = file;
		this.evaluation = evaluation;
	}

	public Docs() {
	}
	
	
	
}
