package com.google.android.datatransport.cct.internal;

/* loaded from: classes3.dex */
public final class AutoValue_LogResponse extends LogResponse {
    public final long nextRequestWaitMillis;

    public AutoValue_LogResponse(long j) {
        this.nextRequestWaitMillis = j;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof LogResponse) && this.nextRequestWaitMillis == ((LogResponse) obj).getNextRequestWaitMillis()) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.datatransport.cct.internal.LogResponse
    public final long getNextRequestWaitMillis() {
        return this.nextRequestWaitMillis;
    }

    public final int hashCode() {
        long j = this.nextRequestWaitMillis;
        return ((int) ((j >>> 32) ^ j)) ^ 1000003;
    }

    public final String toString() {
        return "LogResponse{nextRequestWaitMillis=" + this.nextRequestWaitMillis + "}";
    }
}
