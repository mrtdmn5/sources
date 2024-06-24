package com.google.firebase.heartbeatinfo;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public final class AutoValue_HeartBeatResult extends HeartBeatResult {
    public final List<String> usedDates;
    public final String userAgent;

    public AutoValue_HeartBeatResult(String str, ArrayList arrayList) {
        if (str != null) {
            this.userAgent = str;
            this.usedDates = arrayList;
            return;
        }
        throw new NullPointerException("Null userAgent");
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof HeartBeatResult)) {
            return false;
        }
        HeartBeatResult heartBeatResult = (HeartBeatResult) obj;
        if (this.userAgent.equals(heartBeatResult.getUserAgent()) && this.usedDates.equals(heartBeatResult.getUsedDates())) {
            return true;
        }
        return false;
    }

    @Override // com.google.firebase.heartbeatinfo.HeartBeatResult
    public final List<String> getUsedDates() {
        return this.usedDates;
    }

    @Override // com.google.firebase.heartbeatinfo.HeartBeatResult
    public final String getUserAgent() {
        return this.userAgent;
    }

    public final int hashCode() {
        return ((this.userAgent.hashCode() ^ 1000003) * 1000003) ^ this.usedDates.hashCode();
    }

    public final String toString() {
        return "HeartBeatResult{userAgent=" + this.userAgent + ", usedDates=" + this.usedDates + "}";
    }
}
