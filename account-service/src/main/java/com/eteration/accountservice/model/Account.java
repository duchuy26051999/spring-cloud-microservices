package com.eteration.accountservice.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
@ToString
@Builder
@Entity
@Table(name = "accounts")
public class Account implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "passwd")
    private String password;

    @Column(name = "name")
    private String fullName;

    @Embedded
    @Column(name = "address")
    private Address address;
}
