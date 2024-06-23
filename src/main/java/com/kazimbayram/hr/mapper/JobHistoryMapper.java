package com.kazimbayram.hr.mapper;

import com.kazimbayram.hr.dto.JobHistoryDto;
import com.kazimbayram.hr.entity.JobHistory;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface JobHistoryMapper {

    @Mapping(target = "employee", ignore = true)
    @Mapping(target = "job", ignore = true)
    @Mapping(target = "department", ignore = true)
    JobHistory toJobHistory(JobHistoryDto dto);

    List<JobHistory> toJobHistory(List<JobHistoryDto> dtoList);

    @Mapping(target = "employeeEmployeeId", source = "employee.employeeId")
    @Mapping(target = "jobJobId", source = "job.jobId")
    @Mapping(target = "departmentDepartmentId", source = "department.departmentId")
    JobHistoryDto toJobHistoryDto(JobHistory entity);

    List<JobHistoryDto> toJobHistoryDto(List<JobHistory> entityList);

    @Mapping(target = "employee", ignore = true)
    @Mapping(target = "job", ignore = true)
    @Mapping(target = "department", ignore = true)
    JobHistory updateJobHistory(JobHistoryDto dto, @MappingTarget JobHistory entity);
}
