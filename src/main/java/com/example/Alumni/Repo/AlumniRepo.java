package com.example.Alumni.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Alumni.Entities.Alumni;

public interface AlumniRepo extends JpaRepository<Alumni, Integer> {

}
