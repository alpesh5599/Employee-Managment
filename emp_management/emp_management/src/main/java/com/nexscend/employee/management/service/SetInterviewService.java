package com.nexscend.employee.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nexscend.employee.management.entity.SetInterview;
import com.nexscend.employee.management.repository.SetInterviewRepository;

@Service
public class SetInterviewService {

	@Autowired
	SetInterviewRepository interviewRepository;
	
	public SetInterview scheduleInterview(SetInterview interview) {	
		return interviewRepository.save(interview);
	}
	
	public List<SetInterview> getAllInterviewDetails(){
		return interviewRepository.findAll();
	}
	
	public SetInterview editInterviewDetails(SetInterview interview, Integer id) {
		SetInterview save=interviewRepository.findById(id).get();
		
		save.setInterviewerName(interview.getInterviewerName());
		save.setInterviewDateTime(interview.getInterviewDateTime());
		save.setInterviewOutCome(interview.getInterviewOutCome());
		save.setFeedback(interview.getFeedback());
		
		return interviewRepository.save(save);
	}
	
	public void deleteInterview(Integer id) {
		interviewRepository.deleteById(id);
	}
	
	
}