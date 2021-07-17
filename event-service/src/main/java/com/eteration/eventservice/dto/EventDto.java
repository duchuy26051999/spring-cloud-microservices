package com.eteration.eventservice.dto;

import com.eteration.eventservice.model.Address;
import com.eteration.eventservice.model.EventType;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EventDto implements Serializable {

    private String title;

    private String description;

    private EventType type;

    private Address address;

    private Long ownerId;

    private int quota;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private boolean isActive;
}
