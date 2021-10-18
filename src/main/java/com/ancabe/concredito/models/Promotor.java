package com.ancabe.concredito.models;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import java.util.List;

@Data
@ToString
@AllArgsConstructor
@Entity(name="promotor")
public class Promotor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_promotor")
	private int id_promotor;
	private String name;
	private String lastname;
	private String email;
	private String password;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="authorities_users",
			joinColumns=@JoinColumn(name="usuario_id"),
			inverseJoinColumns=@JoinColumn(name="authority_id"))
	private List<Authority> authority;
	
	public Promotor() {
	}

	public Promotor(String email, String password, List<Authority> authority) {
		this.email = email;
		this.password = password;
		this.authority = authority;
	}
}
