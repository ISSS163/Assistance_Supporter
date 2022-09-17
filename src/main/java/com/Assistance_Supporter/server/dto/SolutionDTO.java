package com.Assistance_Supporter.server.dto;

import com.Assistance_Supporter.server.model.Answer;
import com.Assistance_Supporter.server.model.AnswerId;
import com.Assistance_Supporter.server.model.Question;
import com.Assistance_Supporter.server.model.Solution;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Data
public class SolutionDTO {
    private String name;
    private List<Answer> answers;

    public SolutionDTO(){
        name = "";
        answers = new ArrayList<>();
        answers.add(new Answer(new AnswerId(), new Question(), new Solution()));
    }
}
