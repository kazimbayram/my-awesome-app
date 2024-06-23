package com.kazimbayram.hr.controller;

import com.kazimbayram.hr.dto.EmployeeDto;
import com.kazimbayram.hr.service.EmployeeService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/{employeeId}")
    public EmployeeDto findByEmployeeId(@PathVariable("employeeId") Long employeeId) {
        return this.employeeService.findByEmployeeId(employeeId);
    }

    @PostMapping("/")
    public EmployeeDto create(@RequestBody EmployeeDto employeeDto) {
        return this.employeeService.create(employeeDto);
    }

    @PutMapping("/{employeeId}")
    public EmployeeDto createOrUpdate(
            @PathVariable("employeeId") Long employeeId, @RequestBody EmployeeDto employeeDto) {
        return this.employeeService.createOrUpdate(employeeId, employeeDto);
    }

    @PatchMapping("/{employeeId}")
    public EmployeeDto update(
            @PathVariable("employeeId") Long employeeId, @RequestBody EmployeeDto employeeDto) {
        return this.employeeService.update(employeeId, employeeDto);
    }

    @DeleteMapping("/{employeeId}")
    public void delete(@PathVariable("employeeId") Long employeeId) {
        this.employeeService.delete(employeeId);
    }

    @GetMapping("/find-by-email/{email}")
    public EmployeeDto findByEmail(@PathVariable("email") String email) {
        return this.employeeService.findByEmail(email);
    }

    @GetMapping("/by-job/{jobId}")
    public List<EmployeeDto> findByJobId(@PathVariable("jobId") String jobId) {
        return this.employeeService.findByJobId(jobId);
    }

    @GetMapping("/by-manager/{managerId}")
    public List<EmployeeDto> findByManagerId(@PathVariable("managerId") Long managerId) {
        return this.employeeService.findByManagerId(managerId);
    }

    @GetMapping("/by-department/{departmentId}")
    public List<EmployeeDto> findByDepartmentId(@PathVariable("departmentId") Long departmentId) {
        return this.employeeService.findByDepartmentId(departmentId);
    }

    @PostMapping("/batch")
    public List<EmployeeDto> batchCreate(@RequestBody List<EmployeeDto> employeeDtoList) {
        return this.employeeService.batchCreate(employeeDtoList);
    }

    @PutMapping("/batch")
    public List<EmployeeDto> batchCreateOrUpdate(@RequestBody List<EmployeeDto> employeeDtoList) {
        return this.employeeService.batchCreateOrUpdate(employeeDtoList);
    }

    @PatchMapping("/batch")
    public List<EmployeeDto> batchUpdate(@RequestBody List<EmployeeDto> employeeDtoList) {
        return this.employeeService.batchUpdate(employeeDtoList);
    }
}
