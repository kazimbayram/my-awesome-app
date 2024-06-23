package com.kazimbayram.hr.mapper;

import com.kazimbayram.hr.dto.CountryDto;
import com.kazimbayram.hr.entity.Country;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CountryMapper {

    @Mapping(target = "region", ignore = true)
    Country toCountry(CountryDto dto);

    List<Country> toCountry(List<CountryDto> dtoList);

    @Mapping(target = "regionRegionId", source = "region.regionId")
    CountryDto toCountryDto(Country entity);

    List<CountryDto> toCountryDto(List<Country> entityList);

    @Mapping(target = "region", ignore = true)
    Country updateCountry(CountryDto dto, @MappingTarget Country entity);
}
