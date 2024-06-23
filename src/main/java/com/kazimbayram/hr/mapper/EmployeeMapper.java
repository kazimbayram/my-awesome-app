package com.kazimbayram.hr.mapper;

import com.kazimbayram.hr.dto.EmployeeDto;
import com.kazimbayram.hr.entity.Employee;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    @Mapping(target = "job", ignore = true)
    @Mapping(target = "jobHistory", ignore = true)
    @Mapping(target = "manager", ignore = true)
    @Mapping(target = "department", ignore = true)
    Employee toEmployee(EmployeeDto dto);

    List<Employee> toEmployee(List<EmployeeDto> dtoList);

    @Mapping(target = "jobJobId", source = "job.jobId")
    @Mapping(target = "jobHistory", ignore = true)
    @Mapping(target = "managerEmployeeId", source = "manager.employeeId")
    @Mapping(target = "departmentDepartmentId", source = "department.departmentId")
    EmployeeDto toEmployeeDto(Employee entity);

    List<EmployeeDto> toEmployeeDto(List<Employee> entityList);

    @Mapping(target = "job", ignore = true)
    @Mapping(target = "jobHistory", ignore = true)
    @Mapping(target = "manager", ignore = true)
    @Mapping(target = "department", ignore = true)
    Employee updateEmployee(EmployeeDto dto, @MappingTarget Employee entity);
}
