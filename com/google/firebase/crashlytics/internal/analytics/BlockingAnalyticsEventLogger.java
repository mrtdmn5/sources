package com.google.firebase.crashlytics.internal.analytics;

import android.os.Bundle;
import android.util.Log;
import io.ktor.http.UrlKt;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public final class BlockingAnalyticsEventLogger implements AnalyticsEventReceiver, AnalyticsEventLogger {
    public final CrashlyticsOriginAnalyticsEventLogger baseAnalyticsEventLogger;
    public CountDownLatch eventLatch;
    public final Object latchLock = new Object();
    public final TimeUnit timeUnit;

    public BlockingAnalyticsEventLogger(CrashlyticsOriginAnalyticsEventLogger crashlyticsOriginAnalyticsEventLogger, TimeUnit timeUnit) {
        this.baseAnalyticsEventLogger = crashlyticsOriginAnalyticsEventLogger;
        this.timeUnit = timeUnit;
    }

    @Override // com.google.firebase.crashlytics.internal.analytics.AnalyticsEventLogger
    public final void logEvent(Bundle bundle) {
        synchronized (this.latchLock) {
            UrlKt urlKt = UrlKt.DEFAULT_LOGGER;
            urlKt.v("Logging event _ae to Firebase Analytics with params " + bundle);
            this.eventLatch = new CountDownLatch(1);
            this.baseAnalyticsEventLogger.logEvent(bundle);
            urlKt.v("Awaiting app exception callback from Analytics...");
            try {
                if (this.eventLatch.await(500, this.timeUnit)) {
                    urlKt.v("App exception callback received from Analytics listener.");
                } else {
                    urlKt.w("Timeout exceeded while awaiting app exception callback from Analytics listener.", null);
                }
            } catch (InterruptedException unused) {
                Log.e("FirebaseCrashlytics", "Interrupted while awaiting app exception callback from Analytics listener.", null);
            }
            this.eventLatch = null;
        }
    }

    @Override // com.google.firebase.crashlytics.internal.analytics.AnalyticsEventReceiver
    public final void onEvent(Bundle bundle, String str) {
        CountDownLatch countDownLatch = this.eventLatch;
        if (countDownLatch != null && "_ae".equals(str)) {
            countDownLatch.countDown();
        }
    }
}
