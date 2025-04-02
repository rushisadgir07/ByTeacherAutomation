package com.byteacher.automation.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExamDetailsDto {
	private String assesmentName;
	private String totalMarks;
	private String passingMarks;
	private String startDate;
	private String endDate;
	private String examDeadline;

	public String getAssesmentName() {
		return assesmentName;
	}

	public void setAssesmentName(String assesmentName) {
		this.assesmentName = assesmentName;
	}

	public String getTotalMarks() {
		return totalMarks;
	}

	public void setTotalMarks(String totalMarks) {
		this.totalMarks = totalMarks;
	}

	public String getPassingMarks() {
		return passingMarks;
	}

	public void setPassingMarks(String passingMarks) {
		this.passingMarks = passingMarks;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getExamDeadline() {
		return examDeadline;
	}
	public void setDeadline(String examDeadline) {
		this.examDeadline=examDeadline;
		
	}
}
