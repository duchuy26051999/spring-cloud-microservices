package com.eteration.accountservice.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Embeddable
public class Address implements Serializable {

    @Column(name = "city")
    private String city;

    @Column(name = "district")
    private String district;

    @Column(name = "address")
    private String address;
}
