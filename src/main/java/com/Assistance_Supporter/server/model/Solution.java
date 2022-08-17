package com.Assistance_Supporter.server.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Solution {

    @Id
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "solution")
    private List<Answer> answers;


}
