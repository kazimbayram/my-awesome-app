package com.kazimbayram.hr.dto;

import java.util.Date;

public class JobHistoryDto {

    private Long jobHistoryId;
    private Long employeeEmployeeId;
    private Date startDate;
    private Date endDate;
    private String jobJobId;
    private Long departmentDepartmentId;

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
}
