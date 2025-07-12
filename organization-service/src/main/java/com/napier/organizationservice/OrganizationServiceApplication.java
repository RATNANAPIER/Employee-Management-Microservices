package com.napier.organizationservice;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
		info = @Info(
				title = "Organization Service REST APIs",
				description = "Organization Service REST APIs Documentation",
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
				description = "Organization Service Doc",
				url = "napier.com/Organization_Service.html"
		)
)
@SpringBootApplication

public class OrganizationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrganizationServiceApplication.class, args);
	}

}
