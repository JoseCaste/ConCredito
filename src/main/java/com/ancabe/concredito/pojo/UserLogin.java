package com.ancabe.concredito.pojo;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class UserLogin implements Serializable{
	private static final long serialVersionUID = 1L;
	private String email;
	private String password;
}
