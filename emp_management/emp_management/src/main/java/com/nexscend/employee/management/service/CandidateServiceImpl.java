package com.nexscend.employee.management.service;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.nexscend.employee.management.entity.Candidate;
import com.nexscend.employee.management.model.CandidateModel;
import com.nexscend.employee.management.repository.CandidateRepository;
import com.nexscend.employee.management.utils.Status;

@Service
public class CandidateServiceImpl implements CandidateService {

	Logger logger = LoggerFactory.getLogger(CandidateServiceImpl.class);

	@Autowired
	CandidateRepository candidateRepository;
	
	@Autowired
	DocumentService documentServices;	

	@Override
	public Map<String, String> saveCandidate(CandidateModel request,MultipartFile file) {

		// For DB Save
		Candidate candidate = new Candidate();
		
		Map<String, String> response = null;

		if (request == null) {
			logger.error("Requested Model Are Not found...");
		}

		candidate.setPosition(request.getPosition());
		candidate.setFirstName(request.getFirstName());
		candidate.setLastName(request.getLastName());
		candidate.setEmail(request.getEmail());
		candidate.setContect(request.getContact());
		candidate.setSkills(request.getSkills());
		candidate.setJoining(request.getJoining());
		
		candidate.setComments(request.getComments());
		candidate.setStatus(Status.ACTIVE.getStatusValue());
		
		Candidate save = candidateRepository.save(candidate);
		
		if(file != null) {
			response = documentServices.saveDocument(file, save.getId().toString());
		}
		
		
		return response;
	}

//	@Override
//	public List<CandidateResponse> getAllCandidateDetails() {
//		
//		return candidateRepository
//	}

//	public List<Candidate> getAllCandidate(){
//		return candidateRepository.findAll();
//	}
//	
//	public Candidate getCandidateById(Integer id) {
//		return candidateRepository.findById(id).get();
//	}
//	
//	public Candidate editCandidateDetails(Candidate candidate, Integer id) {
//		Candidate c=candidateRepository.findById(id).get();
//		
//		c.setApplyingPosition(candidate.getApplyingPosition());
//		c.setCandidateFirstName(candidate.getCandidateFirstName());
//		c.setCandidateLastName(candidate.getCandidateLastName());
//		c.setCandidateEmail(candidate.getCandidateEmail());
//		c.setCandidatePhoneNo(candidate.getCandidatePhoneNo());
//		c.setCandidateSkills(candidate.getCandidateSkills());
//		c.setJoiningAvailability(candidate.getJoiningAvailability());
//		c.setComments(candidate.getComments());
//		
//		return candidateRepository.save(c);
//	}

}