package com.amplifyframework.auth.cognito.exceptions.service;

import com.amplifyframework.auth.exceptions.ServiceException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UserCancelledException.kt */
/* loaded from: classes.dex */
public class UserCancelledException extends ServiceException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserCancelledException(String message, String recoverySuggestion) {
        super(message, recoverySuggestion, null, 4, null);
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(recoverySuggestion, "recoverySuggestion");
    }
}
