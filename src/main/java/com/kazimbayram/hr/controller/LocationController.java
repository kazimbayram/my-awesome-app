package com.kazimbayram.hr.controller;

import com.kazimbayram.hr.dto.LocationDto;
import com.kazimbayram.hr.service.LocationService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/locations")
public class LocationController {

    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping("/{locationId}")
    public LocationDto findByLocationId(@PathVariable("locationId") Long locationId) {
        return this.locationService.findByLocationId(locationId);
    }

    @PostMapping("/")
    public LocationDto create(@RequestBody LocationDto locationDto) {
        return this.locationService.create(locationDto);
    }

    @PutMapping("/{locationId}")
    public LocationDto createOrUpdate(
            @PathVariable("locationId") Long locationId, @RequestBody LocationDto locationDto) {
        return this.locationService.createOrUpdate(locationId, locationDto);
    }

    @PatchMapping("/{locationId}")
    public LocationDto update(
            @PathVariable("locationId") Long locationId, @RequestBody LocationDto locationDto) {
        return this.locationService.update(locationId, locationDto);
    }

    @DeleteMapping("/{locationId}")
    public void delete(@PathVariable("locationId") Long locationId) {
        this.locationService.delete(locationId);
    }

    @GetMapping("/by-country/{countryId}")
    public List<LocationDto> findByCountryId(@PathVariable("countryId") String countryId) {
        return this.locationService.findByCountryId(countryId);
    }

    @GetMapping("/")
    public List<LocationDto> findAll() {
        return this.locationService.findAll();
    }

    @PostMapping("/batch")
    public List<LocationDto> batchCreate(@RequestBody List<LocationDto> locationDtoList) {
        return this.locationService.batchCreate(locationDtoList);
    }

    @PutMapping("/batch")
    public List<LocationDto> batchCreateOrUpdate(@RequestBody List<LocationDto> locationDtoList) {
        return this.locationService.batchCreateOrUpdate(locationDtoList);
    }

    @PatchMapping("/batch")
    public List<LocationDto> batchUpdate(@RequestBody List<LocationDto> locationDtoList) {
        return this.locationService.batchUpdate(locationDtoList);
    }
}
