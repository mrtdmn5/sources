package com.amplifyframework.auth.cognito.result;

import com.amplifyframework.auth.cognito.exceptions.service.GlobalSignOutException;
import com.amplifyframework.statemachine.codegen.data.GlobalSignOutErrorData;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AWSCognitoAuthSignOutResult.kt */
/* loaded from: classes.dex */
public final class GlobalSignOutError {
    private final String accessToken;
    private final GlobalSignOutException exception;

    public GlobalSignOutError(GlobalSignOutErrorData globalSignOutErrorData) {
        Intrinsics.checkNotNullParameter(globalSignOutErrorData, "globalSignOutErrorData");
        this.accessToken = globalSignOutErrorData.getAccessToken();
        this.exception = new GlobalSignOutException(globalSignOutErrorData.getError());
    }

    public final String getAccessToken() {
        return this.accessToken;
    }

    public final GlobalSignOutException getException() {
        return this.exception;
    }
}
