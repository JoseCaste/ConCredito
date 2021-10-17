package com.ancabe.concredito.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.data.annotation.Transient;
import org.springframework.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Entity(name = "evaluation")
@Data
@AllArgsConstructor
@ToString
public class Evaluation {
	public static final String SENDS="ENVIADO";
	public static final String REJECT="RECHAZADO";
	public static final String allow="AUTORIZADO";
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_evaluation")
	@Nullable
	private int id_evaluation;
	private String status;
	@Column(name="prospect_name")
	private String name;
	@Column(name = "first_lastname")
	private String first_lastname;
	@Column(name = "second_lastname")
	private String second_lastname;
	@Column(name="address")
	private String address;
	@Column(name="address_number")
	private Integer address_number;
	@Column(name="colonia")
	private String colonia;
	@Column(name="postal_code")
	private String postal_code;
	@Column(name = "contact")
	private String contact;
	@Column(name="rfc")
	private String rfc;
	@Column(name="observations")
	private String observations;
	@Transient
	 @OneToMany(mappedBy = "id_doc", cascade = {
		        CascadeType.ALL
		    })
	 private List<Docs> docs;
	public Evaluation() {
	}
	 
	 
}
