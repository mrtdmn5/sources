package com.amplifyframework.auth.cognito.exceptions.invalidstate;

import com.amplifyframework.auth.exceptions.InvalidStateException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SignedInException.kt */
/* loaded from: classes.dex */
public class SignedInException extends InvalidStateException {
    public SignedInException() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public /* synthetic */ SignedInException(String str, String str2, int r3, DefaultConstructorMarker defaultConstructorMarker) {
        this((r3 & 1) != 0 ? "There is already a user signed in." : str, (r3 & 2) != 0 ? "Sign out the user first before signing in again." : str2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SignedInException(String message, String recoverySuggestion) {
        super(message, recoverySuggestion, null, 4, null);
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(recoverySuggestion, "recoverySuggestion");
    }
}
