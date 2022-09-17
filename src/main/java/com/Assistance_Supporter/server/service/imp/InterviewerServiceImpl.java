package com.Assistance_Supporter.server.service.imp;

import com.Assistance_Supporter.server.dto.QuestionDTO;
import com.Assistance_Supporter.server.dto.SolutionDTO;
import com.Assistance_Supporter.server.mapper.QuestionMapper;
import com.Assistance_Supporter.server.mapper.SolutionMapper;
import com.Assistance_Supporter.server.middleware.AnswersParser;
import com.Assistance_Supporter.server.model.Answer;
import com.Assistance_Supporter.server.model.AnswerId;
import com.Assistance_Supporter.server.model.Question;
import com.Assistance_Supporter.server.model.Solution;
import com.Assistance_Supporter.server.repository.AnswerRepository;
import com.Assistance_Supporter.server.repository.QuestionRepository;
import com.Assistance_Supporter.server.repository.SolutionRepository;
import com.Assistance_Supporter.server.service.InterviewerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InterviewerServiceImpl implements InterviewerService {

    private final AnswerRepository repositoryAnswer;
    private final QuestionRepository repositoryQuestion;
    private final SolutionRepository repositorySolution;
    private final QuestionMapper questionMapper;
    private final SolutionMapper solutionMapper;

    private List<Solution> solutionsList;
    private List<Integer> indexes;

    public List<Answer> getAllAnswers() {
        return repositoryAnswer.findAll();
    }

    public List<Question> getAllQuestions() {
        return repositoryQuestion.findAll();
    }

    public void createQuestion(QuestionDTO questionDTO) {
        Question question = questionMapper.toQuestion(questionDTO);
        for (Answer a : question.getAnswers()) {
            a.setQuestion(question);
            repositoryAnswer.save(a);
        }
        repositoryQuestion.save(question);
    }

    public void createSolution(SolutionDTO solutionDTO) {
        Solution solution = solutionMapper.toSolution(solutionDTO);
        System.out.println(solutionDTO.getAnswers().get(0));
        for (Answer answer : solution.getAnswers()) {
            answer.setSolution(solution);
        }
        repositorySolution.save(solution);
    }

    public Question getFirstQuestion() {
        return repositoryQuestion.getFirstQuestion();
    }

    public Question getNextQuestion(String questionPrev, String answerPrev) {
        editSolutionsList(questionPrev, answerPrev);
        if(indexes.size() != 0){
            indexes.remove(0);
        }
        return repositoryQuestion.findAll().get(indexes.get(0));
    }

    @PostConstruct
    public void initSolutionList() {
        solutionsList = new ArrayList<>();
    }

    @PostConstruct
    public void initIndexes() {
        indexes = new ArrayList<>();
        for (int i = 0; i < repositoryQuestion.findAll().size(); i++) {
            indexes.add(i);
        }
        Collections.shuffle(indexes);
    }

    public boolean isFinalQuestion() {
        return solutionsList.size() == 1;
    }

    public void editSolutionsList(String questionPrev, String answerPrev) {
        for (Solution solution : solutionsList) {
            for (Answer answer : solution.getAnswers()) {
                if (questionPrev.equals(answer.getId().getQuestion())) {
                    if (!answerPrev.equals(answer.getId().getAnswerText())) {
                        solutionsList.remove(solution);
                    }
                }
            }
        }
    }

    public Solution getSolution() {
        return solutionsList.get(0);
    }
}