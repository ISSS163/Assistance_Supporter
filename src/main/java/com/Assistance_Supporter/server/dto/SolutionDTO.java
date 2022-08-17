package com.Assistance_Supporter.server.dto;

import com.Assistance_Supporter.server.model.Answer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.util.List;

@Value
public class SolutionDTO {
    String name;
    List<Answer> answers;
}
