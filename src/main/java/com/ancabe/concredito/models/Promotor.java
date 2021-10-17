package com.ancabe.concredito.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@Entity
public class Promotor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_promotor")
	private int id_promotor;
	private String name;
	private String lastname;
	private String email;
	private String password;
	
	public Promotor() {
	}
}
