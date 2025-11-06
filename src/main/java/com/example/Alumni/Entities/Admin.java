package com.example.Alumni.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;

@Entity
public class Admin {
	@Id
	int adminId;
	@OneToOne
    @MapsId   // Shares PK with users
    @JoinColumn(name = "admin_id") // FK to users.id
    private User user;
	
	private String designation;
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Admin(int adminId, User user,String designation) {
		super();
		this.adminId = adminId;
		this.user = user;
		this.designation=designation;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Admin(String designation) {
		super();
		this.designation = designation;
	}

	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
	
}
