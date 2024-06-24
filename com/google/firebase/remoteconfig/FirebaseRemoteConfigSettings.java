package com.google.firebase.remoteconfig;

import com.google.firebase.remoteconfig.internal.ConfigFetchHandler;

/* loaded from: classes3.dex */
public final class FirebaseRemoteConfigSettings {
    public final long fetchTimeoutInSeconds;
    public final long minimumFetchInterval;

    /* loaded from: classes3.dex */
    public static class Builder {
        public long fetchTimeoutInSeconds = 60;
        public long minimumFetchInterval = ConfigFetchHandler.DEFAULT_MINIMUM_FETCH_INTERVAL_IN_SECONDS;

        public final void setMinimumFetchIntervalInSeconds(long j) {
            if (j >= 0) {
                this.minimumFetchInterval = j;
                return;
            }
            throw new IllegalArgumentException("Minimum interval between fetches has to be a non-negative number. " + j + " is an invalid argument");
        }
    }

    public FirebaseRemoteConfigSettings(Builder builder) {
        this.fetchTimeoutInSeconds = builder.fetchTimeoutInSeconds;
        this.minimumFetchInterval = builder.minimumFetchInterval;
    }
}
