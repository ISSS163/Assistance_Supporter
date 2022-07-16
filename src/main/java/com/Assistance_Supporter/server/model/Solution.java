package com.Assistance_Supporter.server.model;

import lombok.Data;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
public class Solution {
    @Id
    private String solutionText;
    @OneToMany(cascade = CascadeType.ALL)

    private List<Answer> answers;
}
