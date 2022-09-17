package com.Assistance_Supporter.server.controller;

import com.Assistance_Supporter.server.dto.QuestionDTO;
import com.Assistance_Supporter.server.dto.SolutionDTO;
import com.Assistance_Supporter.server.middleware.AnswersParser;
import com.Assistance_Supporter.server.model.Answer;
import com.Assistance_Supporter.server.service.InterviewerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@Controller
@RequiredArgsConstructor
public class MainController {

    @GetMapping("/")
    public String home(Model model) {
        return "home";
    }


}
