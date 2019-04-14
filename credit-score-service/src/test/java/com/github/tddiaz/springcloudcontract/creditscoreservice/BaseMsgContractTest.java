package com.github.tddiaz.springcloudcontract.creditscoreservice;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.verifier.messaging.boot.AutoConfigureMessageVerifier;
import org.springframework.test.context.junit4.SpringRunner;

import static com.github.tddiaz.springcloudcontract.creditscoreservice.CreditScoreResponse.Score;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@AutoConfigureMessageVerifier
public class BaseMsgContractTest {

    @Autowired
    private CreditScoreMessagePublisher creditScoreMessagePublisher;

    public void executePublish() {
        creditScoreMessagePublisher.publish(new CreditScoreResponse("9e4c2069-9643-4884-829c-abf0fbca5fea", Score.HIGH));
    }
}
