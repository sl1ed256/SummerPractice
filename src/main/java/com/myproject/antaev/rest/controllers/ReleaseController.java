package com.myproject.antaev.rest.controllers;

import com.myproject.antaev.rest.controllers.exceptions.TestRuntimeExceptions;
import com.myproject.antaev.rest.dto.ReleaseRequestDto;
import com.myproject.antaev.rest.dto.ReleaseResponseDto;
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

    @GetMapping
    @Operation(summary = "Список релизов")
    public ResponseEntity<List<ReleaseResponseDto>> getReleases() {
        List<ReleaseResponseDto> list = new ArrayList<>();
        list.add(new ReleaseResponseDto(1, 1, new Date(), new Date()));
        list.add(new ReleaseResponseDto(2, 1, new Date(), new Date()));
        list.add(new ReleaseResponseDto(3, 3, new Date(), new Date()));
        return ResponseEntity.ok(list);
    }

    @PostMapping
    @Operation(summary = "Создание релиза")
    public ResponseEntity<ReleaseResponseDto> createRelease(@RequestBody ReleaseRequestDto requestDto) {
        return ResponseEntity.ok()
                .body(new ReleaseResponseDto(1, requestDto.getReleaseVersion(), new Date(), new Date()));
    }

    @PutMapping(value = "/{releaseId}")
    @Operation(summary = "Изменение релиза")
    public ResponseEntity<ReleaseResponseDto> updateRelease(@RequestBody ReleaseRequestDto requestDto,
                                                            @PathVariable int releaseId) {
        return ResponseEntity.ok()
                .body(new ReleaseResponseDto(releaseId, requestDto.getReleaseVersion(), requestDto.getStartTime(), requestDto.getEndTime()));
    }

    @DeleteMapping(value = "/{releaseId}")
    @Operation(summary = "Удаление релиза")
    public ResponseEntity<?> deleteRelease(@PathVariable Long releaseId) {
        throw new TestRuntimeExceptions();
    }
}

