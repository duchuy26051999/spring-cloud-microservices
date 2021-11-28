package com.fnkaya.mentorship.application.controller;

import com.fnkaya.mentorship.application.model.CreateMentorApplicationDto;
import com.fnkaya.mentorship.application.model.MentorApplicationDto;
import com.fnkaya.mentorship.application.model.mapper.MentorApplicationDtoMapper;
import com.fnkaya.mentorship.application.domain.ApplicationStatus;
import com.fnkaya.mentorship.application.domain.MentorApplication;
import com.fnkaya.mentorship.application.service.MentorApplicationServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/applications")
@RequiredArgsConstructor
public class MentorApplicationController {

    private final MentorApplicationServiceImpl service;
    private final MentorApplicationDtoMapper mapper;

    @PostMapping
    public ResponseEntity<MentorApplicationDto> save(@RequestBody CreateMentorApplicationDto createMentorApplicationDto) {
        MentorApplication mentorApplication = mapper.fromDto(createMentorApplicationDto);
        MentorApplication createdMentorApplication = service.save(mentorApplication);
        MentorApplicationDto mentorApplicationDto = mapper.toDto(createdMentorApplication);
        return ResponseEntity.status(HttpStatus.CREATED).body(mentorApplicationDto);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<MentorApplicationDto> getById(@PathVariable(value = "id") String id) {
        MentorApplication mentorApplication = service.getById(id);
        MentorApplicationDto mentorApplicationDto = mapper.toDto(mentorApplication);
        return ResponseEntity.ok(mentorApplicationDto);
    }

    @GetMapping
    public ResponseEntity<Page<MentorApplicationDto>> getAll(Pageable pageable) {
        Page<MentorApplication> mentorApplications = service.getAll(pageable);
        Page<MentorApplicationDto> mentorApplicationDtos = mentorApplications.map(mapper::toDto);
        return ResponseEntity.ok(mentorApplicationDtos);
    }

    @GetMapping(value = "owner/{ownerId}")
    public ResponseEntity<Page<MentorApplicationDto>> getAllByOwnerId(@PathVariable(value = "ownerId") String  ownerId, Pageable pageable) {
        Page<MentorApplication> mentorApplications = service.getAllByOwnerId(ownerId, pageable);
        Page<MentorApplicationDto> mentorApplicationDtos = mentorApplications.map(mapper::toDto);
        return ResponseEntity.ok(mentorApplicationDtos);
    }

    @GetMapping(value = "status")
    public ResponseEntity<Page<MentorApplicationDto>> getAllByStatus(@RequestParam(value = "status") ApplicationStatus status, Pageable pageable) {
        Page<MentorApplication> mentorApplications = service.getAllByStatus(status, pageable);
        Page<MentorApplicationDto> mentorApplicationDtos = mentorApplications.map(mapper::toDto);
        return ResponseEntity.ok(mentorApplicationDtos);
    }

    @PatchMapping(value = "{id}")
    public ResponseEntity<MentorApplicationDto> updateStatus(@PathVariable(value = "id") String id, @RequestParam(value = "status")ApplicationStatus status) {
        MentorApplication mentorApplication = service.updateStatus(id, status);
        MentorApplicationDto mentorApplicationDto = mapper.toDto(mentorApplication);
        return ResponseEntity.ok(mentorApplicationDto);
    }
}
