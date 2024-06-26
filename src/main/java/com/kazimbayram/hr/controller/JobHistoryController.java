package com.kazimbayram.hr.controller;

import com.kazimbayram.hr.dto.JobHistoryDto;
import com.kazimbayram.hr.service.JobHistoryService;

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
@RequestMapping("/job-histories")
public class JobHistoryController {

    private final JobHistoryService jobHistoryService;

    public JobHistoryController(JobHistoryService jobHistoryService) {
        this.jobHistoryService = jobHistoryService;
    }

    @GetMapping("/{jobHistoryId}")
    public JobHistoryDto findByJobHistoryId(@PathVariable("jobHistoryId") Long jobHistoryId) {
        return this.jobHistoryService.findByJobHistoryId(jobHistoryId);
    }

    @PostMapping("/")
    public JobHistoryDto create(@RequestBody JobHistoryDto jobHistoryDto) {
        return this.jobHistoryService.create(jobHistoryDto);
    }

    @PutMapping("/{jobHistoryId}")
    public JobHistoryDto createOrUpdate(
            @PathVariable("jobHistoryId") Long jobHistoryId,
            @RequestBody JobHistoryDto jobHistoryDto) {
        return this.jobHistoryService.createOrUpdate(jobHistoryId, jobHistoryDto);
    }

    @PatchMapping("/{jobHistoryId}")
    public JobHistoryDto update(
            @PathVariable("jobHistoryId") Long jobHistoryId,
            @RequestBody JobHistoryDto jobHistoryDto) {
        return this.jobHistoryService.update(jobHistoryId, jobHistoryDto);
    }

    @DeleteMapping("/{jobHistoryId}")
    public void delete(@PathVariable("jobHistoryId") Long jobHistoryId) {
        this.jobHistoryService.delete(jobHistoryId);
    }

    @GetMapping("/by-employee/{employeeId}")
    public List<JobHistoryDto> findByEmployeeId(@PathVariable("employeeId") Long employeeId) {
        return this.jobHistoryService.findByEmployeeId(employeeId);
    }

    @GetMapping("/by-job/{jobId}")
    public List<JobHistoryDto> findByJobId(@PathVariable("jobId") String jobId) {
        return this.jobHistoryService.findByJobId(jobId);
    }

    @GetMapping("/by-department/{departmentId}")
    public List<JobHistoryDto> findByDepartmentId(@PathVariable("departmentId") Long departmentId) {
        return this.jobHistoryService.findByDepartmentId(departmentId);
    }

    @GetMapping("/")
    public List<JobHistoryDto> findAll() {
        return this.jobHistoryService.findAll();
    }

    @PostMapping("/batch")
    public List<JobHistoryDto> batchCreate(@RequestBody List<JobHistoryDto> jobHistoryDtoList) {
        return this.jobHistoryService.batchCreate(jobHistoryDtoList);
    }

    @PutMapping("/batch")
    public List<JobHistoryDto> batchCreateOrUpdate(
            @RequestBody List<JobHistoryDto> jobHistoryDtoList) {
        return this.jobHistoryService.batchCreateOrUpdate(jobHistoryDtoList);
    }

    @PatchMapping("/batch")
    public List<JobHistoryDto> batchUpdate(@RequestBody List<JobHistoryDto> jobHistoryDtoList) {
        return this.jobHistoryService.batchUpdate(jobHistoryDtoList);
    }
}
