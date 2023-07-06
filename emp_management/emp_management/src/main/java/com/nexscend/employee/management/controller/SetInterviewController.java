package com.nexscend.employee.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nexscend.employee.management.entity.SetInterview;
import com.nexscend.employee.management.service.SetInterviewService;

@RestController
@RequestMapping("api/v1/interview")
@CrossOrigin("*")
public class SetInterviewController {
	
	@Autowired
	SetInterviewService interviewService;
	
	@PostMapping("/schedule/interview")
	public SetInterview setInterview(@RequestBody SetInterview interview) {
		return interviewService.scheduleInterview(interview);
	}
	
	@GetMapping("/getAll/interviewDetails")
	public List<SetInterview> showScheduledInterview(){
		return interviewService.getAllInterviewDetails();
	}
	
	@PutMapping("/edit/interview/{id}")
	public SetInterview updateInterview(@RequestBody SetInterview interview, @PathVariable Integer id) {
		return interviewService.editInterviewDetails(interview, id);
	}

}