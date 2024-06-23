package com.kazimbayram.hr.service;

import com.kazimbayram.hr.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {

    EmployeeDto findByEmployeeId(Long employeeId);

    EmployeeDto create(EmployeeDto employeeDto);

    EmployeeDto createOrUpdate(Long employeeId, EmployeeDto employeeDto);

    EmployeeDto update(Long employeeId, EmployeeDto employeeDto);

    void delete(Long employeeId);

    EmployeeDto findByEmail(String email);

    List<EmployeeDto> findByJobId(String jobId);

    List<EmployeeDto> findByManagerId(Long managerId);

    List<EmployeeDto> findByDepartmentId(Long departmentId);

    List<EmployeeDto> batchCreate(List<EmployeeDto> employeeDtoList);

    List<EmployeeDto> batchCreateOrUpdate(List<EmployeeDto> employeeDtoList);

    List<EmployeeDto> batchUpdate(List<EmployeeDto> employeeDtoList);
}
