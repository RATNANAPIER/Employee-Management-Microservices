package com.napier.employeeservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Schema(
        description = "Employee model information"
)
public class EmployeeDto {
    private Long id;
    @Schema(
            description = "EmployeeFirstName"
    )
    private String firstName;
    @Schema(
            description = "EmployeeLastName"
    )
    private String lastName;
    @Schema(
            description = "EmployeeEmail"
    )
    private String email;
    @Schema(
            description = "DepartmentCode"
    )
    private String departmentCode;
    @Schema(
            description = "OrganizationCode"
    )
    private  String organizationCode;

}
