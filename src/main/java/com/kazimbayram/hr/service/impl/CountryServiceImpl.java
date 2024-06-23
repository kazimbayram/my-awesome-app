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

    public CountryDto findByCountryId(String countryId) {
        var entity = this.countryRepository.findByCountryId(countryId).orElseThrow();
        return this.countryMapper.toCountryDto(entity);
    }

    public CountryDto create(CountryDto countryDto) {
        var entity = this.countryMapper.toCountry(countryDto);
        entity.setCountryId(null);
        entity = this.countryRepository.save(entity);
        return this.countryMapper.toCountryDto(entity);
    }

    public CountryDto createOrUpdate(String countryId, CountryDto countryDto) {
        var entity = this.countryMapper.toCountry(countryDto);

        entity.setCountryId(countryId);

        entity = this.countryRepository.save(entity);

        return this.countryMapper.toCountryDto(entity);
    }

    public CountryDto update(String countryId, CountryDto countryDto) {
        var exist = this.countryRepository.existsById(countryId);
        if (!exist) throw new EntityNotFoundException("Not Exists");
        var entity = this.countryMapper.toCountry(countryDto);

        entity.setCountryId(countryId);

        entity = this.countryRepository.save(entity);

        return this.countryMapper.toCountryDto(entity);
    }

    public void delete(String countryId) {
        this.countryRepository.deleteById(countryId);
    }

    public List<CountryDto> findByRegionId(Long regionId) {
        var entity = this.countryRepository.findByRegionRegionId(regionId);
        return this.countryMapper.toCountryDto(entity);
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
