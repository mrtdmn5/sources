package com.amplifyframework.statemachine.codegen.errors;

import com.amplifyframework.statemachine.codegen.data.AmplifyCredential;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SessionError.kt */
/* loaded from: classes.dex */
public final class SessionError extends Exception {
    private final AmplifyCredential amplifyCredential;
    private final Exception exception;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SessionError(Exception exception, AmplifyCredential amplifyCredential) {
        super(exception.getMessage(), exception.getCause());
        Intrinsics.checkNotNullParameter(exception, "exception");
        Intrinsics.checkNotNullParameter(amplifyCredential, "amplifyCredential");
        this.exception = exception;
        this.amplifyCredential = amplifyCredential;
    }

    public static /* synthetic */ SessionError copy$default(SessionError sessionError, Exception exc, AmplifyCredential amplifyCredential, int r3, Object obj) {
        if ((r3 & 1) != 0) {
            exc = sessionError.exception;
        }
        if ((r3 & 2) != 0) {
            amplifyCredential = sessionError.amplifyCredential;
        }
        return sessionError.copy(exc, amplifyCredential);
    }

    public final Exception component1() {
        return this.exception;
    }

    public final AmplifyCredential component2() {
        return this.amplifyCredential;
    }

    public final SessionError copy(Exception exception, AmplifyCredential amplifyCredential) {
        Intrinsics.checkNotNullParameter(exception, "exception");
        Intrinsics.checkNotNullParameter(amplifyCredential, "amplifyCredential");
        return new SessionError(exception, amplifyCredential);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SessionError)) {
            return false;
        }
        SessionError sessionError = (SessionError) obj;
        if (Intrinsics.areEqual(this.exception, sessionError.exception) && Intrinsics.areEqual(this.amplifyCredential, sessionError.amplifyCredential)) {
            return true;
        }
        return false;
    }

    public final AmplifyCredential getAmplifyCredential() {
        return this.amplifyCredential;
    }

    public final Exception getException() {
        return this.exception;
    }

    public int hashCode() {
        return this.amplifyCredential.hashCode() + (this.exception.hashCode() * 31);
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "SessionError(exception=" + this.exception + ", amplifyCredential=" + this.amplifyCredential + ')';
    }
}
