package com.amplifyframework.auth.cognito.asf;

import android.content.Context;
import android.view.Display;
import android.view.WindowManager;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import kotlin.Pair;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeviceDataCollector.kt */
/* loaded from: classes.dex */
public final class DeviceDataCollector implements DataCollector {
    public static final Companion Companion = new Companion(null);
    public static final String DEVICE_AGENT = "DeviceId";
    public static final String DEVICE_HEIGHT = "ScreenHeightPixels";
    public static final String DEVICE_LANGUAGE = "DeviceLanguage";
    public static final String DEVICE_WIDTH = "ScreenWidthPixels";
    public static final String PLATFORM_KEY = "Platform";
    private static final String PLATFORM_VALUE = "ANDROID";
    public static final String THIRD_PARTY_DEVICE_AGENT = "ThirdPartyDeviceId";
    public static final String TIMEZONE = "ClientTimezone";
    private final String deviceId;
    private final String language;
    private final String thirdPartyDeviceAgent;
    private final TimeZone timezone;

    /* compiled from: DeviceDataCollector.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public DeviceDataCollector(String deviceId) {
        Intrinsics.checkNotNullParameter(deviceId, "deviceId");
        this.deviceId = deviceId;
        this.thirdPartyDeviceAgent = "android_id";
        String locale = Locale.getDefault().toString();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault().toString()");
        this.language = locale;
        TimeZone timeZone = TimeZone.getDefault();
        Intrinsics.checkNotNullExpressionValue(timeZone, "getDefault()");
        this.timezone = timeZone;
    }

    private final Display getDisplay(Context context) {
        Object systemService = context.getSystemService("window");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        Display defaultDisplay = ((WindowManager) systemService).getDefaultDisplay();
        Intrinsics.checkNotNullExpressionValue(defaultDisplay, "windowManager.defaultDisplay");
        return defaultDisplay;
    }

    private final String getTimezoneOffset() {
        String str;
        long rawOffset = this.timezone.getRawOffset();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        long hours = timeUnit.toHours(rawOffset);
        long minutes = timeUnit.toMinutes(rawOffset) - TimeUnit.HOURS.toMinutes(hours);
        if (hours < 0) {
            str = "-";
        } else {
            str = "";
        }
        String format = String.format(Locale.US, "%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(Math.abs(hours)), Long.valueOf(minutes)}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(locale, format, *args)");
        return str.concat(format);
    }

    @Override // com.amplifyframework.auth.cognito.asf.DataCollector
    public Map<String, String> collect(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Display display = getDisplay(context);
        return MapsKt__MapsKt.mapOf(new Pair(TIMEZONE, getTimezoneOffset()), new Pair(PLATFORM_KEY, PLATFORM_VALUE), new Pair(THIRD_PARTY_DEVICE_AGENT, this.thirdPartyDeviceAgent), new Pair(DEVICE_AGENT, this.deviceId), new Pair(DEVICE_LANGUAGE, this.language), new Pair(DEVICE_HEIGHT, String.valueOf(display.getHeight())), new Pair(DEVICE_WIDTH, String.valueOf(display.getWidth())));
    }
}
