package com.kazimbayram.hr.dto;

public class LocationDto {

    private Long locationId;
    private String streetAddress;
    private String postalCode;
    private String city;
    private String stateProvince;
    private String countryCountryId;

    public Long getLocationId() {
        return this.locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    public String getStreetAddress() {
        return this.streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getPostalCode() {
        return this.postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStateProvince() {
        return this.stateProvince;
    }

    public void setStateProvince(String stateProvince) {
        this.stateProvince = stateProvince;
    }

    public String getCountryCountryId() {
        return this.countryCountryId;
    }

    public void setCountryCountryId(String countryCountryId) {
        this.countryCountryId = countryCountryId;
    }
}
