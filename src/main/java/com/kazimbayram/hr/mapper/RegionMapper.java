package com.kazimbayram.hr.mapper;

import com.kazimbayram.hr.dto.RegionDto;
import com.kazimbayram.hr.entity.Region;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RegionMapper {

    Region toRegion(RegionDto dto);

    List<Region> toRegion(List<RegionDto> dtoList);

    RegionDto toRegionDto(Region entity);

    List<RegionDto> toRegionDto(List<Region> entityList);

    Region updateRegion(RegionDto dto, @MappingTarget Region entity);
}
