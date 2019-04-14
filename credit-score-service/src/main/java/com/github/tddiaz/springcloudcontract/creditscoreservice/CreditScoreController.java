package com.github.tddiaz.springcloudcontract.creditscoreservice;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.github.tddiaz.springcloudcontract.creditscoreservice.CreditScoreResponse.Score;

@RestController
@RequestMapping(value = "/credit-scores")
@RequiredArgsConstructor
public class CreditScoreController {

    private final CreditScoreRepository creditScoreRepository;

    @GetMapping("/{citizenNumber}")
    public CreditScoreResponse getScoreByCitizenNumber(@PathVariable String citizenNumber) {
        return new CreditScoreResponse(creditScoreRepository.findScoreByCitizenNumber(citizenNumber));
    }

    @Component
    public static class CreditScoreRepository {
        public Score findScoreByCitizenNumber(String number) {
            return Score.HIGH;
        }
    }
}
