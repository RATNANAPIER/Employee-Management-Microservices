package com.napier.employeeservice.service;

import com.napier.employeeservice.dto.OrganizationDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(url="http://localhost:8080",value="DEPARTMENT-SERVICE") //Here The feign client library will create dynamic implementation for this interface-APIClient
//we have provided the base URL to the APIClient interface to make REST API call
@FeignClient(name="DEPARTMENT-SERVICE",contextId = "organizationClient") //from the above annotation feignClient is fixed to one portNumber so if the port is down we cannot make a call so we're directly using name of the microservice so that if one port is down the other port can be utilized which is up
public interface organizationAPIClient {
    //we declare a method to which we are going to make a REST API Call {getOrganization()} to Organization-service from employee-service.
    //OpenFeign Library will directly create dynamic implementation we don't need to implement manually for the below method
    @GetMapping("api/organizations/{organization-code}")
    OrganizationDto getOrganizationDto(@PathVariable("organization-code")String organizationCode);
}
