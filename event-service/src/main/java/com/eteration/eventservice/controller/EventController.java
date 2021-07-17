package com.eteration.eventservice.controller;

import com.eteration.eventservice.controller.path.ApiPath;
import com.eteration.eventservice.model.Event;
import com.eteration.eventservice.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(ApiPath.EVENT_URL)
@RequiredArgsConstructor
public class EventController {

    private final EventService service;

    @GetMapping(value = "{id}")
    public ResponseEntity<Event> get(@PathVariable String id) {
        return ResponseEntity.ok(service.get(id));
    }

    @GetMapping
    public ResponseEntity<Map<String, List<Event>>> getAll() {
        List<Event> eventList = service.getAll();

        return ResponseEntity.ok(Map.of("eventList", eventList));
    }

    @PostMapping
    public ResponseEntity<Event> save(@RequestBody Event event) {
        Event savedEvent = service.save(event);

        return new ResponseEntity<>(savedEvent, HttpStatus.CREATED);
    }

    @PutMapping("{eventId}/attendees/{attendeeId}")
    public ResponseEntity<Event> addAttendee(@PathVariable String eventId, @PathVariable(name = "attendeeId") Long attendeeId) {
        Event event = service.addAttendee(eventId, attendeeId);

        return ResponseEntity.ok(event);
    }
}
