package com.amplifyframework.auth.exceptions;

import com.amplifyframework.auth.AuthException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InvalidStateException.kt */
/* loaded from: classes.dex */
public class InvalidStateException extends AuthException {
    public InvalidStateException() {
        this(null, null, null, 7, null);
    }

    public /* synthetic */ InvalidStateException(String str, String str2, Throwable th, int r4, DefaultConstructorMarker defaultConstructorMarker) {
        this((r4 & 1) != 0 ? "Auth state is an invalid state, cannot process the request." : str, (r4 & 2) != 0 ? "Operation performed is not a valid operation for the current auth state." : str2, (r4 & 4) != 0 ? null : th);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InvalidStateException(String message, String recoverySuggestion, Throwable th) {
        super(message, recoverySuggestion, th);
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(recoverySuggestion, "recoverySuggestion");
    }
}
