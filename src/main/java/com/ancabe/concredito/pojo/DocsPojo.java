package com.ancabe.concredito.pojo;

import java.io.Serializable;

import lombok.Data;
import lombok.ToString;
@Data
@ToString
public class DocsPojo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	public DocsPojo(Integer id,String name) {
		this.id=id;
		this.name = name;
	}
	
	public DocsPojo() {
		
	}
	
}
