package com.nexscend.employee.management.entity;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Date;

import com.nexscend.employee.management.Abstract.AbstactClass;

import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name = "DocumentDetails")
public class DocumentDetails extends AbstactClass {

//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Integer id;
	private String name;
	private String type;

	private Double size;

	private String hash;

	@Lob
	private byte[] fileData;

	private String candidateId;
	
	private Integer status;
	
	public static final int RADIX = 16;
	
//	public Integer getId() {
//		return id;
//	}
//
//	public void setId(Integer id) {
//		this.id = id;
//	}

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

	public byte[] getFileData() {
		return fileData;
	}

	public void setFileData(byte[] fileData) {
		this.fileData = fileData;
	}

	public String getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(String candidateId) {
		this.candidateId = candidateId;
	}

	public String getHash() {
		return hash;
	}
	
	public Double getSize() {
		return size;
	}

	public void setSize(Double size) {
		this.size = size;
	}

	public void setHash() throws NoSuchAlgorithmException {
		String trasformedName = new StringBuilder().append(this.name).append(this.type).append(this.size)
				.append(new Date().getTime()).toString();
		
		MessageDigest messageDigest = MessageDigest.getInstance("MD5");
		messageDigest.update(trasformedName.getBytes(StandardCharsets.UTF_8));
		
		this.hash = new BigInteger(1, messageDigest.digest()).toString(RADIX);
	}
	
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "FileDetails [name=" + name + ", type=" + type + ", fileData=" + Arrays.toString(fileData)
				+ ", candidateId=" + candidateId + "]";
	}
}