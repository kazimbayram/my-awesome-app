package com.kazimbayram.hr.repository;

import com.kazimbayram.hr.entity.Department;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    Optional<Department> findByDepartmentId(Long departmentId);

    List<Department> findByLocationLocationId(Long locationId);

    List<Department> findByManagerEmployeeId(Long managerId);
}
