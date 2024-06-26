package com.kazimbayram.hr.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "EMPLOYEE_ID")
    private Long employeeId;

    @Column(name = "FIRST_NAME", nullable = false, length = 20)
    private String firstName;

    @Column(name = "LAST_NAME", nullable = false, length = 25)
    private String lastName;

    @Column(name = "EMAIL", nullable = false, length = 55, unique = true)
    private String email;

    @Column(name = "PHONE_NUMBER", length = 20)
    private String phoneNumber;

    @Temporal(TemporalType.DATE)
    @Column(name = "HIRE_DATE", nullable = false)
    private Date hireDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "JOB_ID")
    private Job job;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
    private List<JobHistory> jobHistory;

    @Column(name = "SALARY")
    private BigDecimal salary;

    @Column(name = "commission_pct")
    private BigDecimal commissionPercent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MANAGER_ID")
    private Employee manager;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DEPARTMENT_ID")
    private Department department;

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

    public Job getJob() {
        return this.job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public List<JobHistory> getJobHistory() {
        return this.jobHistory;
    }

    public void setJobHistory(List<JobHistory> jobHistory) {
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

    public Employee getManager() {
        return this.manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
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
        var other = (Employee) o;
        // field comparison
        return Objects.equals(employeeId, other.employeeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                employeeId,
                firstName,
                lastName,
                email,
                phoneNumber,
                hireDate,
                job,
                jobHistory,
                salary,
                commissionPercent,
                manager,
                department);
    }
}
