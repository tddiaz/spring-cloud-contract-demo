package com.github.tddiaz.springcloudcontract.creditcardservice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CreditScoreResponse {

    private String uuid;
    private Score score;

    public boolean isScoreHigh() {
        return this.score == Score.HIGH;
    }

    public enum Score {
        HIGH, LOW
    }
}
