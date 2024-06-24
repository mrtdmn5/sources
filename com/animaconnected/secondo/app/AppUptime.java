package com.animaconnected.secondo.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.SystemClock;
import com.animaconnected.firebase.AppEvents;
import com.animaconnected.secondo.provider.ProviderFactory;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AppUptime.kt */
/* loaded from: classes.dex */
public final class AppUptime {
    private static final String AppUptimeStorage = "appUptimeStorage";
    private static AppUptime Instance = null;
    private static final String KeyLastPingTimestamp = "lastPingTimestamp";
    private final AppEvents appEvents;
    private final long expectedPingWithinIntervalMs;
    private final SharedPreferences prefs;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: AppUptime.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final AppUptime getInstance(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (AppUptime.Instance == null) {
                AppUptime.Instance = new AppUptime(context);
            }
            AppUptime appUptime = AppUptime.Instance;
            Intrinsics.checkNotNull(appUptime, "null cannot be cast to non-null type com.animaconnected.secondo.app.AppUptime");
            return appUptime;
        }

        private Companion() {
        }
    }

    public AppUptime(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.expectedPingWithinIntervalMs = TimeUnit.MILLISECONDS.convert(2L, TimeUnit.HOURS);
        SharedPreferences sharedPreferences = context.getSharedPreferences(AppUptimeStorage, 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getSharedPreferences(...)");
        this.prefs = sharedPreferences;
        this.appEvents = ProviderFactory.getAppAnalytics();
    }

    private final long getLastPingTimestamp() {
        return this.prefs.getLong(KeyLastPingTimestamp, 0L);
    }

    private final void setLastPingTimestamp(long j) {
        this.prefs.edit().putLong(KeyLastPingTimestamp, j).apply();
    }

    public final void ping() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (getLastPingTimestamp() == 0) {
            setLastPingTimestamp(elapsedRealtime);
            return;
        }
        long lastPingTimestamp = elapsedRealtime - getLastPingTimestamp();
        if (lastPingTimestamp < 0) {
            this.appEvents.pingDeviation(AppEvents.Deviation.Reboot, lastPingTimestamp);
        } else if (lastPingTimestamp > this.expectedPingWithinIntervalMs) {
            this.appEvents.pingDeviation(AppEvents.Deviation.Late, lastPingTimestamp);
        }
        setLastPingTimestamp(elapsedRealtime);
    }
}
