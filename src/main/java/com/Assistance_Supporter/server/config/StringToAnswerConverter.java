package com.Assistance_Supporter.server.config;

import com.Assistance_Supporter.server.model.Answer;
import com.Assistance_Supporter.server.service.InterviewerService;
import com.sun.istack.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StringToAnswerConverter implements Converter<String, Answer> {
    @NotNull
    private final InterviewerService interviewerService;

    @Override
    public Answer convert(String s) {
        String info = s.substring(27, s.indexOf(")"));
        String question = info.substring(info.indexOf("=") + 1, info.indexOf("answerText") - 2);
        String answer = info.substring(info.lastIndexOf("=") + 1);
        for (Answer answer1 : interviewerService.getAllAnswers()) {
            if (answer1.getId().getAnswerText().equals(answer) && answer1.getId().getQuestion().equals(question)) {
                return answer1;
            }
        }
        return null;
    }
}
