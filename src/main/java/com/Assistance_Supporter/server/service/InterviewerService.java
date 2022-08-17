package com.Assistance_Supporter.server.service;

import com.Assistance_Supporter.server.dto.QuestionDTO;
import com.Assistance_Supporter.server.dto.SolutionDTO;
import com.Assistance_Supporter.server.model.Answer;
import com.Assistance_Supporter.server.model.Question;
import com.Assistance_Supporter.server.model.Solution;
import com.Assistance_Supporter.server.repository.AnswerRepository;
import com.Assistance_Supporter.server.repository.QuestionRepository;
import com.Assistance_Supporter.server.repository.SolutionRepository;

import java.util.List;

public interface InterviewerService {

    Question getFirstQuestion();

    Question getNextQuestion(String questionPrev, String answerPrev);

    void initIndexes();

    boolean isFinalQuestion();

    void editSolutionsList(String questionPrev, String answerPrev);

    Solution getSolution();

    List<Answer> getAllAnswers();

    List<Answer> toAnswerList(String textQuestion, String answers);

    void createQuestion(QuestionDTO questionDTO);

    void createSolution(SolutionDTO solutionDTO);
}
