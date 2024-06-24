package com.google.firebase.installations.remote;

import com.google.android.gms.measurement.internal.zzcb;
import com.google.firebase.installations.Utils;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public final class RequestLimiter {
    public static final long MAXIMUM_BACKOFF_DURATION_FOR_CONFIGURATION_ERRORS = TimeUnit.HOURS.toMillis(24);
    public static final long MAXIMUM_BACKOFF_DURATION_FOR_SERVER_ERRORS = TimeUnit.MINUTES.toMillis(30);
    public int attemptCount;
    public long nextRequestTime;
    public final Utils utils;

    public RequestLimiter() {
        if (zzcb.singleton == null) {
            Pattern pattern = Utils.API_KEY_FORMAT;
            zzcb.singleton = new zzcb();
        }
        zzcb zzcbVar = zzcb.singleton;
        if (Utils.singleton == null) {
            Utils.singleton = new Utils(zzcbVar);
        }
        this.utils = Utils.singleton;
    }

    public final synchronized void setNextRequestTime(int r7) {
        boolean z;
        long min;
        boolean z2 = false;
        if ((r7 < 200 || r7 >= 300) && r7 != 401 && r7 != 404) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            synchronized (this) {
                this.attemptCount = 0;
            }
            return;
        }
        this.attemptCount++;
        synchronized (this) {
            if (r7 == 429 || (r7 >= 500 && r7 < 600)) {
                z2 = true;
            }
            if (!z2) {
                min = MAXIMUM_BACKOFF_DURATION_FOR_CONFIGURATION_ERRORS;
            } else {
                double pow = Math.pow(2.0d, this.attemptCount);
                this.utils.getClass();
                min = (long) Math.min(pow + ((long) (Math.random() * 1000.0d)), MAXIMUM_BACKOFF_DURATION_FOR_SERVER_ERRORS);
            }
            this.utils.clock.getClass();
            this.nextRequestTime = System.currentTimeMillis() + min;
        }
        return;
    }
}
