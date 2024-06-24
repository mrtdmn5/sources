package com.animaconnected.cloud.amazon.lambda;

/* loaded from: classes.dex */
public class RemoteDebugParams {
    private final Boolean force_crashed;
    private final String serial_no;

    public RemoteDebugParams(String str, Boolean bool) {
        this.serial_no = str;
        this.force_crashed = bool;
    }
}
