package com.Assistance_Supporter.server.mapper;

import com.Assistance_Supporter.server.dto.SolutionDTO;
import com.Assistance_Supporter.server.model.Solution;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SolutionMapper {

    SolutionDTO toSolutionDTO(Solution solution);

    Solution toSolution(SolutionDTO solutionDTO);

}
