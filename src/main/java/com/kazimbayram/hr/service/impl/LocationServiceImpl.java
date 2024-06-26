package com.kazimbayram.hr.service.impl;

import com.kazimbayram.hr.dto.LocationDto;
import com.kazimbayram.hr.mapper.LocationMapper;
import com.kazimbayram.hr.repository.LocationRepository;
import com.kazimbayram.hr.service.LocationService;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {

    private final LocationMapper locationMapper;
    private final LocationRepository locationRepository;

    public LocationServiceImpl(
            LocationMapper locationMapper, LocationRepository locationRepository) {
        this.locationMapper = locationMapper;
        this.locationRepository = locationRepository;
    }

    public List<LocationDto> findAll() {
        var location = this.locationRepository.findAll();
        return this.locationMapper.toLocationDto(location);
    }

    public LocationDto findByLocationId(Long locationId) {
        var location = this.locationRepository.findByLocationId(locationId).orElseThrow();
        return this.locationMapper.toLocationDto(location);
    }

    public LocationDto create(LocationDto locationDto) {
        var location = this.locationMapper.toLocation(locationDto);

        location.setLocationId(null);

        location = this.locationRepository.save(location);
        return this.locationMapper.toLocationDto(location);
    }

    public LocationDto createOrUpdate(Long locationId, LocationDto locationDto) {
        var location = this.locationMapper.toLocation(locationDto);

        location.setLocationId(locationId);

        location = this.locationRepository.save(location);

        return this.locationMapper.toLocationDto(location);
    }

    public LocationDto update(Long locationId, LocationDto locationDto) {
        var exist = this.locationRepository.existsById(locationId);

        if (!exist) throw new EntityNotFoundException("Not Exists");

        var location = this.locationMapper.toLocation(locationDto);

        location.setLocationId(locationId);

        location = this.locationRepository.save(location);

        return this.locationMapper.toLocationDto(location);
    }

    public void delete(Long locationId) {
        this.locationRepository.deleteById(locationId);
    }

    public List<LocationDto> findByCountryId(String countryId) {
        var location = this.locationRepository.findByCountryCountryId(countryId);

        return this.locationMapper.toLocationDto(location);
    }

    public List<LocationDto> batchCreate(List<LocationDto> locationDtoList) {
        return locationDtoList.stream().map(this::create).toList();
    }

    public List<LocationDto> batchCreateOrUpdate(List<LocationDto> locationDtoList) {
        return locationDtoList.stream()
                .map(dto -> this.createOrUpdate(dto.getLocationId(), dto))
                .toList();
    }

    public List<LocationDto> batchUpdate(List<LocationDto> locationDtoList) {
        return locationDtoList.stream().map(dto -> this.update(dto.getLocationId(), dto)).toList();
    }
}
