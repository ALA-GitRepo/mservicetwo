package com.gopal.mservicetwo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@RestController
//@EnableFeignClients
@EnableCircuitBreaker
public class MservicetwoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MservicetwoApplication.class, args);
	}

	@Autowired
	private feignConnectImpl feignConnectimpl;

	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}


	@Value("${newmessage:default}")
	private String message;

	@GetMapping("/newmessage")
	private String getInfo() {
		System.out.println("Message : " + message);
		return message;
	}

	@GetMapping("/serviceOne")
	private String getDataFromServiceOne(){

		return feignConnectimpl.getDataServiceOne();
	}
}
