package com.amplifyframework.auth.exceptions;

import com.amplifyframework.auth.AuthException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UnknownException.kt */
/* loaded from: classes.dex */
public class UnknownException extends AuthException {
    public static final Companion Companion = new Companion(null);
    public static final String RECOVERY_SUGGESTION_WITHOUT_THROWABLE = "Sorry, we don't have a suggested fix for this error yet.";
    public static final String RECOVERY_SUGGESTION_WITH_THROWABLE = "See the attached exception for more details";

    /* compiled from: UnknownException.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public UnknownException() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public /* synthetic */ UnknownException(String str, Throwable th, int r3, DefaultConstructorMarker defaultConstructorMarker) {
        this((r3 & 1) != 0 ? "An unclassified error prevented this operation." : str, (r3 & 2) != 0 ? null : th);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UnknownException(String message, Throwable th) {
        super(message, th == null ? RECOVERY_SUGGESTION_WITH_THROWABLE : "Sorry, we don't have a suggested fix for this error yet.", th);
        Intrinsics.checkNotNullParameter(message, "message");
    }
}
