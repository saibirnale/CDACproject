 package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.pojos.User;
@Repository

public interface UserRepository extends JpaRepository<User, Long> {

//	@Query(value = "SELECT * FROM users WHERE email = ? AND password = ?",nativeQuery = true) 
	User findByEmailAndPassword(String email,String password);
}
