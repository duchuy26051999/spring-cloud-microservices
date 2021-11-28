package com.fnkaya.mentorship.mentor.domain;

import com.fnkaya.mentorship.common.model.Account;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors
@Entity
public class Mentor {

    @Id
    private String id;

    @OneToOne(fetch = FetchType.LAZY)
    private Account account;

    private boolean available;
}
