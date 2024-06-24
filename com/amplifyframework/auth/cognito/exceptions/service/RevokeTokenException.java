package com.amplifyframework.auth.cognito.exceptions.service;

import com.amplifyframework.auth.exceptions.ServiceException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RevokeTokenException.kt */
/* loaded from: classes.dex */
public class RevokeTokenException extends ServiceException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RevokeTokenException(Throwable cause) {
        super("Failed to revoke token", "See attached exception for more details. RevokeToken can be retried using the CognitoIdentityProviderClient accessible from the escape hatch.", cause);
        Intrinsics.checkNotNullParameter(cause, "cause");
    }
}
