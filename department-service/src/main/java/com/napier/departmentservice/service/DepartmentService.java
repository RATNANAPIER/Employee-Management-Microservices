package com.napier.departmentservice.service;

import com.napier.departmentservice.dto.DepartmentDto;

public interface DepartmentService {


     DepartmentDto saveDepartment(DepartmentDto departmentDto);

     DepartmentDto getDepartmentByCode(String departmentCode);

}
