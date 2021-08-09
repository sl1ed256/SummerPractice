package com.myproject.antaev.service;

import com.myproject.antaev.rest.dto.ReleaseRequestDto;
import com.myproject.antaev.rest.dto.ReleaseResponseDto;

import java.util.List;

public interface ReleaseService {
    ReleaseResponseDto createRelease(ReleaseRequestDto releaseRequestDto);
    ReleaseResponseDto readRelease(int releaseVersion);
    ReleaseResponseDto updateRelease(ReleaseRequestDto releaseRequestDto, int releaseVersion);
    void deleteRelease(int releaseVersion);
    List<ReleaseResponseDto> readListReleaseByProjectId(int releaseVersion);
}
