package com.napier.employeeservice.service.impl;

import com.napier.employeeservice.Entity.Employee;
import com.napier.employeeservice.dto.APIResponseDto;
import com.napier.employeeservice.dto.DepartmentDto;
import com.napier.employeeservice.dto.EmployeeDto;
import com.napier.employeeservice.dto.OrganizationDto;
import com.napier.employeeservice.mapper.EmployeeMapper;
import com.napier.employeeservice.repository.EmployeeRepository;
import com.napier.employeeservice.service.EmployeeService;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    //Injection EmployeeRepository using constructor based injection we don't need to mention autowire because it is a single parameterized constructor
    private EmployeeRepository employeeRepository;
    //private RestTemplate restTemplate;
    private WebClient webClient;
    //private APIClient apiClient; // Injection {OpenFeignClient} apiClient using constructor based injection we don't need to mention autowire because it is a single parameterized constructor.

    //LOGGER instance
    private static final Logger LOGGER = LoggerFactory.getLogger(Employee.class);
    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);

        Employee savedEmployee = employeeRepository.save(employee);
        EmployeeDto savedEmployeeDto = EmployeeMapper.mapToEmployeeDto(savedEmployee);
        return savedEmployeeDto;
    }

    //This method internally calling external microservices
    //@CircuitBreaker(name = "${spring.application.name}",fallbackMethod = "getDefaultDepartment")
    @Retry(name = "${spring.application.name}",fallbackMethod = "getDefaultDepartment")
    public APIResponseDto getEmployeeById(Long employeeId){

        //log statement
        LOGGER.info("inside getEmployeeById() method");
        Employee employee = employeeRepository.findById(employeeId).get(); //retrieving employee from the database

        //here we are passing url as first argument and response type Object as DepartmentDto.class to make REST API CALL
        //This getForEntity() returns response Entity so we will save it into Response Entity class
        //ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity("http://localhost:8080/api/departments/"+employee.getDepartmentCode(), DepartmentDto.class);

        //Internally calling department-service
        //we are saving DepartmentDto from ResponseEntity of WebClient Object calling Department-microservices
        DepartmentDto departmentDto =webClient.get() //we make REST API call to department-microservices using get()
                .uri("http://localhost:8080/api/departments/" +employee.getDepartmentCode()) //To pass the URL along with departmentCode using uri()
                .retrieve() //here when we are making REST API call. to retrieve department.class we use retrieve method
                .bodyToMono(DepartmentDto.class) // To convert the HTTP response body into a reactive Object
                .block(); //To make a synchronous_call


        //we are saving DepartmentDto from ResponseEntity
        //DepartmentDto departmentDto = responseEntity.getBody();


        //we are saving the DepartmentDto from getDepartmentDto() passing departmentCode into the method.
        //DepartmentDto departmentDto = apiClient.getDepartmentDto(employee.getDepartmentCode());

        //Internally calling department-service
        //we are saving organizationDto from ResponseEntity of WebClient Object calling organization-microservices
        OrganizationDto organizationDto = webClient.get()
                .uri("http://localhost:8083/api/organizations/" +employee.getOrganizationCode())
                .retrieve()
                .bodyToMono(OrganizationDto.class)
                .block();

        //converting employee to employeeDto
        EmployeeDto employeeDto = EmployeeMapper.mapToEmployeeDto(employee);


        //Here we are sending employeeDto, departmentDto, organizationDto to the client using APIResponseDto class
        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployeeDto(employeeDto);
        apiResponseDto.setDepartmentDto(departmentDto);
        apiResponseDto.setOrganizationDto(organizationDto);

        return apiResponseDto; //this method return APIResponseDto to the client
    }



    //Building a fall-back method when the department-service is down
    public APIResponseDto getDefaultDepartment(Long employeeId,Exception exception){

        //log statement
        LOGGER.info("inside getDefaultDepartment() method");

        Employee employee = employeeRepository.findById(employeeId).get(); //retrieving employee from the database

        //Created default departmentDto and adding it to API ResponseDTO
        //Instead of returning DepartmentDto it returns a fallback method holding a dummy department and employeeDto, it will not call department-service
        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setDepartmentName("R&D Department");
        departmentDto.setDepartmentCode("RD001");
        departmentDto.setDepartmentDescription("Research and Development Department");

        //converting employee to employeeDto
        EmployeeDto employeeDto = EmployeeMapper.mapToEmployeeDto(employee);

        //Here we are sending employeeDto and departmentDto to the client using APIResponseDto class
        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployeeDto(employeeDto);
        apiResponseDto.setDepartmentDto(departmentDto);

        return apiResponseDto; //this method return APIResponseDto to the client

    }
}
