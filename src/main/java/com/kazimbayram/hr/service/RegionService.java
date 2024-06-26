package com.kazimbayram.hr.service;

import com.kazimbayram.hr.dto.RegionDto;

import java.util.List;

public interface RegionService {

    RegionDto findByRegionId(Long regionId);

    RegionDto create(RegionDto regionDto);

    RegionDto createOrUpdate(Long regionId, RegionDto regionDto);

    RegionDto update(Long regionId, RegionDto regionDto);

    void delete(Long regionId);

    List<RegionDto> findAll();

    List<RegionDto> batchCreate(List<RegionDto> regionDtoList);

    List<RegionDto> batchCreateOrUpdate(List<RegionDto> regionDtoList);

    List<RegionDto> batchUpdate(List<RegionDto> regionDtoList);
}
