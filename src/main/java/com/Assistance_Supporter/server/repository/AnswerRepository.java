package com.Assistance_Supporter.server.repository;

import com.Assistance_Supporter.server.model.Answer;
import com.Assistance_Supporter.server.model.AnswerId;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AnswerRepository extends JpaRepository<Answer, AnswerId> {
}
