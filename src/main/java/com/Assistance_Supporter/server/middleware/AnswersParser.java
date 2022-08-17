package com.Assistance_Supporter.server.middleware;

import com.Assistance_Supporter.server.model.Answer;
import com.Assistance_Supporter.server.model.AnswerId;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
@Data
public class AnswersParser {
    public static final String REGULAR_ANSWER = ", *";

    public static String[] parseAnswers(String answers) {
        return answers.split(REGULAR_ANSWER);
    }

}
