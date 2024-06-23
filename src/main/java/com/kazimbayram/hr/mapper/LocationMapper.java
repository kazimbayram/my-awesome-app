package com.kazimbayram.hr.mapper;

import com.kazimbayram.hr.dto.LocationDto;
import com.kazimbayram.hr.entity.Location;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LocationMapper {

    @Mapping(target = "country", ignore = true)
    Location toLocation(LocationDto dto);

    List<Location> toLocation(List<LocationDto> dtoList);

    @Mapping(target = "countryCountryId", source = "country.countryId")
    LocationDto toLocationDto(Location entity);

    List<LocationDto> toLocationDto(List<Location> entityList);

    @Mapping(target = "country", ignore = true)
    Location updateLocation(LocationDto dto, @MappingTarget Location entity);
}
