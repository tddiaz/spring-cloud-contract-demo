package com.github.tddiaz.springcloudcontract.creditscoreservice;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreditScoreResponse {

    private Score score;

    public static CreditScoreResponse high() {
        return new CreditScoreResponse(Score.HIGH);
    }

    public enum Score {
        HIGH
    }
}
