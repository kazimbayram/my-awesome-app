package com.kazimbayram.hr.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "job_history")
public class JobHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "JOB_HISTORY_ID")
    private Long jobHistoryId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EMPLOYEE_ID")
    private Employee employee;

    @Temporal(TemporalType.DATE)
    @Column(name = "START_DATE", nullable = false)
    private Date startDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "END_DATE", nullable = false)
    private Date endDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "JOB_ID")
    private Job job;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DEPARTMENT_ID")
    private Department department;

    public Long getJobHistoryId() {
        return this.jobHistoryId;
    }

    public void setJobHistoryId(Long jobHistoryId) {
        this.jobHistoryId = jobHistoryId;
    }

    public Employee getEmployee() {
        return this.employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Date getStartDate() {
        return this.startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return this.endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Job getJob() {
        return this.job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public Department getDepartment() {
        return this.department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        // null check
        if (o == null || getClass() != o.getClass()) return false;
        var other = (JobHistory) o;
        // field comparison
        return Objects.equals(jobHistoryId, other.jobHistoryId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(jobHistoryId, employee, startDate, endDate, job, department);
    }
}
