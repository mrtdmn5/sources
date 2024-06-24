package com.animaconnected.cloud.amazon.lambda;

/* loaded from: classes.dex */
public class IftttParams {
    private final String action;
    private final Double latitude;
    private final Double longitude;
    private final String type;

    public IftttParams(String str, String str2, Double d, Double d2) {
        this.action = str;
        this.type = str2;
        this.longitude = d;
        this.latitude = d2;
    }
}
