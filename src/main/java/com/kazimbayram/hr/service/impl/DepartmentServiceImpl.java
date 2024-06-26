package com.kazimbayram.hr.service.impl;

import com.kazimbayram.hr.dto.DepartmentDto;
import com.kazimbayram.hr.mapper.DepartmentMapper;
import com.kazimbayram.hr.repository.DepartmentRepository;
import com.kazimbayram.hr.service.DepartmentService;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentMapper departmentMapper;
    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(
            DepartmentMapper departmentMapper, DepartmentRepository departmentRepository) {
        this.departmentMapper = departmentMapper;
        this.departmentRepository = departmentRepository;
    }

    public List<DepartmentDto> findAll() {
        var department = this.departmentRepository.findAll();
        return this.departmentMapper.toDepartmentDto(department);
    }

    public DepartmentDto findByDepartmentId(Long departmentId) {
        var department = this.departmentRepository.findByDepartmentId(departmentId).orElseThrow();
        return this.departmentMapper.toDepartmentDto(department);
    }

    public DepartmentDto create(DepartmentDto departmentDto) {
        var department = this.departmentMapper.toDepartment(departmentDto);

        department.setDepartmentId(null);

        department = this.departmentRepository.save(department);
        return this.departmentMapper.toDepartmentDto(department);
    }

    public DepartmentDto createOrUpdate(Long departmentId, DepartmentDto departmentDto) {
        var department = this.departmentMapper.toDepartment(departmentDto);

        department.setDepartmentId(departmentId);

        department = this.departmentRepository.save(department);

        return this.departmentMapper.toDepartmentDto(department);
    }

    public DepartmentDto update(Long departmentId, DepartmentDto departmentDto) {
        var exist = this.departmentRepository.existsById(departmentId);

        if (!exist) throw new EntityNotFoundException("Not Exists");

        var department = this.departmentMapper.toDepartment(departmentDto);

        department.setDepartmentId(departmentId);

        department = this.departmentRepository.save(department);

        return this.departmentMapper.toDepartmentDto(department);
    }

    public void delete(Long departmentId) {
        this.departmentRepository.deleteById(departmentId);
    }

    public List<DepartmentDto> findByLocationId(Long locationId) {
        var department = this.departmentRepository.findByLocationLocationId(locationId);

        return this.departmentMapper.toDepartmentDto(department);
    }

    public List<DepartmentDto> findByManagerId(Long managerId) {
        var department = this.departmentRepository.findByManagerEmployeeId(managerId);

        return this.departmentMapper.toDepartmentDto(department);
    }

    public List<DepartmentDto> batchCreate(List<DepartmentDto> departmentDtoList) {
        return departmentDtoList.stream().map(this::create).toList();
    }

    public List<DepartmentDto> batchCreateOrUpdate(List<DepartmentDto> departmentDtoList) {
        return departmentDtoList.stream()
                .map(dto -> this.createOrUpdate(dto.getDepartmentId(), dto))
                .toList();
    }

    public List<DepartmentDto> batchUpdate(List<DepartmentDto> departmentDtoList) {
        return departmentDtoList.stream()
                .map(dto -> this.update(dto.getDepartmentId(), dto))
                .toList();
    }
}
