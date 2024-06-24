package com.animaconnected.watch;

import android.content.Context;
import com.animaconnected.firebase.Analytics;
import com.animaconnected.logger.MeasurementBackend;
import com.animaconnected.watch.account.strava.StravaAuth;
import com.animaconnected.watch.assets.MitmapBackend;
import com.animaconnected.watch.device.AccountBackend;
import com.animaconnected.watch.device.CrashBackend;
import com.animaconnected.watch.device.GzipBackendImpl;
import com.animaconnected.watch.device.PlatformBackend;
import com.animaconnected.watch.device.SharedPrefsStorageFactory;
import com.animaconnected.watch.device.StringsBackend;
import com.animaconnected.watch.display.WatchFonts;
import com.animaconnected.watch.location.LocationBackend;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WatchManager.kt */
/* loaded from: classes3.dex */
public final class WatchManagerKt {
    public static final WatchManager prepareWatchManager(Context context, WatchDatabase watchDatabase, AlarmDatabase alarmDatabase, LocationBackend locationBackend, Analytics analytics, StringsBackend stringsBackend, MitmapBackend mitmapBackend, String elevationApiKey, AccountBackend accountBackend, PlatformBackend platformBackend, MeasurementBackend measurementBackend, CrashBackend crashBackend, WatchFonts watchFonts, Function0<String> weatherApiKey, StravaAuth auth) throws Exception {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(watchDatabase, "watchDatabase");
        Intrinsics.checkNotNullParameter(alarmDatabase, "alarmDatabase");
        Intrinsics.checkNotNullParameter(locationBackend, "locationBackend");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(stringsBackend, "stringsBackend");
        Intrinsics.checkNotNullParameter(mitmapBackend, "mitmapBackend");
        Intrinsics.checkNotNullParameter(elevationApiKey, "elevationApiKey");
        Intrinsics.checkNotNullParameter(accountBackend, "accountBackend");
        Intrinsics.checkNotNullParameter(platformBackend, "platformBackend");
        Intrinsics.checkNotNullParameter(measurementBackend, "measurementBackend");
        Intrinsics.checkNotNullParameter(crashBackend, "crashBackend");
        Intrinsics.checkNotNullParameter(watchFonts, "watchFonts");
        Intrinsics.checkNotNullParameter(weatherApiKey, "weatherApiKey");
        Intrinsics.checkNotNullParameter(auth, "auth");
        ServiceLocator.INSTANCE.init(new SharedPrefsStorageFactory(context), locationBackend, analytics, stringsBackend, mitmapBackend, accountBackend, new GzipBackendImpl(), platformBackend, measurementBackend, crashBackend, alarmDatabase, watchFonts, weatherApiKey);
        return new WatchManager(watchDatabase, elevationApiKey, auth, false, 8, null);
    }
}
