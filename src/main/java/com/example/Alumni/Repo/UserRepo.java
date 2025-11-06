package com.example.Alumni.Repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Alumni.Entities.User;



public interface UserRepo extends JpaRepository<User, Integer> {
	public User getByEmail(String e);
	
}
