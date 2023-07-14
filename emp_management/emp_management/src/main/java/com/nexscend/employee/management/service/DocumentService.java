package com.nexscend.employee.management.service;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.nexscend.employee.management.model.ResponseBean;

public interface DocumentService {

	Map<String, String> saveDocument(MultipartFile file, String request);
	
	Map<String, String> saveDocument(MultipartFile file);
	
	Object saveFile(MultipartFile file);
	
	ResponseBean getFile(Integer id);
}