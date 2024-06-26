package com.kazimbayram.hr.dto;

public class CountryDto {

    private String countryId;
    private String countryName;
    private Long regionRegionId;

    public String getCountryId() {
        return this.countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public String getCountryName() {
        return this.countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public Long getRegionRegionId() {
        return this.regionRegionId;
    }

    public void setRegionRegionId(Long regionRegionId) {
        this.regionRegionId = regionRegionId;
    }
}
