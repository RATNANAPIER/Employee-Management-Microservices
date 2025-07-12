package com.napier.departmentservice.service.impl;

import com.napier.departmentservice.dto.DepartmentDto;
import com.napier.departmentservice.entity.Department;
import com.napier.departmentservice.mapper.DepartmentMapper;
import com.napier.departmentservice.repository.DepartmentRepository;
import com.napier.departmentservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

//    We are injecting through constructor-injection we don't need to @Autowire because whenever spring finds
//    a spring bean with single parameterized constructor spring ioc it will automatically autowire
    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {


        //convert departmentDto to Department JPA entity because we have to store department jpa entity into database
        Department department = DepartmentMapper.mapToDepartment(departmentDto);
        //Saving department jpa entity into Database {department_db}
        Department savedDepartment = departmentRepository.save(department);

        //converting saved department into department dto and return the departmentDto
        return DepartmentMapper.mapToDepartmentDto(savedDepartment);
    }

    //retrieve department
    public DepartmentDto getDepartmentByCode(String departmentCode){
        Department department = departmentRepository.findByDepartmentCode(departmentCode);
        return DepartmentMapper.mapToDepartmentDto(department);
    }
}
