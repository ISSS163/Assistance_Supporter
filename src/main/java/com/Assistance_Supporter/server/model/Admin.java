package com.Assistance_Supporter.server.model;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Admin {
    @Id
    private Long id;

}
