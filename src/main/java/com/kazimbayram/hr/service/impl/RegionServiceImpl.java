package com.kazimbayram.hr.service.impl;

import com.kazimbayram.hr.dto.RegionDto;
import com.kazimbayram.hr.mapper.RegionMapper;
import com.kazimbayram.hr.repository.RegionRepository;
import com.kazimbayram.hr.service.RegionService;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionServiceImpl implements RegionService {

    private final RegionMapper regionMapper;
    private final RegionRepository regionRepository;

    public RegionServiceImpl(RegionMapper regionMapper, RegionRepository regionRepository) {
        this.regionMapper = regionMapper;
        this.regionRepository = regionRepository;
    }

    public List<RegionDto> findAll() {
        var region = this.regionRepository.findAll();
        return this.regionMapper.toRegionDto(region);
    }

    public RegionDto findByRegionId(Long regionId) {
        var region = this.regionRepository.findByRegionId(regionId).orElseThrow();
        return this.regionMapper.toRegionDto(region);
    }

    public RegionDto create(RegionDto regionDto) {
        var region = this.regionMapper.toRegion(regionDto);

        region.setRegionId(null);

        region = this.regionRepository.save(region);
        return this.regionMapper.toRegionDto(region);
    }

    public RegionDto createOrUpdate(Long regionId, RegionDto regionDto) {
        var region = this.regionMapper.toRegion(regionDto);

        region.setRegionId(regionId);

        region = this.regionRepository.save(region);

        return this.regionMapper.toRegionDto(region);
    }

    public RegionDto update(Long regionId, RegionDto regionDto) {
        var exist = this.regionRepository.existsById(regionId);

        if (!exist) throw new EntityNotFoundException("Not Exists");

        var region = this.regionMapper.toRegion(regionDto);

        region.setRegionId(regionId);

        region = this.regionRepository.save(region);

        return this.regionMapper.toRegionDto(region);
    }

    public void delete(Long regionId) {
        this.regionRepository.deleteById(regionId);
    }

    public List<RegionDto> batchCreate(List<RegionDto> regionDtoList) {
        return regionDtoList.stream().map(this::create).toList();
    }

    public List<RegionDto> batchCreateOrUpdate(List<RegionDto> regionDtoList) {
        return regionDtoList.stream()
                .map(dto -> this.createOrUpdate(dto.getRegionId(), dto))
                .toList();
    }

    public List<RegionDto> batchUpdate(List<RegionDto> regionDtoList) {
        return regionDtoList.stream().map(dto -> this.update(dto.getRegionId(), dto)).toList();
    }
}
