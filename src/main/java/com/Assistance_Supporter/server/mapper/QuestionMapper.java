package com.Assistance_Supporter.server.mapper;

import com.Assistance_Supporter.server.dto.QuestionDTO;

import com.Assistance_Supporter.server.mapper.decorator.QuestionMapperDecorator;
import com.Assistance_Supporter.server.model.Question;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
@DecoratedWith(QuestionMapperDecorator.class)
public interface QuestionMapper {
    @Mapping(target = "answers", ignore = true)
    Question toQuestion(QuestionDTO questionDTO);

    @Mapping(target = "answers", ignore = true)
    QuestionDTO toQuestionDTO(Question question);


}
