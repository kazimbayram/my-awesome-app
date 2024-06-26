package com.kazimbayram.hr.service;

import com.kazimbayram.hr.dto.LocationDto;

import java.util.List;

public interface LocationService {

    LocationDto findByLocationId(Long locationId);

    LocationDto create(LocationDto locationDto);

    LocationDto createOrUpdate(Long locationId, LocationDto locationDto);

    LocationDto update(Long locationId, LocationDto locationDto);

    void delete(Long locationId);

    List<LocationDto> findByCountryId(String countryId);

    List<LocationDto> findAll();

    List<LocationDto> batchCreate(List<LocationDto> locationDtoList);

    List<LocationDto> batchCreateOrUpdate(List<LocationDto> locationDtoList);

    List<LocationDto> batchUpdate(List<LocationDto> locationDtoList);
}
