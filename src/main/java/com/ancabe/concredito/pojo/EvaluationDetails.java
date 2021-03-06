package com.ancabe.concredito.pojo;

import java.io.Serializable;
import java.util.List;
import lombok.Data;
import lombok.ToString;

@Data
@ToString(exclude = {"docs_name"})
public class EvaluationDetails implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private String lastname;
	private String surname;
	private String address;
	private Integer addressnumber;
	private String colonia;
	private String postalCode;
	private String contact;
	private String rfc;
	private String status;
	private String observations;
	private List<DocsDetail> docs_name;
	public EvaluationDetails(Integer id,String name, String lastname, String surname, String status) {
		this.id=id;
		this.name = name;
		this.lastname = lastname;
		this.surname = surname;
		this.status = status;
	}
	public EvaluationDetails(Integer id,String name, String lastname, String surname, String address, Integer addressnumber,
			String colonia, String postalCode, String contact, String rfc, String status,String observations,List<DocsDetail> docs_name) {
		this.name = name;
		this.lastname = lastname;
		this.surname = surname;
		this.address = address;
		this.addressnumber = addressnumber;
		this.colonia = colonia;
		this.postalCode = postalCode;
		this.contact = contact;
		this.rfc = rfc;
		this.status = status;
		this.observations=observations;
		this.docs_name=docs_name;
	}
	public EvaluationDetails(int id,String name, String lastname, String surname, String address, Integer addressnumber,
			String colonia, String postalCode, String contact, String rfc, String status,String observations) {
		this.name = name;
		this.lastname = lastname;
		this.surname = surname;
		this.address = address;
		this.addressnumber = addressnumber;
		this.colonia = colonia;
		this.postalCode = postalCode;
		this.contact = contact;
		this.rfc = rfc;
		this.status = status;
		this.observations=observations;
	}

	public EvaluationDetails(String name, String first_lastname, String second_lastname, String address, Integer address_number, String colonia, String postal_code, String contact, String rfc, String status, List<String> docs_name) {
	}
}

