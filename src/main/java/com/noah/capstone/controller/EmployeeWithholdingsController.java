package com.noah.capstone.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.noah.capstone.model.dto.EmployeeTaxWithholdingsDto;
import com.noah.capstone.service.WithholdingService;

@RestController
@RequestMapping(path = "/empWithholdings")
public class EmployeeWithholdingsController {
	
	Logger logger = LoggerFactory.getLogger(EmployeeWithholdingsController.class);
	
	@Autowired
	WithholdingService service;
	
	@RequestMapping(path = "/info", produces = MediaType.TEXT_HTML_VALUE)
	private String info() {
		return "Employee Withholdings service is up and running";
	}
	
	@PostMapping(path = "/getwithholdings", produces = MediaType.APPLICATION_JSON_VALUE)
	public EmployeeTaxWithholdingsDto getWithholdings(@RequestBody Map<String, String> body) {
		String employeeId = body.get("employeeId");
		logger.debug("Getting withholdings for employeeId " + employeeId);
		return service.getWitholdings(Integer.parseInt(employeeId));
	}

}
