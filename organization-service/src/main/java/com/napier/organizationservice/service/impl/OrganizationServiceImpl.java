package com.napier.organizationservice.service.impl;

import com.napier.organizationservice.dto.OrganizationDto;
import com.napier.organizationservice.entity.Organization;
import com.napier.organizationservice.mapper.OrganizationMapper;
import com.napier.organizationservice.respository.OrganizationRepository;
import com.napier.organizationservice.service.OrganizationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class OrganizationServiceImpl implements OrganizationService {

    private OrganizationRepository organizationRepository;
    @Override
    public OrganizationDto save(OrganizationDto organizationDto) {
        Organization organization = OrganizationMapper.mapToOrganization(organizationDto);

        Organization savedOrganization = organizationRepository.save(organization);

        return OrganizationMapper.mapToOrganizationDto(savedOrganization);
    }

    @Override
    public OrganizationDto getOrganizationById(String organizationCode) {
        Organization organization = organizationRepository.findByOrganizationCode(organizationCode);
        return OrganizationMapper.mapToOrganizationDto(organization);
    }
}
