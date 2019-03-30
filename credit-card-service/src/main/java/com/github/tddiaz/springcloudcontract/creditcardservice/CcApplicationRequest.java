package com.github.tddiaz.springcloudcontract.creditcardservice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CcApplicationRequest {
    private String citizenNumber;
    private CreditCardType cardType;

    public boolean isCreditCardTypeGold() {
        return this.cardType == CreditCardType.GOLD;
    }

    public enum CreditCardType {
        GOLD
    }
}