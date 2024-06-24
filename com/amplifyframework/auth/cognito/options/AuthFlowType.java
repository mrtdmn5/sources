package com.amplifyframework.auth.cognito.options;

/* loaded from: classes.dex */
public enum AuthFlowType {
    USER_SRP_AUTH("USER_SRP_AUTH"),
    CUSTOM_AUTH("CUSTOM_AUTH"),
    CUSTOM_AUTH_WITH_SRP("CUSTOM_AUTH_WITH_SRP"),
    CUSTOM_AUTH_WITHOUT_SRP("CUSTOM_AUTH_WITHOUT_SRP"),
    USER_PASSWORD_AUTH("USER_PASSWORD_AUTH");

    private String value;

    AuthFlowType(String str) {
        this.value = str;
    }
}
