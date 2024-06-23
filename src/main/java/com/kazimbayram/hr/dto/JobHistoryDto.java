package com.kazimbayram.hr.dto;

import java.util.Date;
import java.util.UUID;

public class JobHistoryDto {

    private Long jobHistoryId;
    private Long employeeEmployeeId;
    private Date startDate;
    private Date endDate;
    private String jobJobId;
    private Long departmentDepartmentId;
    private UUID tenantId;
    private Date createdAt;
    private String createdBy;
    private Date updatedAt;
    private String updatedBy;
    private Integer revision;

    public Long getJobHistoryId() {
        return this.jobHistoryId;
    }

    public void setJobHistoryId(Long jobHistoryId) {
        this.jobHistoryId = jobHistoryId;
    }

    public Long getEmployeeEmployeeId() {
        return this.employeeEmployeeId;
    }

    public void setEmployeeEmployeeId(Long employeeEmployeeId) {
        this.employeeEmployeeId = employeeEmployeeId;
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

    public String getJobJobId() {
        return this.jobJobId;
    }

    public void setJobJobId(String jobJobId) {
        this.jobJobId = jobJobId;
    }

    public Long getDepartmentDepartmentId() {
        return this.departmentDepartmentId;
    }

    public void setDepartmentDepartmentId(Long departmentDepartmentId) {
        this.departmentDepartmentId = departmentDepartmentId;
    }

    public UUID getTenantId() {
        return this.tenantId;
    }

    public void setTenantId(UUID tenantId) {
        this.tenantId = tenantId;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUpdatedBy() {
        return this.updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Integer getRevision() {
        return this.revision;
    }

    public void setRevision(Integer revision) {
        this.revision = revision;
    }
}
