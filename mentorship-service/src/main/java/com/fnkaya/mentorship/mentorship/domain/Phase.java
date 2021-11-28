package com.fnkaya.mentorship.mentorship.domain;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors
@Entity
public class Phase {

    @Id
    private String id;

    private String name;

    private LocalDateTime endDate;

    private PhaseStatus status = PhaseStatus.NOT_STARTED;
}
