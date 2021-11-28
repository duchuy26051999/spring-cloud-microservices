package com.fnkaya.mentorship.application.domain;

public enum ApplicationStatus {

    PENDING("Bekliyor"),
    REJECTED("Reddedildi"),
    ACCEPTED("Kabul edildi");

    String description;

    ApplicationStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
