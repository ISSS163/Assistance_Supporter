package com.Assistance_Supporter.server.model;

import lombok.Data;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
public class AnswerId implements Serializable {
    private String question;
    private String answerText;

    public AnswerId(String question, String answerText){
        this.answerText = answerText;
        this.question = question;
    }

    public AnswerId() {

    }
}
