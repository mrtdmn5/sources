package com.google.android.datatransport.cct.internal;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public final class AutoValue_BatchedLogRequest extends BatchedLogRequest {
    public final List<LogRequest> logRequests;

    public AutoValue_BatchedLogRequest(ArrayList arrayList) {
        this.logRequests = arrayList;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof BatchedLogRequest) {
            return this.logRequests.equals(((BatchedLogRequest) obj).getLogRequests());
        }
        return false;
    }

    @Override // com.google.android.datatransport.cct.internal.BatchedLogRequest
    public final List<LogRequest> getLogRequests() {
        return this.logRequests;
    }

    public final int hashCode() {
        return this.logRequests.hashCode() ^ 1000003;
    }

    public final String toString() {
        return "BatchedLogRequest{logRequests=" + this.logRequests + "}";
    }
}
