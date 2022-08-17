package com.Assistance_Supporter.server.repository;

import com.Assistance_Supporter.server.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface QuestionRepository extends JpaRepository<Question,String> {
    @Query("SELECT a FROM Question a where a.text='Ваш вопрос связан с работой сервиса?'")
    Question getFirstQuestion();
}
