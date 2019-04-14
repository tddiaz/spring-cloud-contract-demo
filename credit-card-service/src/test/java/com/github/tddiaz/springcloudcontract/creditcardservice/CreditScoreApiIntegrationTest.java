package com.github.tddiaz.springcloudcontract.creditcardservice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties.StubsMode.LOCAL;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
// will boot WireMock and import stubs
@AutoConfigureStubRunner(ids =
		"com.github.tddiaz.springcloudcontract" + // group id
		":credit-score-service" + // artifact id
		":+" + // latest version will always be downloaded
		":stubs" + // classifier
		":8080" // WireMock port//
, stubsMode = LOCAL)
public class CreditScoreApiIntegrationTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void shouldGrantApplicationWhenScoreIsHighAndCreditCardTypeIsGold() throws Exception {
		mockMvc.perform(post("/credit-card-applications")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{" +
							"\"citizenNumber\":\"12345\"," +
							"\"cardType\":\"GOLD\"" +
						 "}"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content()
						.json("{" +
									"\"status\":\"GRANTED\"" +
								"}"))
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
	}

	@Test
	public void shouldDenyApplicationWhenScoreIsLow() throws Exception {
		mockMvc.perform(post("/credit-card-applications")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{" +
						"\"citizenNumber\":\"54321\"," +
						"\"cardType\":\"GOLD\"" +
						"}"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content()
						.json("{" +
								"\"status\":\"DENIED\"" +
								"}"))
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
	}

}
