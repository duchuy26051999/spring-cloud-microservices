package com.fnkaya.authservice.security.model;

import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors
@NoArgsConstructor
@AllArgsConstructor
public class LoginInput {

    @NotBlank
    private String email;

    @NotBlank
    private String password;
}
