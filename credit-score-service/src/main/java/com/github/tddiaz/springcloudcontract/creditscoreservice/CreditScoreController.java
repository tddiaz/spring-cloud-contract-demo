package com.github.tddiaz.springcloudcontract.creditscoreservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/credit-scores")
public class CreditScoreController {

    @GetMapping("/{citizenNumber}")
    public CreditScoreResponse getScoreByCitizenNumber(@PathVariable String citizenNumber) {
        return CreditScoreResponse.high();
    }
}
