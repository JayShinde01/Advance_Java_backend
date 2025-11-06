package com.example.Alumni.Entities;

import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;
import jakarta.persistence.*;

@Entity
@Table(name="users",
uniqueConstraints = {@UniqueConstraint(columnNames = {"email","mobile"})})
public class User{

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
 int userId;
@Enumerated(EnumType.STRING)
 Role role;
@Column(nullable = false)
 String name;
 String email;
 @Column(nullable = false)
 String password;
 @Column(nullable = false)
 String mobile;
 @CreationTimestamp   // Auto-set on INSERT
  LocalDateTime createdAt;

 
 public User() {
	super();
	// TODO Auto-generated constructor stub
}

 

 public User(int userId, Role role,
		 String name, String email, String password, 
		 String mobile, LocalDateTime createdAt) {
	super();
	this.userId = userId;
	this.role = role;
	this.name = name;
	this.email = email;
	this.password = password;
	this.mobile = mobile;
	this.createdAt = createdAt;
}



 public int getUserId() {
	return userId;
}



 public void setUserId(int userId) {
	this.userId = userId;
 }



 public Role getRole() {
	return role;
 }



 public void setRole(Role role) {
	this.role = role;
 }



 public String getName() {
	return name;
 }



 public void setName(String name) {
	this.name = name;
 }



 public String getEmail() {
	return email;
 }



 public void setEmail(String email) {
	this.email = email;
 }



 public String getPassword() {
	return password;
 }



 public void setPassword(String password) {
	this.password = password;
 }



 public String getMobile() {
	return mobile;
 }



 public void setMobile(String mobile) {
	this.mobile = mobile;
 }



 public LocalDateTime getCreatedAt() {
	return createdAt;
 }



 public void setCreatedAt(LocalDateTime createdAt) {
	this.createdAt = createdAt;
 }



 public enum Role {
	    ADMIN,
	    STUDENT,
	    ALUMNI
}
 
}
