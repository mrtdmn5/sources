package com.amplifyframework.statemachine.codegen.data;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: RevokeTokenErrorData.kt */
/* loaded from: classes.dex */
public final class RevokeTokenErrorData {
    private final Exception error;
    private final String refreshToken;

    public RevokeTokenErrorData(String str, Exception error) {
        Intrinsics.checkNotNullParameter(error, "error");
        this.refreshToken = str;
        this.error = error;
    }

    public static /* synthetic */ RevokeTokenErrorData copy$default(RevokeTokenErrorData revokeTokenErrorData, String str, Exception exc, int r3, Object obj) {
        if ((r3 & 1) != 0) {
            str = revokeTokenErrorData.refreshToken;
        }
        if ((r3 & 2) != 0) {
            exc = revokeTokenErrorData.error;
        }
        return revokeTokenErrorData.copy(str, exc);
    }

    public final String component1() {
        return this.refreshToken;
    }

    public final Exception component2() {
        return this.error;
    }

    public final RevokeTokenErrorData copy(String str, Exception error) {
        Intrinsics.checkNotNullParameter(error, "error");
        return new RevokeTokenErrorData(str, error);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RevokeTokenErrorData)) {
            return false;
        }
        RevokeTokenErrorData revokeTokenErrorData = (RevokeTokenErrorData) obj;
        if (Intrinsics.areEqual(this.refreshToken, revokeTokenErrorData.refreshToken) && Intrinsics.areEqual(this.error, revokeTokenErrorData.error)) {
            return true;
        }
        return false;
    }

    public final Exception getError() {
        return this.error;
    }

    public final String getRefreshToken() {
        return this.refreshToken;
    }

    public int hashCode() {
        int hashCode;
        String str = this.refreshToken;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        return this.error.hashCode() + (hashCode * 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("RevokeTokenErrorData(refreshToken=");
        sb.append(this.refreshToken);
        sb.append(", error=");
        return GlobalSignOutErrorData$$ExternalSyntheticOutline0.m(sb, this.error, ')');
    }
}
