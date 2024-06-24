package com.amplifyframework.auth.cognito.result;

import com.amplifyframework.statemachine.codegen.data.HostedUIErrorData;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AWSCognitoAuthSignOutResult.kt */
/* loaded from: classes.dex */
public final class HostedUIError {
    private final Exception exception;
    private final String url;

    public HostedUIError(HostedUIErrorData hostedUIErrorData) {
        Intrinsics.checkNotNullParameter(hostedUIErrorData, "hostedUIErrorData");
        this.url = hostedUIErrorData.getUrl();
        this.exception = hostedUIErrorData.getError();
    }

    public final Exception getException() {
        return this.exception;
    }

    public final String getUrl() {
        return this.url;
    }
}
