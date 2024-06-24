package com.google.firebase;

/* loaded from: classes3.dex */
public final class AutoValue_StartupTime extends StartupTime {
    public final long elapsedRealtime;
    public final long epochMillis;
    public final long uptimeMillis;

    public AutoValue_StartupTime(long j, long j2, long j3) {
        this.epochMillis = j;
        this.elapsedRealtime = j2;
        this.uptimeMillis = j3;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof StartupTime)) {
            return false;
        }
        StartupTime startupTime = (StartupTime) obj;
        if (this.epochMillis == startupTime.getEpochMillis() && this.elapsedRealtime == startupTime.getElapsedRealtime() && this.uptimeMillis == startupTime.getUptimeMillis()) {
            return true;
        }
        return false;
    }

    @Override // com.google.firebase.StartupTime
    public final long getElapsedRealtime() {
        return this.elapsedRealtime;
    }

    @Override // com.google.firebase.StartupTime
    public final long getEpochMillis() {
        return this.epochMillis;
    }

    @Override // com.google.firebase.StartupTime
    public final long getUptimeMillis() {
        return this.uptimeMillis;
    }

    public final int hashCode() {
        long j = this.epochMillis;
        long j2 = this.elapsedRealtime;
        int r0 = (((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003;
        long j3 = this.uptimeMillis;
        return r0 ^ ((int) ((j3 >>> 32) ^ j3));
    }

    public final String toString() {
        return "StartupTime{epochMillis=" + this.epochMillis + ", elapsedRealtime=" + this.elapsedRealtime + ", uptimeMillis=" + this.uptimeMillis + "}";
    }
}
