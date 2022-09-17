package com.Assistance_Supporter.server.controller;

import com.Assistance_Supporter.server.service.InterviewerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Objects;

@Controller
@RequiredArgsConstructor
public class TestController {

    private final InterviewerService interviewerService;


    @GetMapping("/test")
    public String test(Model model) {
        model.addAttribute("firstQuestion", interviewerService.getFirstQuestion());
        return "test";
    }

    @GetMapping("/test/{id}")
    public String testingGet(Model model) {
        model.addAttribute("question", interviewerService.getFirstQuestion());
        model.addAttribute("answer", "");
        return "test-start";
    }

    @PostMapping("/test/{id}")
    public String testing(@PathVariable(value = "id") String id, @RequestParam String answer, Model model) {
        model.addAttribute("question", interviewerService.getNextQuestion(id, answer));
        if (interviewerService.isFinalQuestion()) {
            return "redirect:/test/finish";
        }
        return "test-start";
    }

    @GetMapping("/test/finish")
    public String solution(Model model) {
        model.addAttribute("solution", interviewerService.getSolution());
        return "test-finish";
    }
}
