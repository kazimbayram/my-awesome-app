package com.kazimbayram.hr.repository;

import com.kazimbayram.hr.entity.Location;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {

    Optional<Location> findByLocationId(Long locationId);

    List<Location> findByCountryCountryId(String countryId);
}
