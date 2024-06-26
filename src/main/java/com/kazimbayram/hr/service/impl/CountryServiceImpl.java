package com.kazimbayram.hr.service.impl;

import com.kazimbayram.hr.dto.CountryDto;
import com.kazimbayram.hr.mapper.CountryMapper;
import com.kazimbayram.hr.repository.CountryRepository;
import com.kazimbayram.hr.service.CountryService;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryMapper countryMapper;
    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryMapper countryMapper, CountryRepository countryRepository) {
        this.countryMapper = countryMapper;
        this.countryRepository = countryRepository;
    }

    public List<CountryDto> findAll() {
        var country = this.countryRepository.findAll();
        return this.countryMapper.toCountryDto(country);
    }

    public CountryDto findByCountryId(String countryId) {
        var country = this.countryRepository.findByCountryId(countryId).orElseThrow();
        return this.countryMapper.toCountryDto(country);
    }

    public CountryDto create(CountryDto countryDto) {
        var country = this.countryMapper.toCountry(countryDto);

        country.setCountryId(null);

        country = this.countryRepository.save(country);
        return this.countryMapper.toCountryDto(country);
    }

    public CountryDto createOrUpdate(String countryId, CountryDto countryDto) {
        var country = this.countryMapper.toCountry(countryDto);

        country.setCountryId(countryId);

        country = this.countryRepository.save(country);

        return this.countryMapper.toCountryDto(country);
    }

    public CountryDto update(String countryId, CountryDto countryDto) {
        var exist = this.countryRepository.existsById(countryId);

        if (!exist) throw new EntityNotFoundException("Not Exists");

        var country = this.countryMapper.toCountry(countryDto);

        country.setCountryId(countryId);

        country = this.countryRepository.save(country);

        return this.countryMapper.toCountryDto(country);
    }

    public void delete(String countryId) {
        this.countryRepository.deleteById(countryId);
    }

    public List<CountryDto> findByRegionId(Long regionId) {
        var country = this.countryRepository.findByRegionRegionId(regionId);

        return this.countryMapper.toCountryDto(country);
    }

    public List<CountryDto> batchCreate(List<CountryDto> countryDtoList) {
        return countryDtoList.stream().map(this::create).toList();
    }

    public List<CountryDto> batchCreateOrUpdate(List<CountryDto> countryDtoList) {
        return countryDtoList.stream()
                .map(dto -> this.createOrUpdate(dto.getCountryId(), dto))
                .toList();
    }

    public List<CountryDto> batchUpdate(List<CountryDto> countryDtoList) {
        return countryDtoList.stream().map(dto -> this.update(dto.getCountryId(), dto)).toList();
    }
}
