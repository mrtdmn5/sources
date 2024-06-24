package com.animaconnected.watch;

import com.animaconnected.firebase.Analytics;
import com.animaconnected.logger.MeasurementBackend;
import com.animaconnected.watch.assets.MitmapBackend;
import com.animaconnected.watch.behaviour.temperature.WeatherHttpClient;
import com.animaconnected.watch.device.AccountBackend;
import com.animaconnected.watch.device.CrashBackend;
import com.animaconnected.watch.device.GzipBackend;
import com.animaconnected.watch.device.PlatformBackend;
import com.animaconnected.watch.device.StorageFactory;
import com.animaconnected.watch.device.StringsBackend;
import com.animaconnected.watch.display.WatchFonts;
import com.animaconnected.watch.location.LocationBackend;
import com.animaconnected.watch.location.LocationProvider;
import com.animaconnected.watch.provider.SpotsProvider;
import com.animaconnected.watch.provider.WatchAlarmProvider;
import com.animaconnected.watch.provider.WatchAlarmProviderImpl;
import com.animaconnected.watch.provider.quiethours.QuietHoursProvider;
import com.animaconnected.watch.provider.weather.HistoricalWeatherProvider;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.SupervisorKt;

/* compiled from: ServiceLocator.kt */
/* loaded from: classes3.dex */
public final class ServiceLocator {
    public static final ServiceLocator INSTANCE = new ServiceLocator();
    private static final CoroutineExceptionHandler exceptionHandler;
    private static AccountBackend privateAccountBackend;
    private static WatchAlarmProvider privateAlarmsProvider;
    private static Analytics privateAnalytics;
    private static CrashBackend privateCrashBackend;
    private static GzipBackend privateGzipBackend;
    private static LocationProvider privateLocationProvider;
    private static MeasurementBackend privateMeasurementBackend;
    private static MitmapBackend privateMitmapBackend;
    private static PlatformBackend privatePlatformBackend;
    private static QuietHoursProvider privateQuietHoursProvider;
    private static CoroutineScope privateScope;
    private static SpotsProvider privateSpotsProvider;
    private static StorageFactory privateStorageFactory;
    private static StringsBackend privateStringsBackend;
    private static WatchFonts privateWatchFonts;
    private static HistoricalWeatherProvider privateWeatherProvider;

    static {
        int r0 = CoroutineExceptionHandler.$r8$clinit;
        exceptionHandler = new ServiceLocator$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.Key.$$INSTANCE);
    }

    private ServiceLocator() {
    }

    public final AccountBackend getAccountBackend() {
        AccountBackend accountBackend = privateAccountBackend;
        if (accountBackend != null) {
            return accountBackend;
        }
        Intrinsics.throwUninitializedPropertyAccessException("privateAccountBackend");
        throw null;
    }

    public final WatchAlarmProvider getAlarmsProvider() {
        WatchAlarmProvider watchAlarmProvider = privateAlarmsProvider;
        if (watchAlarmProvider != null) {
            return watchAlarmProvider;
        }
        Intrinsics.throwUninitializedPropertyAccessException("privateAlarmsProvider");
        throw null;
    }

    public final Analytics getAnalytics() {
        Analytics analytics = privateAnalytics;
        if (analytics != null) {
            return analytics;
        }
        Intrinsics.throwUninitializedPropertyAccessException("privateAnalytics");
        throw null;
    }

    public final CrashBackend getCrashBackend() {
        CrashBackend crashBackend = privateCrashBackend;
        if (crashBackend != null) {
            return crashBackend;
        }
        Intrinsics.throwUninitializedPropertyAccessException("privateCrashBackend");
        throw null;
    }

    public final GzipBackend getGzipBackend() {
        GzipBackend gzipBackend = privateGzipBackend;
        if (gzipBackend != null) {
            return gzipBackend;
        }
        Intrinsics.throwUninitializedPropertyAccessException("privateGzipBackend");
        throw null;
    }

    public final LocationProvider getLocationProvider() {
        LocationProvider locationProvider = privateLocationProvider;
        if (locationProvider != null) {
            return locationProvider;
        }
        Intrinsics.throwUninitializedPropertyAccessException("privateLocationProvider");
        throw null;
    }

    public final MitmapBackend getMitmapBackend() {
        MitmapBackend mitmapBackend = privateMitmapBackend;
        if (mitmapBackend != null) {
            return mitmapBackend;
        }
        Intrinsics.throwUninitializedPropertyAccessException("privateMitmapBackend");
        throw null;
    }

    public final PlatformBackend getPlatformBackend() {
        PlatformBackend platformBackend = privatePlatformBackend;
        if (platformBackend != null) {
            return platformBackend;
        }
        Intrinsics.throwUninitializedPropertyAccessException("privatePlatformBackend");
        throw null;
    }

    public final QuietHoursProvider getQuietHoursProvider() {
        QuietHoursProvider quietHoursProvider = privateQuietHoursProvider;
        if (quietHoursProvider != null) {
            return quietHoursProvider;
        }
        Intrinsics.throwUninitializedPropertyAccessException("privateQuietHoursProvider");
        throw null;
    }

    public final CoroutineScope getScope() {
        CoroutineScope coroutineScope = privateScope;
        if (coroutineScope != null) {
            return coroutineScope;
        }
        Intrinsics.throwUninitializedPropertyAccessException("privateScope");
        throw null;
    }

    public final SpotsProvider getSpotsProvider() {
        SpotsProvider spotsProvider = privateSpotsProvider;
        if (spotsProvider != null) {
            return spotsProvider;
        }
        Intrinsics.throwUninitializedPropertyAccessException("privateSpotsProvider");
        throw null;
    }

    public final StorageFactory getStorageFactory() {
        StorageFactory storageFactory = privateStorageFactory;
        if (storageFactory != null) {
            return storageFactory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("privateStorageFactory");
        throw null;
    }

    public final StringsBackend getStringsBackend() {
        StringsBackend stringsBackend = privateStringsBackend;
        if (stringsBackend != null) {
            return stringsBackend;
        }
        Intrinsics.throwUninitializedPropertyAccessException("privateStringsBackend");
        throw null;
    }

    public final WatchFonts getWatchFonts() {
        WatchFonts watchFonts = privateWatchFonts;
        if (watchFonts != null) {
            return watchFonts;
        }
        Intrinsics.throwUninitializedPropertyAccessException("privateWatchFonts");
        throw null;
    }

    public final HistoricalWeatherProvider getWeatherProvider() {
        HistoricalWeatherProvider historicalWeatherProvider = privateWeatherProvider;
        if (historicalWeatherProvider != null) {
            return historicalWeatherProvider;
        }
        Intrinsics.throwUninitializedPropertyAccessException("privateWeatherProvider");
        throw null;
    }

    public final void init(StorageFactory storageFactory, LocationBackend locationBackend, Analytics analytics, StringsBackend stringsBackend, MitmapBackend mitmapBackend, AccountBackend accountBackend, GzipBackend gzipBackend, PlatformBackend platformBackend, MeasurementBackend measurementBackend, CrashBackend crashBackend, AlarmDatabase alarmsDatabase, WatchFonts watchFonts, final Function0<String> weatherApiKey) {
        Intrinsics.checkNotNullParameter(storageFactory, "storageFactory");
        Intrinsics.checkNotNullParameter(locationBackend, "locationBackend");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(stringsBackend, "stringsBackend");
        Intrinsics.checkNotNullParameter(mitmapBackend, "mitmapBackend");
        Intrinsics.checkNotNullParameter(accountBackend, "accountBackend");
        Intrinsics.checkNotNullParameter(gzipBackend, "gzipBackend");
        Intrinsics.checkNotNullParameter(platformBackend, "platformBackend");
        Intrinsics.checkNotNullParameter(measurementBackend, "measurementBackend");
        Intrinsics.checkNotNullParameter(crashBackend, "crashBackend");
        Intrinsics.checkNotNullParameter(alarmsDatabase, "alarmsDatabase");
        Intrinsics.checkNotNullParameter(watchFonts, "watchFonts");
        Intrinsics.checkNotNullParameter(weatherApiKey, "weatherApiKey");
        ServiceLocatorKt.ensureMain();
        privateScope = CoroutineScopeKt.CoroutineScope(DispatchersCommon.watchDispatcher().plus(SupervisorKt.SupervisorJob$default()).plus(exceptionHandler));
        privateStorageFactory = storageFactory;
        privateLocationProvider = new LocationProvider(locationBackend);
        privateSpotsProvider = new SpotsProvider(storageFactory);
        privateAnalytics = analytics;
        privateStringsBackend = stringsBackend;
        privateMitmapBackend = mitmapBackend;
        privateAccountBackend = accountBackend;
        privateGzipBackend = gzipBackend;
        privatePlatformBackend = platformBackend;
        privateMeasurementBackend = measurementBackend;
        privateCrashBackend = crashBackend;
        CoroutineScope coroutineScope = privateScope;
        if (coroutineScope != null) {
            privateAlarmsProvider = new WatchAlarmProviderImpl(coroutineScope, alarmsDatabase);
            privateWeatherProvider = new HistoricalWeatherProvider(new WeatherHttpClient(new Function0<String>() { // from class: com.animaconnected.watch.ServiceLocator$init$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return weatherApiKey.invoke();
                }
            }));
            StorageFactory storageFactory2 = privateStorageFactory;
            if (storageFactory2 != null) {
                privateQuietHoursProvider = new QuietHoursProvider(storageFactory2);
                privateWatchFonts = watchFonts;
                return;
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("privateStorageFactory");
                throw null;
            }
        }
        Intrinsics.throwUninitializedPropertyAccessException("privateScope");
        throw null;
    }

    public final void updateStringBackend(StringsBackend stringsBackend) {
        Intrinsics.checkNotNullParameter(stringsBackend, "stringsBackend");
        ServiceLocatorKt.ensureMain();
        privateStringsBackend = stringsBackend;
    }
}
