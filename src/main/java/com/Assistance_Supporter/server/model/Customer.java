package com.Assistance_Supporter.server.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Entity
@Data
public class Customer {

    @Id
    private String username;
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;


}

