package com.noah.capstone.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class EmployeeTaxWithholdingsDto {
	
	private int employeeId;
	private double empFedWhPct;
	private double empStateWhPct;
	private double empCityWhPct;
	private double totalWitholdings;
	private String errorMsg;
	
	public EmployeeTaxWithholdingsDto() {
		super();
	}

	public EmployeeTaxWithholdingsDto(int employeeId, String errorMsg) {
		super();
		this.employeeId = employeeId;
		this.errorMsg = errorMsg;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public double getEmpFedWhPct() {
		return empFedWhPct;
	}

	public void setEmpFedWhPct(double empFedWhPct) {
		this.empFedWhPct = empFedWhPct;
	}

	public double getEmpStateWhPct() {
		return empStateWhPct;
	}

	public void setEmpStateWhPct(double empStateWhPct) {
		this.empStateWhPct = empStateWhPct;
	}

	public double getEmpCityWhPct() {
		return empCityWhPct;
	}

	public void setEmpCityWhPct(double empCityWhPct) {
		this.empCityWhPct = empCityWhPct;
	}

	public double getTotalWitholdings() {
		return totalWitholdings;
	}

	public void setTotalWitholdings(double totalWitholdings) {
		this.totalWitholdings = totalWitholdings;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	@Override
	public String toString() {
		return "EmployeeTaxWithholdingsDto [employeeId=" + employeeId + ", empFedWhPct=" + empFedWhPct
				+ ", empStateWhPct=" + empStateWhPct + ", empCityWhPct=" + empCityWhPct + ", totalWitholdings="
				+ totalWitholdings + ", errorMsg=" + errorMsg + "]";
	}	

}
