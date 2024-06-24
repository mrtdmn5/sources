package com.amplifyframework.statemachine.codegen.data;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: GlobalSignOutErrorData.kt */
/* loaded from: classes.dex */
public final class GlobalSignOutErrorData {
    private final String accessToken;
    private final Exception error;

    public GlobalSignOutErrorData(String str, Exception error) {
        Intrinsics.checkNotNullParameter(error, "error");
        this.accessToken = str;
        this.error = error;
    }

    public static /* synthetic */ GlobalSignOutErrorData copy$default(GlobalSignOutErrorData globalSignOutErrorData, String str, Exception exc, int r3, Object obj) {
        if ((r3 & 1) != 0) {
            str = globalSignOutErrorData.accessToken;
        }
        if ((r3 & 2) != 0) {
            exc = globalSignOutErrorData.error;
        }
        return globalSignOutErrorData.copy(str, exc);
    }

    public final String component1() {
        return this.accessToken;
    }

    public final Exception component2() {
        return this.error;
    }

    public final GlobalSignOutErrorData copy(String str, Exception error) {
        Intrinsics.checkNotNullParameter(error, "error");
        return new GlobalSignOutErrorData(str, error);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GlobalSignOutErrorData)) {
            return false;
        }
        GlobalSignOutErrorData globalSignOutErrorData = (GlobalSignOutErrorData) obj;
        if (Intrinsics.areEqual(this.accessToken, globalSignOutErrorData.accessToken) && Intrinsics.areEqual(this.error, globalSignOutErrorData.error)) {
            return true;
        }
        return false;
    }

    public final String getAccessToken() {
        return this.accessToken;
    }

    public final Exception getError() {
        return this.error;
    }

    public int hashCode() {
        int hashCode;
        String str = this.accessToken;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        return this.error.hashCode() + (hashCode * 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GlobalSignOutErrorData(accessToken=");
        sb.append(this.accessToken);
        sb.append(", error=");
        return GlobalSignOutErrorData$$ExternalSyntheticOutline0.m(sb, this.error, ')');
    }
}
