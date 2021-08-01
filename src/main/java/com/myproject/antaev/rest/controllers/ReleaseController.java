package com.myproject.antaev.rest.controllers;

import com.myproject.antaev.rest.controllers.exceptions.TestRuntimeExceptions;
import com.myproject.antaev.rest.dto.ReleaseRequestDto;
import com.myproject.antaev.rest.dto.ReleaseResponseDto;
import com.myproject.antaev.service.ReleaseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/releases")
@Tag(name = "Релизы поектов", description = "Редактирование релизов")
public class ReleaseController {
    private final ReleaseService releaseService;

    public ReleaseController(ReleaseService releaseService) {
        this.releaseService = releaseService;
    }

    @GetMapping
    @Operation(summary = "Список релизов")
    public ResponseEntity<List<ReleaseResponseDto>> readListReleasesOfProject(@PathVariable int projectNumber) {
        List<ReleaseResponseDto> list = releaseService.readListReleaseByProjectId(projectNumber);
        return ResponseEntity.ok(list);
    }

    @PostMapping
    @Operation(summary = "Создание релиза")
    public ResponseEntity<ReleaseResponseDto> createRelease(@RequestBody ReleaseRequestDto requestDto) {
        ReleaseResponseDto responseDto = releaseService.createRelease(requestDto);
        return ResponseEntity.ok().body(responseDto);
    }

    @PutMapping(value = "/{releaseId}")
    @Operation(summary = "Изменение релиза")
    public ResponseEntity<ReleaseResponseDto> updateRelease(@RequestBody ReleaseRequestDto requestDto,
                                                            @PathVariable int releaseVersion) {
        ReleaseResponseDto responseDto = releaseService.updateRelease(requestDto, releaseVersion);
        return ResponseEntity.ok().body(responseDto);
    }

    @DeleteMapping(value = "/{releaseId}")
    @Operation(summary = "Удаление релиза")
    public ResponseEntity<?> deleteRelease(@PathVariable int releaseVersion) {
        releaseService.deleteRelease(releaseVersion);
        return ResponseEntity.accepted().build();
    }
}

