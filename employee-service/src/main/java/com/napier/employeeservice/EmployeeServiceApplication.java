package com.napier.employeeservice;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@OpenAPIDefinition(
		info = @Info(
				title = "Employee Service REST APIs",
				description = "Employee Service REST APIs Documentation",
				version = "v1.0",
				contact = @Contact(
						name = "Napier",
						email = "napier@gmail.com",
						url = "napier.com"
				),
				license = @License(
						name = "Apache 2.0",
						url = "napier.cmo/license"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Employee Service Doc",
				url = "napier.com/Employee_Service.html"
		)
)
@SpringBootApplication
@EnableFeignClients //We declare this class as FeignClient to call other microservices through REST API
public class EmployeeServiceApplication {

	@Bean
	public WebClient webClient(){
		return WebClient.builder().build(); // build() finalizes the WebClient.Builder instance which is ready to use WebClient instance
	}


	public static void main(String[] args) {
		SpringApplication.run(EmployeeServiceApplication.class, args);
	}

}
