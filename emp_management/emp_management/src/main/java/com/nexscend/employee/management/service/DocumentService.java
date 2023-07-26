package com.nexscend.employee.management.service;

import java.io.InputStream;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.nexscend.employee.management.model.ResponseBean;

import jakarta.servlet.http.Part;

public interface DocumentService {

	Map<String, String> saveDocument(MultipartFile file, String request);
	
	Map<String, String> saveDocument(MultipartFile file);
	
	Object saveFile(MultipartFile file);
	
	ResponseBean getFile(Integer id);

	Map<String, String> saveDocument(Part part, InputStream inputStream, String contentType, Integer contentLength);

	Map<String, String> saveDocument(byte[] fileBytes);
}