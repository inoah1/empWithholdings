package com.noah.capstone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
public class EmpWithholdingApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmpWithholdingApplication.class, args);
	}
	
	@Bean(name = "loadBalanced")
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@Bean(name = "nonLoadBalanced")
	public RestTemplate nonLoadBalancedRestTemplate() {
		return new RestTemplate();
	}

}
