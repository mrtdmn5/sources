package com.amplifyframework.statemachine.codegen.errors;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CredentialStoreError.kt */
/* loaded from: classes.dex */
public final class CredentialStoreError extends Exception {
    private final Throwable cause;
    private final String message;

    public /* synthetic */ CredentialStoreError(String str, Throwable th, int r3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (r3 & 2) != 0 ? null : th);
    }

    public static /* synthetic */ CredentialStoreError copy$default(CredentialStoreError credentialStoreError, String str, Throwable th, int r3, Object obj) {
        if ((r3 & 1) != 0) {
            str = credentialStoreError.getMessage();
        }
        if ((r3 & 2) != 0) {
            th = credentialStoreError.getCause();
        }
        return credentialStoreError.copy(str, th);
    }

    public final String component1() {
        return getMessage();
    }

    public final Throwable component2() {
        return getCause();
    }

    public final CredentialStoreError copy(String message, Throwable th) {
        Intrinsics.checkNotNullParameter(message, "message");
        return new CredentialStoreError(message, th);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CredentialStoreError)) {
            return false;
        }
        CredentialStoreError credentialStoreError = (CredentialStoreError) obj;
        if (Intrinsics.areEqual(getMessage(), credentialStoreError.getMessage()) && Intrinsics.areEqual(getCause(), credentialStoreError.getCause())) {
            return true;
        }
        return false;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.cause;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.message;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = getMessage().hashCode() * 31;
        if (getCause() == null) {
            hashCode = 0;
        } else {
            hashCode = getCause().hashCode();
        }
        return hashCode2 + hashCode;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "CredentialStoreError(message=" + getMessage() + ", cause=" + getCause() + ')';
    }

    public CredentialStoreError(String message, Throwable th) {
        Intrinsics.checkNotNullParameter(message, "message");
        this.message = message;
        this.cause = th;
    }
}
