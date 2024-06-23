package com.kazimbayram.hr.service;

import com.kazimbayram.hr.dto.JobDto;

import java.util.List;

public interface JobService {

    JobDto findByJobId(String jobId);

    JobDto create(JobDto jobDto);

    JobDto createOrUpdate(String jobId, JobDto jobDto);

    JobDto update(String jobId, JobDto jobDto);

    void delete(String jobId);

    List<JobDto> batchCreate(List<JobDto> jobDtoList);

    List<JobDto> batchCreateOrUpdate(List<JobDto> jobDtoList);

    List<JobDto> batchUpdate(List<JobDto> jobDtoList);
}
