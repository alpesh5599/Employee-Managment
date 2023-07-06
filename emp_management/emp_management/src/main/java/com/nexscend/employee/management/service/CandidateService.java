package com.nexscend.employee.management.service;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.nexscend.employee.management.model.CandidateModel;

public interface CandidateService {
	
	Map<String, String> saveCandidate(CandidateModel candidate,MultipartFile file);
	
//	List<CandidateResponse> getAllCandidateDetails();
}
