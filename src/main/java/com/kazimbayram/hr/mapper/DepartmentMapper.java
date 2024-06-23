package com.kazimbayram.hr.mapper;

import com.kazimbayram.hr.dto.DepartmentDto;
import com.kazimbayram.hr.entity.Department;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {

    @Mapping(target = "location", ignore = true)
    @Mapping(target = "manager", ignore = true)
    Department toDepartment(DepartmentDto dto);

    List<Department> toDepartment(List<DepartmentDto> dtoList);

    @Mapping(target = "locationLocationId", source = "location.locationId")
    @Mapping(target = "managerEmployeeId", source = "manager.employeeId")
    DepartmentDto toDepartmentDto(Department entity);

    List<DepartmentDto> toDepartmentDto(List<Department> entityList);

    @Mapping(target = "location", ignore = true)
    @Mapping(target = "manager", ignore = true)
    Department updateDepartment(DepartmentDto dto, @MappingTarget Department entity);
}
