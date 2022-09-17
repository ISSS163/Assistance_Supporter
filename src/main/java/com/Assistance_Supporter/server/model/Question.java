package com.Assistance_Supporter.server.model;

import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Question {
    @Id
    private String text;

    @ToString.Exclude
    @OneToMany(mappedBy = "question",cascade = CascadeType.ALL)
    private List<Answer> answers;


}
