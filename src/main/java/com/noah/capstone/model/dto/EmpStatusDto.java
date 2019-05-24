package com.noah.capstone.model.dto;

public class EmpStatusDto {
	
	private int employeeId;
	private String empStatus;
	
	public EmpStatusDto() {
		super();
	}

	public EmpStatusDto(int employeeId, String empStatus) {
		super();
		this.employeeId = employeeId;
		this.empStatus = empStatus;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmpStatus() {
		return empStatus;
	}

	public void setEmpStatus(String empStatus) {
		this.empStatus = empStatus;
	}

	@Override
	public String toString() {
		return "EmpStatusDto [employeeId=" + employeeId + ", empStatus=" + empStatus + "]";
	}

}
