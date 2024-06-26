package com.kazimbayram.hr.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "regions")
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "REGION_ID")
    private Long regionId;

    @Column(name = "REGION_NAME", nullable = false)
    private String regionName;

    public Long getRegionId() {
        return this.regionId;
    }

    public void setRegionId(Long regionId) {
        this.regionId = regionId;
    }

    public String getRegionName() {
        return this.regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        // null check
        if (o == null || getClass() != o.getClass()) return false;
        var other = (Region) o;
        // field comparison
        return Objects.equals(regionId, other.regionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(regionId, regionName);
    }
}
