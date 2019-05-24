package com.noah.capstone.dao.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Withholding {
	
	@Id
	private int employeeId;
	private double empFedWhPct;
	private double empStateWhPct;
	private double empCityWhPct;
	
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
	
	@Override
	public String toString() {
		return "Withholding [employeeId=" + employeeId + ", empFedWhPct=" + empFedWhPct + ", empStateWhPct="
				+ empStateWhPct + ", empCityWhPct=" + empCityWhPct + "]";
	}

}
