package com.kazimbayram.hr.service.impl;

import com.kazimbayram.hr.dto.EmployeeDto;
import com.kazimbayram.hr.dto.JobHistoryDto;
import com.kazimbayram.hr.mapper.EmployeeMapper;
import com.kazimbayram.hr.repository.EmployeeRepository;
import com.kazimbayram.hr.service.EmployeeService;
import com.kazimbayram.hr.service.JobHistoryService;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeMapper employeeMapper;
    private final EmployeeRepository employeeRepository;
    private final JobHistoryService jobHistoryService;

    public EmployeeServiceImpl(
            EmployeeMapper employeeMapper,
            EmployeeRepository employeeRepository,
            JobHistoryService jobHistoryService) {
        this.employeeMapper = employeeMapper;
        this.employeeRepository = employeeRepository;
        this.jobHistoryService = jobHistoryService;
    }

    public EmployeeDto findByEmployeeId(Long employeeId) {
        var entity = this.employeeRepository.findByEmployeeId(employeeId).orElseThrow();
        return this.employeeMapper.toEmployeeDto(entity);
    }

    public EmployeeDto create(EmployeeDto employeeDto) {
        var entity = this.employeeMapper.toEmployee(employeeDto);
        entity.setEmployeeId(null);
        entity = this.employeeRepository.save(entity);
        final var result = this.employeeMapper.toEmployeeDto(entity);
        result.setJobHistory(
                Optional.of(employeeDto.getJobHistory())
                        .map(
                                v ->
                                        v.stream()
                                                .map(
                                                        e -> {
                                                            e.setEmployeeEmployeeId(
                                                                    result.getEmployeeId());
                                                            return this.jobHistoryService.create(e);
                                                        })
                                                .toList())
                        .orElse(List.of()));
        return result;
    }

    public EmployeeDto createOrUpdate(Long employeeId, EmployeeDto employeeDto) {
        var entity = this.employeeMapper.toEmployee(employeeDto);

        entity.setEmployeeId(employeeId);

        entity = this.employeeRepository.save(entity);

        final var result = this.employeeMapper.toEmployeeDto(entity);
        result.setJobHistory(
                Optional.of(employeeDto.getJobHistory())
                        .map(
                                v ->
                                        v.stream()
                                                .map(
                                                        e ->
                                                                this.validateAndUpsertJobHistoryDto(
                                                                        result.getEmployeeId(), e))
                                                .toList())
                        .orElse(List.of()));
        return result;
    }

    public EmployeeDto update(Long employeeId, EmployeeDto employeeDto) {
        var exist = this.employeeRepository.existsById(employeeId);
        if (!exist) throw new EntityNotFoundException("Not Exists");
        var entity = this.employeeMapper.toEmployee(employeeDto);

        entity.setEmployeeId(employeeId);

        entity = this.employeeRepository.save(entity);

        final var result = this.employeeMapper.toEmployeeDto(entity);
        result.setJobHistory(
                Optional.of(employeeDto.getJobHistory())
                        .map(
                                v ->
                                        v.stream()
                                                .map(
                                                        e ->
                                                                this.validateAndUpsertJobHistoryDto(
                                                                        result.getEmployeeId(), e))
                                                .toList())
                        .orElse(List.of()));
        return result;
    }

    public void delete(Long employeeId) {
        this.employeeRepository.deleteById(employeeId);
    }

    public EmployeeDto findByEmail(String email) {
        var entity = this.employeeRepository.findByEmail(email).orElseThrow();
        return this.employeeMapper.toEmployeeDto(entity);
    }

    public List<EmployeeDto> findByJobId(String jobId) {
        var entity = this.employeeRepository.findByJobJobId(jobId);
        return this.employeeMapper.toEmployeeDto(entity);
    }

    public List<EmployeeDto> findByManagerId(Long managerId) {
        var entity = this.employeeRepository.findByManagerEmployeeId(managerId);
        return this.employeeMapper.toEmployeeDto(entity);
    }

    public List<EmployeeDto> findByDepartmentId(Long departmentId) {
        var entity = this.employeeRepository.findByDepartmentDepartmentId(departmentId);
        return this.employeeMapper.toEmployeeDto(entity);
    }

    public List<EmployeeDto> batchCreate(List<EmployeeDto> employeeDtoList) {
        return employeeDtoList.stream().map(this::create).toList();
    }

    public List<EmployeeDto> batchCreateOrUpdate(List<EmployeeDto> employeeDtoList) {
        return employeeDtoList.stream()
                .map(dto -> this.createOrUpdate(dto.getEmployeeId(), dto))
                .toList();
    }

    public List<EmployeeDto> batchUpdate(List<EmployeeDto> employeeDtoList) {
        return employeeDtoList.stream().map(dto -> this.update(dto.getEmployeeId(), dto)).toList();
    }

    private JobHistoryDto validateAndUpsertJobHistoryDto(
            Object employeeId, JobHistoryDto jobHistoryDto) {

        if (jobHistoryDto.getJobHistoryId() != null) {
            var existing =
                    this.jobHistoryService.findByJobHistoryId(jobHistoryDto.getJobHistoryId());

            if (existing != null) {
                var employeeIdMatches = existing.getEmployeeEmployeeId().equals(employeeId);

                if (!employeeIdMatches) {
                    throw new IllegalCallerException("Access violation error");
                }
            }

            jobHistoryDto.setEmployeeEmployeeId(jobHistoryDto.getJobHistoryId());
            return this.jobHistoryService.update(jobHistoryDto.getJobHistoryId(), jobHistoryDto);
        } else {
            jobHistoryDto.setEmployeeEmployeeId(jobHistoryDto.getJobHistoryId());
            return this.jobHistoryService.create(jobHistoryDto);
        }
    }
}
