package com.ancabe.concredito.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ancabe.concredito.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	public User findByusername(String email);
}
