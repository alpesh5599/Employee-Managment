package com.nexscend.employee.management.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nexscend.employee.management.model.CandidateModel;
import com.nexscend.employee.management.model.CandidatewithFileModel;
import com.nexscend.employee.management.service.CandidateService;

@RestController
@RequestMapping("api/v1/candidate")
@CrossOrigin(origins = "http://localhost:4200")
public class CandidateController {

	Logger logger = LoggerFactory.getLogger(CandidateController.class);

	@Autowired
	CandidateService candidateService;

	@Autowired
	ObjectMapper mapper;

	@PostMapping(value = "/save/candidate")
	public ResponseEntity<Object> saveCandidateData(@RequestParam("candidate") String candidate,
			@RequestParam("file") MultipartFile file) {
		// Calling the service
		CandidateModel readValue = null;
		Map<String, String> saveCandidate = null;
		try {
			readValue = mapper.readValue(candidate, CandidateModel.class);
			saveCandidate = candidateService.saveCandidate(readValue, file);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return ResponseEntity.status(HttpStatus.CREATED).body(saveCandidate);
	}

	@GetMapping("/getAll")
	public List<CandidatewithFileModel> getAllCandidateData() {
		logger.info("Fetching All Candidate Details from Database...");
		return candidateService.getAllCandidate();
	}
//
//	@GetMapping("/getCandidate/ById/{id}")
//	public Candidate getCandidateDataById(@PathVariable Integer id) {
//		logger.info("Fetching Specific Candidate By Id...");
//		return candidateService.getCandidateById(id);
//	}
//
//	@PutMapping("/editCandidate/{id}")
//	public Candidate updateCandidateDetails(@RequestBody Candidate candidate, @PathVariable Integer id) {
//		logger.info("updating details of candidate...");
//		return candidateService.editCandidateDetails(candidate, id);
//	}

}