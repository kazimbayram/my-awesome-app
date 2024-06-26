package com.kazimbayram.hr.controller;

import com.kazimbayram.hr.dto.RegionDto;
import com.kazimbayram.hr.service.RegionService;

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
@RequestMapping("/regions")
public class RegionController {

    private final RegionService regionService;

    public RegionController(RegionService regionService) {
        this.regionService = regionService;
    }

    @GetMapping("/{regionId}")
    public RegionDto findByRegionId(@PathVariable("regionId") Long regionId) {
        return this.regionService.findByRegionId(regionId);
    }

    @PostMapping("/")
    public RegionDto create(@RequestBody RegionDto regionDto) {
        return this.regionService.create(regionDto);
    }

    @PutMapping("/{regionId}")
    public RegionDto createOrUpdate(
            @PathVariable("regionId") Long regionId, @RequestBody RegionDto regionDto) {
        return this.regionService.createOrUpdate(regionId, regionDto);
    }

    @PatchMapping("/{regionId}")
    public RegionDto update(
            @PathVariable("regionId") Long regionId, @RequestBody RegionDto regionDto) {
        return this.regionService.update(regionId, regionDto);
    }

    @DeleteMapping("/{regionId}")
    public void delete(@PathVariable("regionId") Long regionId) {
        this.regionService.delete(regionId);
    }

    @GetMapping("/")
    public List<RegionDto> findAll() {
        return this.regionService.findAll();
    }

    @PostMapping("/batch")
    public List<RegionDto> batchCreate(@RequestBody List<RegionDto> regionDtoList) {
        return this.regionService.batchCreate(regionDtoList);
    }

    @PutMapping("/batch")
    public List<RegionDto> batchCreateOrUpdate(@RequestBody List<RegionDto> regionDtoList) {
        return this.regionService.batchCreateOrUpdate(regionDtoList);
    }

    @PatchMapping("/batch")
    public List<RegionDto> batchUpdate(@RequestBody List<RegionDto> regionDtoList) {
        return this.regionService.batchUpdate(regionDtoList);
    }
}
