package com.github.tddiaz.springcloudcontract.creditcardservice;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CcApplicationResponse {

    private Status status;

    public static CcApplicationResponse applicationGranted() {
        return new CcApplicationResponse(Status.GRANTED);
    }

    public enum Status {
        GRANTED
    }
}
