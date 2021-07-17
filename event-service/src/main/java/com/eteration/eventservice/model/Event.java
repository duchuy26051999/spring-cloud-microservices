package com.eteration.eventservice.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
@ToString
@Document(collection = "events")
public class Event implements Serializable {

    @Id
    private String id;

    private String title;

    private String description;

    private EventType type;

    private Address address;

    @Field(value = "owner_id")
    private Long ownerId;

    private int quota;

    @Field(value = "start_date")
    private LocalDateTime startDate;

    @Field(value = "end_date")
    private LocalDateTime endDate;

    @Field(value = "is_active")
    private boolean isActive;

    @Field(value = "attendees")
    private List<Long> attendeeIdList = new ArrayList<>();

    public void addAttendee(Long attendeeId) {
        this.attendeeIdList.add(attendeeId);
    }
}
