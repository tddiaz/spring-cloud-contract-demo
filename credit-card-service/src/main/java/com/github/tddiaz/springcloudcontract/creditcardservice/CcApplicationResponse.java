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

    public static CcApplicationResponse applicationDenied() {
        return new CcApplicationResponse(Status.DENIED);
    }

    public enum Status {
        GRANTED, DENIED
    }
}
