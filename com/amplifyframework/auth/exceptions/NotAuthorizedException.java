package com.amplifyframework.auth.exceptions;

import com.amplifyframework.auth.AuthException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NotAuthorizedException.kt */
/* loaded from: classes.dex */
public class NotAuthorizedException extends AuthException {
    public NotAuthorizedException() {
        this(null, null, null, 7, null);
    }

    public /* synthetic */ NotAuthorizedException(String str, String str2, Throwable th, int r4, DefaultConstructorMarker defaultConstructorMarker) {
        this((r4 & 1) != 0 ? "Failed since user is not authorized." : str, (r4 & 2) != 0 ? "Check whether the given values are correct and the user is authorized to perform the operation." : str2, (r4 & 4) != 0 ? null : th);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NotAuthorizedException(String message, String recoverySuggestion, Throwable th) {
        super(message, recoverySuggestion, th);
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(recoverySuggestion, "recoverySuggestion");
    }
}
