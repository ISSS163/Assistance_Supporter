package com.Assistance_Supporter.server.dto;

import com.Assistance_Supporter.server.model.Answer;
import lombok.AllArgsConstructor;
import lombok.Value;

import java.util.List;

@Value
@AllArgsConstructor
public class QuestionDTO {
    String text;
    List<Answer> answers;
}
