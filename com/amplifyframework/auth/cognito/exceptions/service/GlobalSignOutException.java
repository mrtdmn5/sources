package com.amplifyframework.auth.cognito.exceptions.service;

import com.amplifyframework.auth.exceptions.ServiceException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GlobalSignOutException.kt */
/* loaded from: classes.dex */
public class GlobalSignOutException extends ServiceException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GlobalSignOutException(Throwable cause) {
        super("Failed to sign out globally", "See attached exception for more details. GlobalSignOut can be retried using the CognitoIdentityProviderClient accessible from the escape hatch.", cause);
        Intrinsics.checkNotNullParameter(cause, "cause");
    }
}
