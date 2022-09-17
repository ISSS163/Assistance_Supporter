package com.Assistance_Supporter.server.middleware;

import lombok.experimental.UtilityClass;

@UtilityClass
public class AnswersParser {
    public static final String REGULAR_ANSWER = ", *";

    public static String[] parseAnswers(String answers) {
        return answers.split(REGULAR_ANSWER);
    }

}
