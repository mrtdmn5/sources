package com.google.android.datatransport.runtime.backends;

import com.google.android.datatransport.runtime.backends.BackendResponse;

/* loaded from: classes3.dex */
public final class AutoValue_BackendResponse extends BackendResponse {
    public final long nextRequestWaitMillis;
    public final BackendResponse.Status status;

    public AutoValue_BackendResponse(BackendResponse.Status status, long j) {
        if (status != null) {
            this.status = status;
            this.nextRequestWaitMillis = j;
            return;
        }
        throw new NullPointerException("Null status");
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BackendResponse)) {
            return false;
        }
        BackendResponse backendResponse = (BackendResponse) obj;
        if (this.status.equals(backendResponse.getStatus()) && this.nextRequestWaitMillis == backendResponse.getNextRequestWaitMillis()) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.datatransport.runtime.backends.BackendResponse
    public final long getNextRequestWaitMillis() {
        return this.nextRequestWaitMillis;
    }

    @Override // com.google.android.datatransport.runtime.backends.BackendResponse
    public final BackendResponse.Status getStatus() {
        return this.status;
    }

    public final int hashCode() {
        int hashCode = (this.status.hashCode() ^ 1000003) * 1000003;
        long j = this.nextRequestWaitMillis;
        return hashCode ^ ((int) ((j >>> 32) ^ j));
    }

    public final String toString() {
        return "BackendResponse{status=" + this.status + ", nextRequestWaitMillis=" + this.nextRequestWaitMillis + "}";
    }
}
