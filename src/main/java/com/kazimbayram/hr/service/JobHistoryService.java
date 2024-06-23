package com.kazimbayram.hr.service;

import com.kazimbayram.hr.dto.JobHistoryDto;

import java.util.List;

public interface JobHistoryService {

    JobHistoryDto findByJobHistoryId(Long jobHistoryId);

    JobHistoryDto create(JobHistoryDto jobHistoryDto);

    JobHistoryDto createOrUpdate(Long jobHistoryId, JobHistoryDto jobHistoryDto);

    JobHistoryDto update(Long jobHistoryId, JobHistoryDto jobHistoryDto);

    void delete(Long jobHistoryId);

    List<JobHistoryDto> findByEmployeeId(Long employeeId);

    List<JobHistoryDto> findByJobId(String jobId);

    List<JobHistoryDto> findByDepartmentId(Long departmentId);

    List<JobHistoryDto> batchCreate(List<JobHistoryDto> jobHistoryDtoList);

    List<JobHistoryDto> batchCreateOrUpdate(List<JobHistoryDto> jobHistoryDtoList);

    List<JobHistoryDto> batchUpdate(List<JobHistoryDto> jobHistoryDtoList);
}
