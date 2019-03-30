package com.github.tddiaz.springcloudcontract.creditcardservice;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = "/credit-card-applications")
@RequiredArgsConstructor
public class CreditCardApplicationController {

    private final RestTemplate restTemplate;

    @PostMapping
    public CcApplicationResponse create(@RequestBody CcApplicationRequest request) {
        CreditScoreResponse creditScoreResponse = restTemplate
                .getForObject("http://localhost:8080/credit-scores/" + request.getCitizenNumber(), CreditScoreResponse.class);

        if (creditScoreResponse.isScoreHigh() && request.isCreditCardTypeGold()) {
            return CcApplicationResponse.applicationGranted();
        }

        throw new RuntimeException("Credit card type not yet implemented");
    }
}
