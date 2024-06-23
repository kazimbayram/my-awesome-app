package com.kazimbayram.hr.repository;

import com.kazimbayram.hr.entity.JobHistory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JobHistoryRepository extends JpaRepository<JobHistory, Long> {

    Optional<JobHistory> findByJobHistoryId(Long jobHistoryId);

    List<JobHistory> findByEmployeeEmployeeId(Long employeeId);

    List<JobHistory> findByJobJobId(String jobId);

    List<JobHistory> findByDepartmentDepartmentId(Long departmentId);
}
