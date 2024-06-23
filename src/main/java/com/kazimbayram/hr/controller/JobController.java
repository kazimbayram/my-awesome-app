package com.kazimbayram.hr.controller;

import com.kazimbayram.hr.dto.JobDto;
import com.kazimbayram.hr.service.JobService;

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
@RequestMapping("/jobs")
public class JobController {

    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/{jobId}")
    public JobDto findByJobId(@PathVariable("jobId") String jobId) {
        return this.jobService.findByJobId(jobId);
    }

    @PostMapping("/")
    public JobDto create(@RequestBody JobDto jobDto) {
        return this.jobService.create(jobDto);
    }

    @PutMapping("/{jobId}")
    public JobDto createOrUpdate(@PathVariable("jobId") String jobId, @RequestBody JobDto jobDto) {
        return this.jobService.createOrUpdate(jobId, jobDto);
    }

    @PatchMapping("/{jobId}")
    public JobDto update(@PathVariable("jobId") String jobId, @RequestBody JobDto jobDto) {
        return this.jobService.update(jobId, jobDto);
    }

    @DeleteMapping("/{jobId}")
    public void delete(@PathVariable("jobId") String jobId) {
        this.jobService.delete(jobId);
    }

    @PostMapping("/batch")
    public List<JobDto> batchCreate(@RequestBody List<JobDto> jobDtoList) {
        return this.jobService.batchCreate(jobDtoList);
    }

    @PutMapping("/batch")
    public List<JobDto> batchCreateOrUpdate(@RequestBody List<JobDto> jobDtoList) {
        return this.jobService.batchCreateOrUpdate(jobDtoList);
    }

    @PatchMapping("/batch")
    public List<JobDto> batchUpdate(@RequestBody List<JobDto> jobDtoList) {
        return this.jobService.batchUpdate(jobDtoList);
    }
}
