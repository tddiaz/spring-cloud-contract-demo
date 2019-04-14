package com.github.tddiaz.springcloudcontract.creditscoreservice;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreditScoreMessagePublisher {

    private final Source source;

    public void publish(CreditScoreResponse creditScoreResponse) {
        source.output().send(MessageBuilder.withPayload(creditScoreResponse)
                .setHeader("Content-Type", "application/json")
                .build());
    }
}
