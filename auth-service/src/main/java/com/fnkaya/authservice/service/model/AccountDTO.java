package com.fnkaya.authservice.service.model;

import com.fnkaya.authservice.domain.Authority;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AccountDTO {

    private String email;

    private String fullName;

    private Set<Authority> authorities;
}
