package com.kazimbayram.hr.service;

import com.kazimbayram.hr.dto.DepartmentDto;

import java.util.List;

public interface DepartmentService {

    DepartmentDto findByDepartmentId(Long departmentId);

    DepartmentDto create(DepartmentDto departmentDto);

    DepartmentDto createOrUpdate(Long departmentId, DepartmentDto departmentDto);

    DepartmentDto update(Long departmentId, DepartmentDto departmentDto);

    void delete(Long departmentId);

    List<DepartmentDto> findByLocationId(Long locationId);

    List<DepartmentDto> findByManagerId(Long managerId);

    List<DepartmentDto> findAll();

    List<DepartmentDto> batchCreate(List<DepartmentDto> departmentDtoList);

    List<DepartmentDto> batchCreateOrUpdate(List<DepartmentDto> departmentDtoList);

    List<DepartmentDto> batchUpdate(List<DepartmentDto> departmentDtoList);
}
