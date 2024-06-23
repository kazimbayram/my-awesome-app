package com.kazimbayram.hr.service;

import com.kazimbayram.hr.dto.CountryDto;

import java.util.List;

public interface CountryService {

    CountryDto findByCountryId(String countryId);

    CountryDto create(CountryDto countryDto);

    CountryDto createOrUpdate(String countryId, CountryDto countryDto);

    CountryDto update(String countryId, CountryDto countryDto);

    void delete(String countryId);

    List<CountryDto> findByRegionId(Long regionId);

    List<CountryDto> batchCreate(List<CountryDto> countryDtoList);

    List<CountryDto> batchCreateOrUpdate(List<CountryDto> countryDtoList);

    List<CountryDto> batchUpdate(List<CountryDto> countryDtoList);
}
