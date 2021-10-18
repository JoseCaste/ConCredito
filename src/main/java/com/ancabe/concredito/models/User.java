package com.ancabe.concredito.models;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.List;
import java.util.Set;

@Data
@ToString
@AllArgsConstructor
@Entity(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@Column
	private String username;

	@Column
	private String password;

	@Column
	private boolean enabled;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="authorities_users",
			joinColumns=@JoinColumn(name="usuario_id"),
			inverseJoinColumns=@JoinColumn(name="authority_id"))
	private List<Authority> authority;

	public User(String username, String password, List<Authority> authority) {
		this.username = username;
		this.password = password;
		this.authority = authority;
	}

	public User() {
	}
}
