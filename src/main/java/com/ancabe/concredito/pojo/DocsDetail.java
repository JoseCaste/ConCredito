package com.ancabe.concredito.pojo;

import java.io.Serializable;

import lombok.Data;
import lombok.ToString;
@Data
@ToString
public class DocsDetail implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	public DocsDetail(Integer id, String name) {
		this.id=id;
		this.name = name;
	}
	
	public DocsDetail() {
		
	}
	
}
