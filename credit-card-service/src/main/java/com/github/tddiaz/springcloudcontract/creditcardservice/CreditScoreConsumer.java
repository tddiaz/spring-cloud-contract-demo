package com.github.tddiaz.springcloudcontract.creditcardservice;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class CreditScoreConsumer {

    private final CreditScoreRepository creditScoreRepository;

    @StreamListener(Sink.INPUT)
    public void consume(CreditScoreResponse response) {
        creditScoreRepository.save(response);
    }
}
