package com.google.firebase.crashlytics.internal.settings;

/* loaded from: classes3.dex */
public final class Settings {
    public final long expiresAtMillis;
    public final FeatureFlagData featureFlagData;
    public final double onDemandBackoffBase;
    public final int onDemandBackoffStepDurationSeconds;
    public final double onDemandUploadRatePerMinute;
    public final SessionData sessionData;

    /* loaded from: classes3.dex */
    public static class FeatureFlagData {
        public final boolean collectAnrs;
        public final boolean collectBuildIds;
        public final boolean collectReports;

        public FeatureFlagData(boolean z, boolean z2, boolean z3) {
            this.collectReports = z;
            this.collectAnrs = z2;
            this.collectBuildIds = z3;
        }
    }

    /* loaded from: classes3.dex */
    public static class SessionData {
        public final int maxCustomExceptionEvents;

        public SessionData(int r1) {
            this.maxCustomExceptionEvents = r1;
        }
    }

    public Settings(long j, SessionData sessionData, FeatureFlagData featureFlagData, double d, double d2, int r9) {
        this.expiresAtMillis = j;
        this.sessionData = sessionData;
        this.featureFlagData = featureFlagData;
        this.onDemandUploadRatePerMinute = d;
        this.onDemandBackoffBase = d2;
        this.onDemandBackoffStepDurationSeconds = r9;
    }
}
