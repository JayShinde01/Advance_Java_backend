package com.example.Alumni.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Alumni")
public class Alumni {
	
	    @Id
	    private int alumniId; // This will be same as userId (PK + FK)

	    private String prn;
	    private String companyName;
	    private String position;
	    private String techStack;
	    private String profilePic;
	    

	    @OneToOne
	    @MapsId   // Shares PK with users
	    @JoinColumn(name = "alumni_id") // FK to users.id
	    private User user;


		public Alumni() {
			super();
			// TODO Auto-generated constructor stub
		}


		public Alumni(int alumniId, String prn, String companyName, String position, String techStack,
				String profilePic, User user) {
			super();
			this.alumniId = alumniId;
			this.prn = prn;
			this.companyName = companyName;
			this.position = position;
			this.techStack = techStack;
			this.profilePic = profilePic;
			this.user = user;
		}


		public int getAlumniId() {
			return alumniId;
		}


		public void setAlumniId(int alumniId) {
			this.alumniId = alumniId;
		}


		public String getPrn() {
			return prn;
		}


		public void setPrn(String prn) {
			this.prn = prn;
		}


		public String getCompanyName() {
			return companyName;
		}


		public void setCompanyName(String companyName) {
			this.companyName = companyName;
		}


		public String getPosition() {
			return position;
		}


		public void setPosition(String position) {
			this.position = position;
		}


		public String getTechStack() {
			return techStack;
		}


		public void setTechStack(String techStack) {
			this.techStack = techStack;
		}


		public String getProfilePic() {
			return profilePic;
		}


		public void setProfilePic(String profilePic) {
			this.profilePic = profilePic;
		}


		public User getUser() {
			return user;
		}


		public void setUser(User user) {
			this.user = user;
		}
	    
}
