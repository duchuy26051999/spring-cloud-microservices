package com.fnkaya.mentorship.mentor.model;

import lombok.Data;

@Data
public class MentorDto {

    private String id;

    private AccountDto account;

    private boolean available;

    private double rating;
}
