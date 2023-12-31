package com.nexscend.employee.management.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.nexscend.employee.management.model.CandidateModel;
import com.nexscend.employee.management.model.CandidatewithFileModel;

public interface CandidateService {
	
	Map<String, String> saveCandidate(CandidateModel candidate,MultipartFile file);
	
	List<CandidatewithFileModel> getAllCandidate();
}
