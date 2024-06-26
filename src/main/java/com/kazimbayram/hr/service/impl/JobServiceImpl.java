package com.kazimbayram.hr.service.impl;

import com.kazimbayram.hr.dto.JobDto;
import com.kazimbayram.hr.mapper.JobMapper;
import com.kazimbayram.hr.repository.JobRepository;
import com.kazimbayram.hr.service.JobService;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobServiceImpl implements JobService {

    private final JobMapper jobMapper;
    private final JobRepository jobRepository;

    public JobServiceImpl(JobMapper jobMapper, JobRepository jobRepository) {
        this.jobMapper = jobMapper;
        this.jobRepository = jobRepository;
    }

    public List<JobDto> findAll() {
        var job = this.jobRepository.findAll();
        return this.jobMapper.toJobDto(job);
    }

    public JobDto findByJobId(String jobId) {
        var job = this.jobRepository.findByJobId(jobId).orElseThrow();
        return this.jobMapper.toJobDto(job);
    }

    public JobDto create(JobDto jobDto) {
        var job = this.jobMapper.toJob(jobDto);

        job.setJobId(null);

        job = this.jobRepository.save(job);
        return this.jobMapper.toJobDto(job);
    }

    public JobDto createOrUpdate(String jobId, JobDto jobDto) {
        var job = this.jobMapper.toJob(jobDto);

        job.setJobId(jobId);

        job = this.jobRepository.save(job);

        return this.jobMapper.toJobDto(job);
    }

    public JobDto update(String jobId, JobDto jobDto) {
        var exist = this.jobRepository.existsById(jobId);

        if (!exist) throw new EntityNotFoundException("Not Exists");

        var job = this.jobMapper.toJob(jobDto);

        job.setJobId(jobId);

        job = this.jobRepository.save(job);

        return this.jobMapper.toJobDto(job);
    }

    public void delete(String jobId) {
        this.jobRepository.deleteById(jobId);
    }

    public List<JobDto> batchCreate(List<JobDto> jobDtoList) {
        return jobDtoList.stream().map(this::create).toList();
    }

    public List<JobDto> batchCreateOrUpdate(List<JobDto> jobDtoList) {
        return jobDtoList.stream().map(dto -> this.createOrUpdate(dto.getJobId(), dto)).toList();
    }

    public List<JobDto> batchUpdate(List<JobDto> jobDtoList) {
        return jobDtoList.stream().map(dto -> this.update(dto.getJobId(), dto)).toList();
    }
}
