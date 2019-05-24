package com.noah.capstone.service;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.noah.capstone.dao.model.Withholding;
import com.noah.capstone.dao.repository.WithholdingRepository;
import com.noah.capstone.model.dto.EmpBenefitsDto;
import com.noah.capstone.model.dto.EmpStatusDto;
import com.noah.capstone.model.dto.EmployeeTaxWithholdingsDto;

@Service
public class WithholdingService {
	
	Logger logger = LoggerFactory.getLogger(WithholdingService.class);
	
	@Value("${empstatus.eurekaURI}")
	private String empStatusEurekaURI;
	
	@Value("${empstatus.directURI}")
	private String empStatusDirectURI;
	
	@Value("${empbenefits.eurekaURI}")
	private String empBenefitsEurekaURI;
	
	@Value("${empbenefits.directURI}")
	private String empBenefitsDirectURI;
	
	@Autowired
	@Qualifier("loadBalanced")
	RestTemplate restTemplateLoadBalanced;
	
	@Autowired
	@Qualifier("nonLoadBalanced")
	RestTemplate restTemplateNonLoadBalanced;
	
	@Autowired
	private WithholdingRepository repository;
	
	@HystrixCommand(fallbackMethod = "getWitholdings_fallback")
	public EmployeeTaxWithholdingsDto getWitholdings(int employeeId) {
		return worker(employeeId, empStatusEurekaURI, empBenefitsEurekaURI, restTemplateLoadBalanced);
	}
	
	public EmployeeTaxWithholdingsDto getWitholdings_fallback(int employeeId) {
		return worker(employeeId, empStatusDirectURI, empBenefitsDirectURI, restTemplateNonLoadBalanced);
	}

	private EmployeeTaxWithholdingsDto worker(int employeeId, String empStatusURI, String empBenefitsURI,
			RestTemplate restTemplate) {
		try {
			String empStatus = getStatus(employeeId, empStatusURI, restTemplate).getEmpStatus();
			if("Active".equalsIgnoreCase(empStatus)) {
				Withholding dbWitholding = repository.findByEmployeeId(employeeId);
				EmpBenefitsDto benefits = getBenefits(employeeId, empBenefitsURI, restTemplate);
				
				EmployeeTaxWithholdingsDto response = new EmployeeTaxWithholdingsDto();
				response.setEmployeeId(employeeId);
				response.setEmpFedWhPct(dbWitholding.getEmpFedWhPct());
				response.setEmpStateWhPct(dbWitholding.getEmpStateWhPct());
				response.setEmpCityWhPct(dbWitholding.getEmpCityWhPct());
				response.setTotalWitholdings(benefits.getTotalWitholdings());
				return response;
			} else {
				return new EmployeeTaxWithholdingsDto(employeeId, "NOT_FOUND");
			}
		} catch (Exception e) {
			logger.error("Exception while getting witholdings", e);
			return new EmployeeTaxWithholdingsDto(employeeId, e.getMessage());
		}
	}
	
	private EmpStatusDto getStatus(int employeeId, String empStatusURI, RestTemplate restTemplate) {
		EmpStatusDto response = restTemplate.getForObject(empStatusURI, EmpStatusDto.class, employeeId);
		logger.debug("empStatus response for employeeId " + employeeId + " = " + response);
		return response;
	}
	
	private EmpBenefitsDto getBenefits(int employeeId, String empBenefitsURI, RestTemplate restTemplate) {
		Map<String, String> request = new HashMap<>();
		request.put("employeeId", String.valueOf(employeeId));
		ResponseEntity<EmpBenefitsDto> responseEntity = restTemplate.postForEntity(empBenefitsURI, request, EmpBenefitsDto.class);
		logger.debug("empBenefits call response status = " + responseEntity.getStatusCodeValue());
		
		logger.debug("empBenefits response for employeeId " + employeeId + " = " + responseEntity.getBody());
		return responseEntity.getBody();
	}
	
	
	
	
	

}
