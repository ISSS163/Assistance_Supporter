package com.Assistance_Supporter.server.mapper.decorator;

import com.Assistance_Supporter.server.dto.QuestionDTO;
import com.Assistance_Supporter.server.mapper.QuestionMapper;
import com.Assistance_Supporter.server.middleware.AnswersParser;
import com.Assistance_Supporter.server.model.Answer;
import com.Assistance_Supporter.server.model.AnswerId;
import com.Assistance_Supporter.server.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.ArrayList;
import java.util.List;

public abstract class QuestionMapperDecorator implements QuestionMapper {
    @Autowired
    @Qualifier("delegate")
    private QuestionMapper delegate;

    @Override
    public Question toQuestion(QuestionDTO questionDTO) {
        Question question = delegate.toQuestion(questionDTO);
        String[] answers = AnswersParser.parseAnswers(questionDTO.getAnswers());
        List<Answer> answersList = new ArrayList<>();
        for (String s : answers) {
            answersList.add(new Answer(new AnswerId(questionDTO.getText(), s), null, null));
        }
        question.setAnswers(answersList);
        question.setText(questionDTO.getText());
        return question;
    }
}
