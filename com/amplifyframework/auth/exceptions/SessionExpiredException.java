package com.amplifyframework.auth.exceptions;

import com.amplifyframework.auth.AuthException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SessionExpiredException.kt */
/* loaded from: classes.dex */
public class SessionExpiredException extends AuthException {
    public SessionExpiredException() {
        this(null, null, null, 7, null);
    }

    public /* synthetic */ SessionExpiredException(String str, String str2, Throwable th, int r4, DefaultConstructorMarker defaultConstructorMarker) {
        this((r4 & 1) != 0 ? "Your session has expired." : str, (r4 & 2) != 0 ? SignedOutException.RECOVERY_SUGGESTION_GUEST_ACCESS_DISABLED : str2, (r4 & 4) != 0 ? null : th);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SessionExpiredException(String message, String recoverySuggestion, Throwable th) {
        super(message, recoverySuggestion, th);
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(recoverySuggestion, "recoverySuggestion");
    }
}
