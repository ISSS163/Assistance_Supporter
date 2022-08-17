package com.Assistance_Supporter.server.model;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
public class Question {
    @Id
    private String text;

    @OneToMany(mappedBy = "question")
    List<Answer> answers;

    public Question(String text, List<Answer> answers) {
        this.text = text;
        this.answers = answers;
    }

    public Question() {

    }
}
