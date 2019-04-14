package com.github.tddiaz.springcloudcontract.creditscoreservice;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.mockito.Mockito;

import static com.github.tddiaz.springcloudcontract.creditscoreservice.CreditScoreController.CreditScoreRepository;
import static com.github.tddiaz.springcloudcontract.creditscoreservice.CreditScoreResponse.Score.HIGH;
import static com.github.tddiaz.springcloudcontract.creditscoreservice.CreditScoreResponse.Score.LOW;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

public class BaseHttpContractTest {

    @Before
    public void setup() {
        CreditScoreRepository repository = Mockito.mock(CreditScoreRepository.class);
        when(repository.findScoreByCitizenNumber(eq("12345"))).thenReturn(HIGH);
        when(repository.findScoreByCitizenNumber(eq("54321"))).thenReturn(LOW);
        //setup a mock mvc environment to a specific controller
        RestAssuredMockMvc.standaloneSetup(new CreditScoreController(repository));
    }
}
