package com.nexscend.employee.management.model;

import java.util.Arrays;

import org.springframework.stereotype.Component;

import com.nexscend.employee.management.entity.DocumentDetails;

@Component
public class CandidateModel {

	private Integer id;
	private String position;
	private String firstName;
	private String lastName;
	private String email;
	private Long contact;
	private String skills;
	private String joining;
	private String comments;
	
	private String fileName;
	
//	DocumentDetails file;
	private byte[] fileData;
	
	private String name;
	
	private String type;
	
	public byte[] getFileData() {
		return fileData;
	}

	public void setFileData(byte[] fileData) {
		this.fileData = fileData;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getContact() {
		return contact;
	}

	public void setContact(Long contact) {
		this.contact = contact;
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

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public String toString() {
		return "CandidateModel [id=" + id + ", position=" + position + ", firstName=" + firstName + ", lastName="
				+ lastName + ", email=" + email + ", contact=" + contact + ", skills=" + skills + ", joining=" + joining
				+ ", comments=" + comments + ", fileName=" + fileName + ", fileData=" + Arrays.toString(fileData)
				+ ", name=" + name + ", type=" + type + "]";
	}

}
