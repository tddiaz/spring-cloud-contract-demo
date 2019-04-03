package com.github.tddiaz.springcloudcontract.creditcardservice;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

import static com.github.tddiaz.springcloudcontract.creditcardservice.CreditScoreResponse.Score;

@Component
public class CreditScoreRepository {
    public Map<String, Score> creditScores = new HashMap<>();

    public void save(CreditScoreResponse creditScoreResponse) {
        creditScores.put(creditScoreResponse.getUuid(), creditScoreResponse.getScore());
    }

    public Score findById(String uuid) {
        return creditScores.get(uuid);
    }
}
