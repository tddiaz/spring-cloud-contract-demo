package com.github.tddiaz.springcloudcontract.creditcardservice;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.StubTrigger;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.test.context.junit4.SpringRunner;

import static com.github.tddiaz.springcloudcontract.creditcardservice.CreditScoreResponse.Score;
import static org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties.StubsMode.LOCAL;

@RunWith(SpringRunner.class)
@SpringBootTest
// will boot WireMock and import stubs
@AutoConfigureStubRunner(ids =
		"com.github.tddiaz.springcloudcontract" + // group id
		":credit-score-service" + // artifact id
		":+" + // latest version will always be downloaded
		":stubs"
, stubsMode = LOCAL)
public class CreditScoreMessagingIntegrationTest {

	@Autowired
	private StubTrigger stubTrigger;

	@Autowired
	private CreditScoreRepository creditScoreRepository;

	@Test
	public void givenMessage_whenConsume_shouldSaveCreditScoreResponseMsg() {

		// given
		String uuid = "9e4c2069-9643-4884-829c-abf0fbca5fea";

		//when
		stubTrigger.trigger("credit_score_of_high_contract");

		//then
		Assertions.assertThat(creditScoreRepository.findById(uuid)).isEqualTo(Score.HIGH);
	}

}
