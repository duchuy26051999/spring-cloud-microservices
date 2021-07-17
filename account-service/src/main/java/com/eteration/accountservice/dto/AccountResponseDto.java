package com.eteration.accountservice.dto;

import com.eteration.accountservice.model.Address;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AccountResponseDto {

    private String email;

    private String fullName;

    private Address address;
}
