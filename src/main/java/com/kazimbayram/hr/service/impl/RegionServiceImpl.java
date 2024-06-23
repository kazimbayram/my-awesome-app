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

    public RegionDto findByRegionId(Long regionId) {
        var entity = this.regionRepository.findByRegionId(regionId).orElseThrow();
        return this.regionMapper.toRegionDto(entity);
    }

    public RegionDto create(RegionDto regionDto) {
        var entity = this.regionMapper.toRegion(regionDto);
        entity.setRegionId(null);
        entity = this.regionRepository.save(entity);
        return this.regionMapper.toRegionDto(entity);
    }

    public RegionDto createOrUpdate(Long regionId, RegionDto regionDto) {
        var entity = this.regionMapper.toRegion(regionDto);

        entity.setRegionId(regionId);

        entity = this.regionRepository.save(entity);

        return this.regionMapper.toRegionDto(entity);
    }

    public RegionDto update(Long regionId, RegionDto regionDto) {
        var exist = this.regionRepository.existsById(regionId);
        if (!exist) throw new EntityNotFoundException("Not Exists");
        var entity = this.regionMapper.toRegion(regionDto);

        entity.setRegionId(regionId);

        entity = this.regionRepository.save(entity);

        return this.regionMapper.toRegionDto(entity);
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
