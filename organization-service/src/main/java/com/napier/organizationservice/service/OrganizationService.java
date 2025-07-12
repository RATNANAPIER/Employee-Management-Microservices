package com.napier.organizationservice.service;

import com.napier.organizationservice.dto.OrganizationDto;

public interface OrganizationService {

     OrganizationDto save(OrganizationDto organizationDto);
     OrganizationDto getOrganizationById(String organizationCode);
}
