package com.kazimbayram.hr.controller;

import com.kazimbayram.hr.dto.CountryDto;
import com.kazimbayram.hr.service.CountryService;

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
@RequestMapping("/countries")
public class CountryController {

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/{countryId}")
    public CountryDto findByCountryId(@PathVariable("countryId") String countryId) {
        return this.countryService.findByCountryId(countryId);
    }

    @PostMapping("/")
    public CountryDto create(@RequestBody CountryDto countryDto) {
        return this.countryService.create(countryDto);
    }

    @PutMapping("/{countryId}")
    public CountryDto createOrUpdate(
            @PathVariable("countryId") String countryId, @RequestBody CountryDto countryDto) {
        return this.countryService.createOrUpdate(countryId, countryDto);
    }

    @PatchMapping("/{countryId}")
    public CountryDto update(
            @PathVariable("countryId") String countryId, @RequestBody CountryDto countryDto) {
        return this.countryService.update(countryId, countryDto);
    }

    @DeleteMapping("/{countryId}")
    public void delete(@PathVariable("countryId") String countryId) {
        this.countryService.delete(countryId);
    }

    @GetMapping("/by-region/{regionId}")
    public List<CountryDto> findByRegionId(@PathVariable("regionId") Long regionId) {
        return this.countryService.findByRegionId(regionId);
    }

    @PostMapping("/batch")
    public List<CountryDto> batchCreate(@RequestBody List<CountryDto> countryDtoList) {
        return this.countryService.batchCreate(countryDtoList);
    }

    @PutMapping("/batch")
    public List<CountryDto> batchCreateOrUpdate(@RequestBody List<CountryDto> countryDtoList) {
        return this.countryService.batchCreateOrUpdate(countryDtoList);
    }

    @PatchMapping("/batch")
    public List<CountryDto> batchUpdate(@RequestBody List<CountryDto> countryDtoList) {
        return this.countryService.batchUpdate(countryDtoList);
    }
}
