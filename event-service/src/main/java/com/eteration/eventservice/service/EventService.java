package com.eteration.eventservice.service;

import com.eteration.eventservice.model.Event;
import com.eteration.eventservice.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventService {

    private final EventRepository repository;

    public Event get(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Belirtilen id değerine sahip bir kayıt bulunamadı"));
    }

    public List<Event> getAll() {
        return repository.findAll(Sort.by(Sort.Direction.ASC, "startDate"));
    }

    public Event save(Event event) {
        return repository.save(event);
    }

    public Event addAttendee(String eventId, Long attendeeId) {
        Event event = get(eventId);
        event.addAttendee(attendeeId);

        return save(event);
    }
}
