package com.myproject.antaev.service.impl;

import com.myproject.antaev.entity.ReleaseEntity;
import com.myproject.antaev.mappers.ReleaseMapper;
import com.myproject.antaev.repository.ReleaseRepository;
import com.myproject.antaev.rest.controllers.exceptions.NotFoundException;
import com.myproject.antaev.rest.dto.ReleaseRequestDto;
import com.myproject.antaev.rest.dto.ReleaseResponseDto;
import com.myproject.antaev.service.ReleaseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ReleaseServiceImpl implements ReleaseService {
    private final ReleaseMapper mapper;
    private final ReleaseRepository repository;

    public ReleaseServiceImpl(ReleaseMapper mapper, ReleaseRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    public ReleaseResponseDto createRelease(ReleaseRequestDto releaseRequestDto) {
        ReleaseEntity releaseEntity = mapper.requestDtoToEntity(releaseRequestDto, new ReleaseEntity());
        releaseEntity = repository.save(releaseEntity);
        return mapper.entityToResponseDto(releaseEntity);
    }

    @Override
    public ReleaseResponseDto readRelease(int releaseVersion) {
        ReleaseEntity releaseEntity = getOrElseThrow(releaseVersion);
        return mapper.entityToResponseDto(releaseEntity);
    }

    @Override
    @Transactional
    public ReleaseResponseDto updateRelease(ReleaseRequestDto releaseRequestDto, int releaseVersion) {
        ReleaseEntity releaseEntity = getOrElseThrow(releaseVersion);
        releaseEntity = mapper.requestDtoToEntity(releaseRequestDto, releaseEntity);
        return mapper.entityToResponseDto(releaseEntity);
    }

    @Override
    public void deleteRelease(int releaseVersion) {
        getOrElseThrow(releaseVersion);
        repository.deleteById(releaseVersion);
    }

    @Override
    public List<ReleaseResponseDto> readListReleaseByProjectId(int releaseVersion) {
        List<ReleaseEntity> list = repository.findAllByProjectId(releaseVersion);
        return mapper.listEntityToListResponseDto(list);
    }

    private ReleaseEntity getOrElseThrow(int releaseVersion) {
        Optional<ReleaseEntity> ReleaseEntity = repository.findById(releaseVersion);
        return ReleaseEntity.orElseThrow(() -> new NotFoundException(String.format("Релиз с номером = %d не найден", releaseVersion)));
    }
}
