package com.Assistance_Supporter.server.repository;

import com.Assistance_Supporter.server.model.Answer;
import com.Assistance_Supporter.server.model.Solution;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SolutionRepository extends JpaRepository<Solution,String> {
}
