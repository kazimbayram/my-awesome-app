package com.kazimbayram.hr.mapper;

import com.kazimbayram.hr.dto.JobDto;
import com.kazimbayram.hr.entity.Job;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface JobMapper {

    Job toJob(JobDto dto);

    List<Job> toJob(List<JobDto> dtoList);

    JobDto toJobDto(Job entity);

    List<JobDto> toJobDto(List<Job> entityList);

    Job updateJob(JobDto dto, @MappingTarget Job entity);
}
