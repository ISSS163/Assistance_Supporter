package com.Assistance_Supporter.server.model;

import lombok.Data;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Question {
    @Id
    private String questionText;


}
