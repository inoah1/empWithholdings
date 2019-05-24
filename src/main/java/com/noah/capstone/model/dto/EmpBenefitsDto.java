package com.noah.capstone.model.dto;

public class EmpBenefitsDto {
	
	private int employeeId;
	private double totalWitholdings;
	private WitholdingCurrency currency;
	
	public EmpBenefitsDto() {
		super();
	}

	public EmpBenefitsDto(int employeeId, double totalWitholdings, WitholdingCurrency currency) {
		super();
		this.employeeId = employeeId;
		this.totalWitholdings = totalWitholdings;
		this.currency = currency;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public double getTotalWitholdings() {
		return totalWitholdings;
	}

	public void setTotalWitholdings(double totalWitholdings) {
		this.totalWitholdings = totalWitholdings;
	}

	public WitholdingCurrency getCurrency() {
		return currency;
	}

	public void setCurrency(WitholdingCurrency currency) {
		this.currency = currency;
	}

	@Override
	public String toString() {
		return "EmpBenefitsDto [employeeId=" + employeeId + ", totalWitholdings=" + totalWitholdings + ", currency="
				+ currency + "]";
	}

}
