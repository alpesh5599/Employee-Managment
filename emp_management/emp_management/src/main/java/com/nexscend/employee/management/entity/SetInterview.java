package com.nexscend.employee.management.entity;

import java.time.LocalDateTime;

import com.nexscend.employee.management.Abstract.AbstactClass;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="setInterview")
public class SetInterview extends AbstactClass{

//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Integer interviewId;
	private String interviewerName;
	private LocalDateTime interviewDateTime;
	private String interviewOutCome;
	private String feedback;
	
//	public Integer getInterviewId() {
//		return interviewId;
//	}
//	public void setInterviewId(Integer interviewId) {
//		this.interviewId = interviewId;
//	}
	public String getInterviewerName() {
		return interviewerName;
	}
	public void setInterviewerName(String interviewerName) {
		this.interviewerName = interviewerName;
	}
	public LocalDateTime getInterviewDateTime() {
		return interviewDateTime;
	}
	public void setInterviewDateTime(LocalDateTime interviewDateTime) {
		this.interviewDateTime = interviewDateTime;
	}
	public String getInterviewOutCome() {
		return interviewOutCome;
	}
	public void setInterviewOutCome(String interviewOutCome) {
		this.interviewOutCome = interviewOutCome;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	@Override
	public String toString() {
		return "SetInterview [interviewerName=" + interviewerName
				+ ", interviewDateTime=" + interviewDateTime + ", interviewOutCome=" + interviewOutCome + ", feedback="
				+ feedback + "]";
	}
}