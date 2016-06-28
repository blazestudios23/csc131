package com.pojo;

import java.util.List;

public class StudentInfo{
 
	String username;
	String studentId;
	List<String> dateAttendance;
	
	public StudentInfo(String username, String studentId, List<String> dateAttendance) {
		super();
		this.username = username;
		this.studentId = studentId;
		this.dateAttendance = dateAttendance;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public List<String> getDateAttendance() {
		return dateAttendance;
	}

	public void setDateAttendance(List<String> dateAttendance) {
		this.dateAttendance = dateAttendance;
	}
	
}