package com.nexscend.employee.management.entity;

import com.nexscend.employee.management.Abstract.AbstactClass;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "candidate")
public class Candidate extends AbstactClass{
	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Integer id;
	private String position;
	private String firstName;
	private String lastName;
	private String email;
	private Long contect;
	private String skills;
	
	// Here is the Avaibility of Joining....
	private String joining;
	private String comments;
	
	// Status for managing entity in Db.
	private Integer status;

//	public Integer getId() {
//		return id;
//	}
//
//	public void setId(Integer id) {
//		this.id = id;
//	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String emailmail) {
		this.email = emailmail;
	}

	public Long getContect() {
		return contect;
	}

	public void setContect(Long contect) {
		this.contect = contect;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public String getJoining() {
		return joining;
	}

	public void setJoining(String joining) {
		this.joining = joining;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Candidate [ position=" + position + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", contect=" + contect + ", skills=" + skills + ", joining=" + joining
				+ ", comments=" + comments + ", status=" + status + "]";
	}
}