package com.google.firebase.remoteconfig.internal;

import android.content.SharedPreferences;
import java.util.Date;

/* loaded from: classes3.dex */
public final class ConfigMetadataClient {
    public static final Date LAST_FETCH_TIME_NO_FETCH_YET = new Date(-1);
    public static final Date NO_BACKOFF_TIME = new Date(-1);
    public final SharedPreferences frcMetadata;
    public final Object frcInfoLock = new Object();
    public final Object backoffMetadataLock = new Object();

    /* loaded from: classes3.dex */
    public static class BackoffMetadata {
        public final Date backoffEndTime;
        public final int numFailedFetches;

        public BackoffMetadata(int r1, Date date) {
            this.numFailedFetches = r1;
            this.backoffEndTime = date;
        }
    }

    public ConfigMetadataClient(SharedPreferences sharedPreferences) {
        this.frcMetadata = sharedPreferences;
    }

    public final BackoffMetadata getBackoffMetadata() {
        BackoffMetadata backoffMetadata;
        synchronized (this.backoffMetadataLock) {
            backoffMetadata = new BackoffMetadata(this.frcMetadata.getInt("num_failed_fetches", 0), new Date(this.frcMetadata.getLong("backoff_end_time_in_millis", -1L)));
        }
        return backoffMetadata;
    }

    public final void setBackoffMetadata(int r5, Date date) {
        synchronized (this.backoffMetadataLock) {
            this.frcMetadata.edit().putInt("num_failed_fetches", r5).putLong("backoff_end_time_in_millis", date.getTime()).apply();
        }
    }
}
