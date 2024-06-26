package com.kazimbayram.hr.dto;

public class DepartmentDto {

    private Long departmentId;
    private String departmentName;
    private Long locationLocationId;
    private Long managerEmployeeId;

    public Long getDepartmentId() {
        return this.departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return this.departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Long getLocationLocationId() {
        return this.locationLocationId;
    }

    public void setLocationLocationId(Long locationLocationId) {
        this.locationLocationId = locationLocationId;
    }

    public Long getManagerEmployeeId() {
        return this.managerEmployeeId;
    }

    public void setManagerEmployeeId(Long managerEmployeeId) {
        this.managerEmployeeId = managerEmployeeId;
    }
}
