package com.Assistance_Supporter.server.model;

import lombok.*;
import javax.persistence.*;
import static javax.persistence.CascadeType.ALL;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Answer {
    @EmbeddedId
    private AnswerId id;

    @ManyToOne(cascade = ALL)
    private Question question;
    @ManyToOne(cascade = ALL)
    private Solution solution;

}
