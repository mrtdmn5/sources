package com.animaconnected.watch.provider.weather;

import com.animaconnected.firebase.AppEvents;
import com.animaconnected.watch.ServiceLocator;
import com.animaconnected.watch.behaviour.temperature.Current;
import com.animaconnected.watch.behaviour.temperature.Daily;
import com.animaconnected.watch.behaviour.temperature.Hourly;
import com.animaconnected.watch.behaviour.temperature.WeatherHttpClient;
import com.animaconnected.watch.location.LocationProvider;
import com.animaconnected.watch.location.Spot;
import com.animaconnected.watch.storage.WeatherStorage;
import com.animaconnected.watch.utils.DefaultJsonConfigKt;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.datetime.Instant;
import kotlinx.serialization.json.Json;

/* compiled from: HistoricalWeatherProvider.kt */
/* loaded from: classes3.dex */
public final class HistoricalWeatherProvider {
    public static final Companion Companion = new Companion(null);
    private static final Json json = DefaultJsonConfigKt.DefaultConfig(Json.Default);
    private final AppEvents appAnalytics;
    private final WeatherHttpClient httpClient;
    private final LocationProvider locationProvider;
    private final long minFetchInterval;
    private final WeatherStorage storage;
    private final String tag;
    private final TemperatureProvider temperature;

    /* compiled from: HistoricalWeatherProvider.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Json getJson() {
            return HistoricalWeatherProvider.json;
        }

        public final /* synthetic */ <T> String prettyPrint(T t) {
            getJson().getClass();
            Intrinsics.reifiedOperationMarker();
            throw null;
        }

        private Companion() {
        }
    }

    public HistoricalWeatherProvider(WeatherHttpClient httpClient) {
        Intrinsics.checkNotNullParameter(httpClient, "httpClient");
        this.httpClient = httpClient;
        this.tag = "HistoricalWeatherProvider";
        ServiceLocator serviceLocator = ServiceLocator.INSTANCE;
        this.appAnalytics = serviceLocator.getAnalytics().getAppEvents();
        this.locationProvider = serviceLocator.getLocationProvider();
        this.storage = new WeatherStorage();
        this.temperature = new TemperatureProvider();
        int r3 = Duration.$r8$clinit;
        this.minFetchInterval = DurationKt.toDuration(30, DurationUnit.MINUTES);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:1|(2:3|(6:5|6|7|(1:(1:(1:(3:12|13|(3:15|16|(2:18|19)(2:21|22))(2:23|24))(2:25|26))(4:27|28|29|(4:31|(1:33)(1:34)|16|(0)(0))(3:35|(1:37)|(0)(0))))(1:38))(2:51|(2:53|54)(2:55|(1:57)(1:58)))|39|(2:41|42)(3:43|44|(1:46)(3:47|29|(0)(0)))))|61|6|7|(0)(0)|39|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0053, code lost:            r0 = e;     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0180, code lost:            r2 = -2147483648(0xffffffff80000000, float:-0.0);     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0147 A[Catch: Exception -> 0x0053, TryCatch #0 {Exception -> 0x0053, blocks: (B:13:0x003c, B:15:0x0147, B:23:0x0178, B:24:0x017f, B:28:0x004e, B:29:0x00c6, B:33:0x00d7, B:34:0x0101, B:35:0x0123), top: B:7:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0178 A[Catch: Exception -> 0x0053, TryCatch #0 {Exception -> 0x0053, blocks: (B:13:0x003c, B:15:0x0147, B:23:0x0178, B:24:0x017f, B:28:0x004e, B:29:0x00c6, B:33:0x00d7, B:34:0x0101, B:35:0x0123), top: B:7:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0123 A[Catch: Exception -> 0x0053, TryCatch #0 {Exception -> 0x0053, blocks: (B:13:0x003c, B:15:0x0147, B:23:0x0178, B:24:0x017f, B:28:0x004e, B:29:0x00c6, B:33:0x00d7, B:34:0x0101, B:35:0x0123), top: B:7:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00b8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object fetchTemperatureSuspending(kotlin.coroutines.Continuation<? super java.lang.Boolean> r24) {
        /*
            Method dump skipped, instructions count: 493
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.provider.weather.HistoricalWeatherProvider.fetchTemperatureSuspending(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00b2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object fetchWeather(kotlin.coroutines.Continuation<? super kotlin.Unit> r14) {
        /*
            Method dump skipped, instructions count: 319
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.provider.weather.HistoricalWeatherProvider.fetchWeather(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Current getCurrent() {
        return this.storage.getCurrent();
    }

    public final List<Daily> getDaily() {
        return this.storage.getDaily();
    }

    public final List<Hourly> getHourly() {
        return this.storage.getHourly();
    }

    public final Instant getLastFetched() {
        return this.storage.getLastMeasurement();
    }

    public final Spot getLocation() {
        return this.storage.getLocation();
    }

    public final TemperatureProvider getTemperature() {
        return this.temperature;
    }

    /* renamed from: getTimeSinceLastFetch-UwyO8pc, reason: not valid java name */
    public final long m1568getTimeSinceLastFetchUwyO8pc() {
        return this.storage.m1570getTimeSinceLastFetchUwyO8pc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0053 A[Catch: Exception -> 0x00af, TryCatch #0 {Exception -> 0x00af, blocks: (B:14:0x0049, B:16:0x0053, B:19:0x0062, B:21:0x006a, B:23:0x0078, B:25:0x0080, B:27:0x008e, B:29:0x0092, B:31:0x00a9, B:32:0x00ae), top: B:13:0x0049 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0062 A[Catch: Exception -> 0x00af, TryCatch #0 {Exception -> 0x00af, blocks: (B:14:0x0049, B:16:0x0053, B:19:0x0062, B:21:0x006a, B:23:0x0078, B:25:0x0080, B:27:0x008e, B:29:0x0092, B:31:0x00a9, B:32:0x00ae), top: B:13:0x0049 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getLocation(kotlin.coroutines.Continuation<? super com.animaconnected.watch.location.Spot> r9) {
        /*
            Method dump skipped, instructions count: 221
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.watch.provider.weather.HistoricalWeatherProvider.getLocation(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
