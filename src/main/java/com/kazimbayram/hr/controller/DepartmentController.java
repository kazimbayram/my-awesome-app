package com.kazimbayram.hr.controller;

import com.kazimbayram.hr.dto.DepartmentDto;
import com.kazimbayram.hr.service.DepartmentService;

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
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/{departmentId}")
    public DepartmentDto findByDepartmentId(@PathVariable("departmentId") Long departmentId) {
        return this.departmentService.findByDepartmentId(departmentId);
    }

    @PostMapping("/")
    public DepartmentDto create(@RequestBody DepartmentDto departmentDto) {
        return this.departmentService.create(departmentDto);
    }

    @PutMapping("/{departmentId}")
    public DepartmentDto createOrUpdate(
            @PathVariable("departmentId") Long departmentId,
            @RequestBody DepartmentDto departmentDto) {
        return this.departmentService.createOrUpdate(departmentId, departmentDto);
    }

    @PatchMapping("/{departmentId}")
    public DepartmentDto update(
            @PathVariable("departmentId") Long departmentId,
            @RequestBody DepartmentDto departmentDto) {
        return this.departmentService.update(departmentId, departmentDto);
    }

    @DeleteMapping("/{departmentId}")
    public void delete(@PathVariable("departmentId") Long departmentId) {
        this.departmentService.delete(departmentId);
    }

    @GetMapping("/by-location/{locationId}")
    public List<DepartmentDto> findByLocationId(@PathVariable("locationId") Long locationId) {
        return this.departmentService.findByLocationId(locationId);
    }

    @GetMapping("/by-manager/{managerId}")
    public List<DepartmentDto> findByManagerId(@PathVariable("managerId") Long managerId) {
        return this.departmentService.findByManagerId(managerId);
    }

    @PostMapping("/batch")
    public List<DepartmentDto> batchCreate(@RequestBody List<DepartmentDto> departmentDtoList) {
        return this.departmentService.batchCreate(departmentDtoList);
    }

    @PutMapping("/batch")
    public List<DepartmentDto> batchCreateOrUpdate(
            @RequestBody List<DepartmentDto> departmentDtoList) {
        return this.departmentService.batchCreateOrUpdate(departmentDtoList);
    }

    @PatchMapping("/batch")
    public List<DepartmentDto> batchUpdate(@RequestBody List<DepartmentDto> departmentDtoList) {
        return this.departmentService.batchUpdate(departmentDtoList);
    }
}
