package com.fnkaya.mentorship.post.model;

import lombok.Data;

@Data
public class MentorDto {

    private String id;

    private AccountDto account;

    private boolean available;
}
