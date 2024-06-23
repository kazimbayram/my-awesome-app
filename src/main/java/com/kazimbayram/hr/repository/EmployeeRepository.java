package com.kazimbayram.hr.repository;

import com.kazimbayram.hr.entity.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Optional<Employee> findByEmployeeId(Long employeeId);

    Optional<Employee> findByEmail(String email);

    List<Employee> findByJobJobId(String jobId);

    List<Employee> findByManagerEmployeeId(Long managerId);

    List<Employee> findByDepartmentDepartmentId(Long departmentId);
}
