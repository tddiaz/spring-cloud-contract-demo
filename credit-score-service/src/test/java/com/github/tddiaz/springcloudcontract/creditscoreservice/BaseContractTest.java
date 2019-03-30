package com.github.tddiaz.springcloudcontract.creditscoreservice;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;

public class BaseContractTest {

    @Before
    public void setup() {
        //setup a mock mvc environment to a specific controller
        //
        RestAssuredMockMvc.standaloneSetup(new CreditScoreController());
    }
}
