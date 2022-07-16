package com.Assistance_Supporter.server.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Optional;

@Entity
@Data
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String answerText;
    @OneToOne(cascade = CascadeType.ALL)

    private Question question;


}
