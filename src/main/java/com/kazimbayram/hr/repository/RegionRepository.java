package com.kazimbayram.hr.repository;

import com.kazimbayram.hr.entity.Region;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RegionRepository extends JpaRepository<Region, Long> {

    Optional<Region> findByRegionId(Long regionId);
}
