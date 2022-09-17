package com.Assistance_Supporter.server.config;

import com.Assistance_Supporter.server.service.InterviewerService;
import com.sun.istack.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {
    @NotNull
    private final InterviewerService interviewerService;
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new StringToAnswerConverter(interviewerService));
    }
}
