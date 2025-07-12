package com.napier.departmentservice.controller;


import com.napier.departmentservice.dto.DepartmentDto;
import com.napier.departmentservice.service.DepartmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(
        name = "Department Service - DepartmentController",
        description = "Department Controller Exposes REST APIs for Department Service"
)
@RestController //it acts as spring mvc
@RequestMapping("api/departments") //to define base url it applicable to all the REST API within the controller
@AllArgsConstructor
public class DepartmentController {

    //using constructor-based injection {@AllArgsConstructor} and not writing @Autowire due to single parameterized constructor
    private DepartmentService departmentService;

    //Build save department REST API
    @Operation(
            summary = "Save Department REST API",
            description = "Save Department REST API is used to save department object in a database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 CREATED"
    )
    @PostMapping
    public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto){
        DepartmentDto savedDepartmentDto = departmentService.saveDepartment(departmentDto);
        return new ResponseEntity<>(savedDepartmentDto, HttpStatus.CREATED);
    }

    //build getDepartment REST API
    @Operation(
            summary = "Get Department REST API",
            description = "Get Department REST API is used to get department object from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    @GetMapping("{department-code}")
    public ResponseEntity<DepartmentDto> getDepartment(@PathVariable("department-code") String departmentCode){
        DepartmentDto departmentDto = departmentService.getDepartmentByCode(departmentCode);
        return new ResponseEntity<>(departmentDto,HttpStatus.OK);
    }
}
