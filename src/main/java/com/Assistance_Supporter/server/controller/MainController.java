package com.Assistance_Supporter.server.controller;

import com.Assistance_Supporter.server.dto.QuestionDTO;
import com.Assistance_Supporter.server.dto.SolutionDTO;
import com.Assistance_Supporter.server.middleware.AnswersParser;
import com.Assistance_Supporter.server.model.Answer;
import com.Assistance_Supporter.server.service.InterviewerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@Controller
public class MainController {
    @Autowired
    AnswersParser answersParser;
    @Autowired
    InterviewerService interviewerService;


    @GetMapping("/")
    public String home(Model model) {
        return "home";
    }

    @GetMapping("/admin")
    public String admin(Model model) {
        return "admin";
    }

    @GetMapping("/admin/addQuestionAndAnswers")
    public String adminAddQuestionAndAnswers(Model model) {
        return "admin-add-question";
    }

    @GetMapping("/admin/addSolution")
    public String adminAddSolution(Model model) {
        model.addAttribute("answers", interviewerService.getAllAnswers());
        return "admin-add-solution";
    }

    @PostMapping("/admin/addQuestionAndAnswers")
    public String adminAddQuestion(@RequestParam String textQuestion, @RequestParam String answers, Model model) {
        QuestionDTO question = new QuestionDTO(textQuestion, interviewerService.toAnswerList(textQuestion, answers));
        interviewerService.createQuestion(question);
        return "redirect:/admin/addQuestionAndAnswers";
    }

    @PostMapping("/admin/addSolution")
    public String adminAddSolution(@RequestParam String name, @RequestParam List<Answer> answers, Model model) {
        SolutionDTO solutionDTO = new SolutionDTO(name, answers);
        interviewerService.createSolution(solutionDTO);
        return "admin-add-solution";
    }

    @GetMapping("/test")
    public String test(Model model) {
        model.addAttribute("firstQuestion", interviewerService.getFirstQuestion());
        return "test";
    }

    @GetMapping("/test/{id}")
    public String testingGet(Model model) {

        return "test";
    }

    @PostMapping("/test")
    public String testStart(Model model) {
        model.addAttribute("firstQuestion", interviewerService.getFirstQuestion());
        return "redirect:/test/"+ Objects.requireNonNull(model.getAttribute("firstQuestion")).toString();
    }

    @PostMapping("/test/{id}")
    public String testing(@PathVariable(value = "id") String text, @RequestParam String answer, @RequestParam String question, Model model) {
        model.addAttribute("question", interviewerService.getNextQuestion(text, answer));
        if (interviewerService.isFinalQuestion()) {
            return "test-finish";
        }
        return "redirect:/test/" + Objects.requireNonNull(model.getAttribute("question")).toString();
    }

    @GetMapping("/test/finish")
    public String solution(Model model) {
        model.addAttribute("solution", interviewerService.getSolution());
        return "test-finish";
    }
}
