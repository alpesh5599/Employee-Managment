package com.nexscend.employee.management.service;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

public interface DocumentService {

	Map<String, String> saveDocument(MultipartFile file, String request);
	
	Map<String, String> saveDocument(MultipartFile file);
	
	Object saveFile(MultipartFile file);
	
}