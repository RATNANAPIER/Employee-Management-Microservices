package com.napier.organizationservice.controller;

import com.napier.organizationservice.dto.OrganizationDto;
import com.napier.organizationservice.service.OrganizationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(
        name = "Organization Service - OrganizationController",
        description = "OrganizationController Exposes REST APIs for Organization Service"
)
@RestController
@RequestMapping("api/organizations")
@AllArgsConstructor
public class OrganizationController {

    private OrganizationService organizationService;


    //Build save Organization REST API
    @Operation(
            summary = "Save Organization REST API",
            description = "Save Organization REST API is used to save organization object in the database"
    )
    //To describe the REST API response
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 CREATED"
    )
    @PostMapping
    public ResponseEntity<OrganizationDto> saveOrganization(@RequestBody OrganizationDto organizationDto){
        OrganizationDto savedOrganizationDto = organizationService.save(organizationDto);
        return new ResponseEntity<OrganizationDto>(savedOrganizationDto, HttpStatus.CREATED);
    }

    //Build getOrganizationById REST API

    @Operation(
            summary = "Get Organization REST API",
            description = "Get Organization REST API is used to get a single organization object from the database"
    )
    //To describe the REST API response
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    @GetMapping("{organization-code}")
    public ResponseEntity<OrganizationDto> getOrganizationById(@PathVariable("organization-code") String organizationCode){
        OrganizationDto organizationDto = organizationService.getOrganizationById(organizationCode);
        return ResponseEntity.ok(organizationDto);
    }
}
