package com.ancabe.concredito.pojo;

import java.io.Serializable;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ProspectEvaluation implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private String lastname;
	private String surname;
	public ProspectEvaluation(Integer id,String name, String lastname, String surname) {
		this.id=id;
		this.name = name;
		this.lastname = lastname;
		this.surname = surname;
	}
	public ProspectEvaluation() {
	}
	
	
}