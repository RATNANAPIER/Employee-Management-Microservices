package com.napier.employeeservice.service;

import com.napier.employeeservice.dto.APIResponseDto;
import com.napier.employeeservice.dto.EmployeeDto;

public interface EmployeeService {

    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    APIResponseDto getEmployeeById(Long employeeId);
}
