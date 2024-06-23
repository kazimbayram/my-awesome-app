package com.kazimbayram.hr.service.impl;

import com.kazimbayram.hr.dto.JobHistoryDto;
import com.kazimbayram.hr.mapper.JobHistoryMapper;
import com.kazimbayram.hr.repository.JobHistoryRepository;
import com.kazimbayram.hr.service.JobHistoryService;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobHistoryServiceImpl implements JobHistoryService {

    private final JobHistoryMapper jobHistoryMapper;
    private final JobHistoryRepository jobHistoryRepository;

    public JobHistoryServiceImpl(
            JobHistoryMapper jobHistoryMapper, JobHistoryRepository jobHistoryRepository) {
        this.jobHistoryMapper = jobHistoryMapper;
        this.jobHistoryRepository = jobHistoryRepository;
    }

    public JobHistoryDto findByJobHistoryId(Long jobHistoryId) {
        var entity = this.jobHistoryRepository.findByJobHistoryId(jobHistoryId).orElseThrow();
        return this.jobHistoryMapper.toJobHistoryDto(entity);
    }

    public JobHistoryDto create(JobHistoryDto jobHistoryDto) {
        var entity = this.jobHistoryMapper.toJobHistory(jobHistoryDto);
        entity.setJobHistoryId(null);
        entity = this.jobHistoryRepository.save(entity);
        return this.jobHistoryMapper.toJobHistoryDto(entity);
    }

    public JobHistoryDto createOrUpdate(Long jobHistoryId, JobHistoryDto jobHistoryDto) {
        var entity = this.jobHistoryMapper.toJobHistory(jobHistoryDto);

        entity.setJobHistoryId(jobHistoryId);

        entity = this.jobHistoryRepository.save(entity);

        return this.jobHistoryMapper.toJobHistoryDto(entity);
    }

    public JobHistoryDto update(Long jobHistoryId, JobHistoryDto jobHistoryDto) {
        var exist = this.jobHistoryRepository.existsById(jobHistoryId);
        if (!exist) throw new EntityNotFoundException("Not Exists");
        var entity = this.jobHistoryMapper.toJobHistory(jobHistoryDto);

        entity.setJobHistoryId(jobHistoryId);

        entity = this.jobHistoryRepository.save(entity);

        return this.jobHistoryMapper.toJobHistoryDto(entity);
    }

    public void delete(Long jobHistoryId) {
        this.jobHistoryRepository.deleteById(jobHistoryId);
    }

    public List<JobHistoryDto> findByEmployeeId(Long employeeId) {
        var entity = this.jobHistoryRepository.findByEmployeeEmployeeId(employeeId);
        return this.jobHistoryMapper.toJobHistoryDto(entity);
    }

    public List<JobHistoryDto> findByJobId(String jobId) {
        var entity = this.jobHistoryRepository.findByJobJobId(jobId);
        return this.jobHistoryMapper.toJobHistoryDto(entity);
    }

    public List<JobHistoryDto> findByDepartmentId(Long departmentId) {
        var entity = this.jobHistoryRepository.findByDepartmentDepartmentId(departmentId);
        return this.jobHistoryMapper.toJobHistoryDto(entity);
    }

    public List<JobHistoryDto> batchCreate(List<JobHistoryDto> jobHistoryDtoList) {
        return jobHistoryDtoList.stream().map(this::create).toList();
    }

    public List<JobHistoryDto> batchCreateOrUpdate(List<JobHistoryDto> jobHistoryDtoList) {
        return jobHistoryDtoList.stream()
                .map(dto -> this.createOrUpdate(dto.getJobHistoryId(), dto))
                .toList();
    }

    public List<JobHistoryDto> batchUpdate(List<JobHistoryDto> jobHistoryDtoList) {
        return jobHistoryDtoList.stream()
                .map(dto -> this.update(dto.getJobHistoryId(), dto))
                .toList();
    }
}
