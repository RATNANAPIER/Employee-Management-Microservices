package com.napier.employeeservice.mapper;

import com.napier.employeeservice.Entity.Employee;
import com.napier.employeeservice.dto.EmployeeDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

public interface AutoEmployeeMapper {

    //InOrder to get implementation for methods of AutoUserMapper Interface we have mapper Utility Class.
    // For AutoUserMapper interface Mappers class provides implementation at compilation time.
    AutoEmployeeMapper MAPPER = Mappers.getMapper(AutoEmployeeMapper.class);

    //we define two mapping methods ==> Here MapStruct will create implementation for these two methods at compilation time.
    //In order to map one object into another object both the Object must have same field names.

    //When they have different field names then we have annotation called @Mapping(source="field_name",target="field_Name")
    //method to convert Employee JPA entity into employeeDto

    EmployeeDto mapToEmployeeDto(Employee employee);

    Employee mapToEmployee(EmployeeDto employeeDto);

}
