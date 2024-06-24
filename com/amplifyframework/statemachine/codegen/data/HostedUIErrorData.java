package com.amplifyframework.statemachine.codegen.data;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: HostedUIErrorData.kt */
/* loaded from: classes.dex */
public final class HostedUIErrorData {
    private final Exception error;
    private final String url;

    public HostedUIErrorData(String str, Exception error) {
        Intrinsics.checkNotNullParameter(error, "error");
        this.url = str;
        this.error = error;
    }

    public static /* synthetic */ HostedUIErrorData copy$default(HostedUIErrorData hostedUIErrorData, String str, Exception exc, int r3, Object obj) {
        if ((r3 & 1) != 0) {
            str = hostedUIErrorData.url;
        }
        if ((r3 & 2) != 0) {
            exc = hostedUIErrorData.error;
        }
        return hostedUIErrorData.copy(str, exc);
    }

    public final String component1() {
        return this.url;
    }

    public final Exception component2() {
        return this.error;
    }

    public final HostedUIErrorData copy(String str, Exception error) {
        Intrinsics.checkNotNullParameter(error, "error");
        return new HostedUIErrorData(str, error);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HostedUIErrorData)) {
            return false;
        }
        HostedUIErrorData hostedUIErrorData = (HostedUIErrorData) obj;
        if (Intrinsics.areEqual(this.url, hostedUIErrorData.url) && Intrinsics.areEqual(this.error, hostedUIErrorData.error)) {
            return true;
        }
        return false;
    }

    public final Exception getError() {
        return this.error;
    }

    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        int hashCode;
        String str = this.url;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        return this.error.hashCode() + (hashCode * 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("HostedUIErrorData(url=");
        sb.append(this.url);
        sb.append(", error=");
        return GlobalSignOutErrorData$$ExternalSyntheticOutline0.m(sb, this.error, ')');
    }
}
