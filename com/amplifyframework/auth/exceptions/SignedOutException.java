package com.amplifyframework.auth.exceptions;

import com.amplifyframework.auth.AuthException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SignedOutException.kt */
/* loaded from: classes.dex */
public class SignedOutException extends AuthException {
    public static final Companion Companion = new Companion(null);
    public static final String RECOVERY_SUGGESTION_GUEST_ACCESS_DISABLED = "Please sign in and reattempt the operation.";
    public static final String RECOVERY_SUGGESTION_GUEST_ACCESS_POSSIBLE = "If you have guest access enabled, please check that your device is online and try again. Otherwise if guest access is not enabled, you'll need to sign in and try again.";

    /* compiled from: SignedOutException.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public SignedOutException() {
        this(null, null, null, 7, null);
    }

    public /* synthetic */ SignedOutException(String str, String str2, Throwable th, int r4, DefaultConstructorMarker defaultConstructorMarker) {
        this((r4 & 1) != 0 ? "You are currently signed out." : str, (r4 & 2) != 0 ? RECOVERY_SUGGESTION_GUEST_ACCESS_DISABLED : str2, (r4 & 4) != 0 ? null : th);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SignedOutException(String message, String recoverySuggestion, Throwable th) {
        super(message, recoverySuggestion, th);
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(recoverySuggestion, "recoverySuggestion");
    }
}
