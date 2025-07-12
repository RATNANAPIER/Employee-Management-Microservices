package com.napier.employeeservice.controller;

import com.napier.employeeservice.dto.APIResponseDto;
import com.napier.employeeservice.dto.EmployeeDto;
import com.napier.employeeservice.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(
        name = "Employee Service - OrganizationController",
        description = "EmployeeController Exposes REST APIs for Employee Service "
)
@RestController
@RequestMapping("api/employees")
@AllArgsConstructor
public class EmployeeController {

    private EmployeeService employeeService;

    //Build Save Employee REST API
    @Operation(
            summary = "Save Employee REST API",
            description = "Save employee REST API is used to save employee object in the database"
    )
    //To describe the REST API response
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 CREATED"
    )
    @PostMapping
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto savedEmployeeDto  = employeeService.saveEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployeeDto, HttpStatus.CREATED);
    }

    //Build Get Employee By id REST API
    @Operation(
            summary = "Get Employee REST API",
            description = "Get Employee REST API is used to get a single employee object from the database"
    )
    //To describe the API response
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    @GetMapping("{id}")
    public ResponseEntity<APIResponseDto> getEmployeeById(@PathVariable("id") Long employeeDtoId){
        APIResponseDto apiResponseDto = employeeService.getEmployeeById(employeeDtoId);
        return new ResponseEntity<>(apiResponseDto,HttpStatus.OK);
    }
}
