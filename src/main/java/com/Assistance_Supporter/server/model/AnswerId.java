package com.Assistance_Supporter.server.model;

import lombok.*;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
@AllArgsConstructor
@RequiredArgsConstructor
public class AnswerId implements Serializable {
    private String question;
    private String answerText;

}
