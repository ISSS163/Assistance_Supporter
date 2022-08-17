package com.Assistance_Supporter.server.mapper;

import com.Assistance_Supporter.server.dto.QuestionDTO;
import com.Assistance_Supporter.server.model.Question;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface QuestionMapper {
    QuestionDTO toQuestionDTO(Question question);

    Question toQuestion(QuestionDTO questionDTO);
}
