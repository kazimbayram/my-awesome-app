package com.kazimbayram.hr.repository;

import com.kazimbayram.hr.entity.Job;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JobRepository extends JpaRepository<Job, String> {

    Optional<Job> findByJobId(String jobId);
}
