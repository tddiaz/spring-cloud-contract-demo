package com.github.tddiaz.springcloudcontract.creditscoreservice;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreditScoreResponse {

    private String uuid;
    private Score score;
    
    public enum Score {
        HIGH, LOW
    }
}
