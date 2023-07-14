package com.nexscend.employee.management.model;

import java.util.Arrays;

import org.springframework.stereotype.Component;

@Component
public class DocumentModel {
	
	private String name;
	private byte[] fileData;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public byte[] getFileData() {
		return fileData;
	}
	public void setFileData(byte[] fileData) {
		this.fileData = fileData;
	}
	@Override
	public String toString() {
		return "DocumentModel [name=" + name + ", fileData=" + Arrays.toString(fileData) + "]";
	}
}
