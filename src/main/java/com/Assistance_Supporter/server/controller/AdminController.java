package com.Assistance_Supporter.server.controller;

import com.Assistance_Supporter.server.dto.QuestionDTO;
import com.Assistance_Supporter.server.dto.SolutionDTO;
import com.Assistance_Supporter.server.model.Answer;
import com.Assistance_Supporter.server.service.InterviewerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class AdminController {

    private final InterviewerService interviewerService;

    @GetMapping("/admin")
    public String admin(Model model) {
        model.addAttribute("questions", interviewerService.getAllQuestions());
        return "admin";
    }

    @GetMapping("/admin/addQuestionAndAnswers")
    public String adminAddQuestionAndAnswers(Model model) {
        model.addAttribute("questionDTO", new QuestionDTO());
        return "admin-add-question";
    }

    @GetMapping("/admin/addSolution")
    public String adminAddSolution(Model model) {
        model.addAttribute("answersList", interviewerService.getAllAnswers());
        model.addAttribute("solutionDTO", new SolutionDTO());
        model.addAttribute("flag", false);
        return "admin-add-solution";
    }

    @PostMapping("/admin/addQuestionAndAnswers")
    public String adminAddQuestion(@ModelAttribute QuestionDTO questionDTO, Model model) {
        interviewerService.createQuestion(questionDTO);
        return "redirect:/admin/addQuestionAndAnswers";
    }

    @PostMapping("/admin/addSolution")
    public String adminAddSolution(@ModelAttribute SolutionDTO solutionDTO, Model model, @RequestParam boolean flag) {
        if (flag) {
            solutionDTO.getAnswers().add(new Answer());
            model.addAttribute("solutionDTO", solutionDTO);
        } else {
            interviewerService.createSolution(solutionDTO);
        }
        return "redirect:/admin/addSolution";
    }
}
