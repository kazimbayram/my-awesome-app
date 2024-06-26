package com.kazimbayram.hr.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class EmployeeDto {

    private Long employeeId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private Date hireDate;
    private String jobJobId;
    private List<JobHistoryDto> jobHistory;
    private BigDecimal salary;
    private BigDecimal commissionPercent;
    private Long managerEmployeeId;
    private Long departmentDepartmentId;

    public Long getEmployeeId() {
        return this.employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getHireDate() {
        return this.hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public String getJobJobId() {
        return this.jobJobId;
    }

    public void setJobJobId(String jobJobId) {
        this.jobJobId = jobJobId;
    }

    public List<JobHistoryDto> getJobHistory() {
        return this.jobHistory;
    }

    public void setJobHistory(List<JobHistoryDto> jobHistory) {
        this.jobHistory = jobHistory;
    }

    public BigDecimal getSalary() {
        return this.salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public BigDecimal getCommissionPercent() {
        return this.commissionPercent;
    }

    public void setCommissionPercent(BigDecimal commissionPercent) {
        this.commissionPercent = commissionPercent;
    }

    public Long getManagerEmployeeId() {
        return this.managerEmployeeId;
    }

    public void setManagerEmployeeId(Long managerEmployeeId) {
        this.managerEmployeeId = managerEmployeeId;
    }

    public Long getDepartmentDepartmentId() {
        return this.departmentDepartmentId;
    }

    public void setDepartmentDepartmentId(Long departmentDepartmentId) {
        this.departmentDepartmentId = departmentDepartmentId;
    }
}
