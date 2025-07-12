package com.napier.organizationservice.respository;

import com.napier.organizationservice.dto.OrganizationDto;
import com.napier.organizationservice.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization,Long> {

    //Query method in spring data JPA it retrieve the Organization by organizationCode
    Organization findByOrganizationCode(String organizationCode);
}
