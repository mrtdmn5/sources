package com.amplifyframework.auth.cognito.result;

import com.amplifyframework.auth.cognito.exceptions.service.RevokeTokenException;
import com.amplifyframework.statemachine.codegen.data.RevokeTokenErrorData;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AWSCognitoAuthSignOutResult.kt */
/* loaded from: classes.dex */
public final class RevokeTokenError {
    private final RevokeTokenException exception;
    private final String refreshToken;

    public RevokeTokenError(RevokeTokenErrorData revokeTokenErrorData) {
        Intrinsics.checkNotNullParameter(revokeTokenErrorData, "revokeTokenErrorData");
        this.refreshToken = revokeTokenErrorData.getRefreshToken();
        this.exception = new RevokeTokenException(revokeTokenErrorData.getError());
    }

    public final RevokeTokenException getException() {
        return this.exception;
    }

    public final String getRefreshToken() {
        return this.refreshToken;
    }
}
