package com.Assistance_Supporter.server.service;

import com.Assistance_Supporter.server.dto.QuestionDTO;
import com.Assistance_Supporter.server.dto.SolutionDTO;
import com.Assistance_Supporter.server.model.Answer;
import com.Assistance_Supporter.server.model.Question;
import com.Assistance_Supporter.server.model.Solution;

import java.util.List;

public interface InterviewerService {

    Question getFirstQuestion();

    Question getNextQuestion(String questionPrev, String answerPrev);

    boolean isFinalQuestion();

    void editSolutionsList(String questionPrev, String answerPrev);

    Solution getSolution();

    List<Answer> getAllAnswers();

    List<Question> getAllQuestions();

    void createQuestion(QuestionDTO questionDTO);

    void createSolution(SolutionDTO solutionDTO);
}
