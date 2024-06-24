package com.animaconnected.firebase;

import androidx.compose.ui.graphics.colorspace.Rgb$$ExternalSyntheticLambda2;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;

/* compiled from: WatchEvents.kt */
/* loaded from: classes.dex */
public final class WatchEvents {
    private final Analytics analytics;
    private Map<String, String> previousSettingsMap;

    public WatchEvents(Analytics analytics) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.analytics = analytics;
    }

    private final void dfuEvent(String str, String str2, Long l) {
        LinkedHashMap mutableMapOf = MapsKt__MapsKt.mutableMapOf(new Pair("state", str));
        if (str2 != null) {
            mutableMapOf.put("msg", str2);
        }
        if (l != null && Intrinsics.areEqual(str, "finish")) {
            mutableMapOf.put(AnalyticsConstants.KEY_TIME, l.toString());
        }
        this.analytics.sendEventMap$firebase_release(AnalyticsConstants.EVENT_DEVICE_DFU, mutableMapOf);
    }

    public static /* synthetic */ void dfuEvent$default(WatchEvents watchEvents, String str, String str2, Long l, int r5, Object obj) {
        if ((r5 & 2) != 0) {
            str2 = null;
        }
        if ((r5 & 4) != 0) {
            l = null;
        }
        watchEvents.dfuEvent(str, str2, l);
    }

    public static /* synthetic */ void dfuStatusChanged$default(WatchEvents watchEvents, String str, String str2, int r3, Object obj) {
        if ((r3 & 2) != 0) {
            str2 = null;
        }
        watchEvents.dfuStatusChanged(str, str2);
    }

    public static /* synthetic */ void fotaState$default(WatchEvents watchEvents, FotaState fotaState, String str, int r3, Object obj) {
        if ((r3 & 2) != 0) {
            str = null;
        }
        watchEvents.fotaState(fotaState, str);
    }

    public final void behaviourUsed(String str) {
        if (str == null) {
            str = "none";
        }
        this.analytics.sendEventMap$firebase_release(AnalyticsConstants.EVENT_SELECT_CONTENT, MapsKt__MapsKt.mapOf(new Pair(AnalyticsConstants.KEY_CONTENT_TYPE, "app_feature_used"), new Pair(AnalyticsConstants.KEY_ITEM_ID, str)));
    }

    public final void bondCreated(boolean z) {
        this.analytics.sendEventMap$firebase_release(AnalyticsConstants.EVENT_APP_BONDING_EVENT, MapsKt__MapsKt.mapOf(new Pair("type", "create_bond"), new Pair(AnalyticsConstants.KEY_RESULT, String.valueOf(z))));
    }

    public final void bondRemoved(boolean z) {
        this.analytics.sendEventMap$firebase_release(AnalyticsConstants.EVENT_APP_BONDING_EVENT, MapsKt__MapsKt.mapOf(new Pair("type", "remove_bond"), new Pair(AnalyticsConstants.KEY_RESULT, String.valueOf(z))));
    }

    public final void connectionEvent(String state, boolean z, Boolean bool) {
        Intrinsics.checkNotNullParameter(state, "state");
        this.analytics.sendEventMap$firebase_release(AnalyticsConstants.EVENT_APP_CONNECTION_EVENT, MapsKt__MapsKt.mapOf(new Pair("state", state), new Pair(AnalyticsConstants.KEY_BONDED, String.valueOf(z)), new Pair(AnalyticsConstants.KEY_PASSIVE, String.valueOf(bool))));
    }

    public final void debugLogRssi(int r3) {
        this.analytics.sendEventMap$firebase_release(AnalyticsConstants.EVENT_DEVICE_DEBUG_RSSI, Rgb$$ExternalSyntheticLambda2.m("rssi", String.valueOf(r3)));
    }

    /* renamed from: deviatingTime-JKoRlfk, reason: not valid java name */
    public final void m713deviatingTimeJKoRlfk(long j, Duration duration) {
        Long l;
        Pair[] pairArr = new Pair[2];
        pairArr[0] = new Pair(AnalyticsConstants.KEY_TIME_OFFSET_MS, String.valueOf(Duration.m1677getInWholeMillisecondsimpl(j)));
        if (duration != null) {
            l = Long.valueOf(Duration.m1677getInWholeMillisecondsimpl(duration.rawValue));
        } else {
            l = null;
        }
        pairArr[1] = new Pair(AnalyticsConstants.KEY_UTC_OFFSET_MS, String.valueOf(l));
        this.analytics.sendEventMap$firebase_release(AnalyticsConstants.EVENT_DEVICE_DEVIATING_TIME, MapsKt__MapsKt.mapOf(pairArr));
    }

    public final void deviceBatteryEvent(Boolean bool, Float f) {
        this.analytics.sendEventMap$firebase_release(AnalyticsConstants.EVENT_DEVICE_BATTERY, MapsKt__MapsKt.mapOf(new Pair(AnalyticsConstants.KEY_CHARGING, String.valueOf(bool)), new Pair(AnalyticsConstants.KEY_PERCENT, String.valueOf(f))));
    }

    public final void deviceButtonPressed(String str, String slotName, String action, boolean z) {
        Intrinsics.checkNotNullParameter(slotName, "slotName");
        Intrinsics.checkNotNullParameter(action, "action");
        if (str == null) {
            str = "none";
        }
        this.analytics.sendEventMap$firebase_release(AnalyticsConstants.EVENT_DEVICE_BUTTON_CLICKED, MapsKt__MapsKt.mapOf(new Pair(AnalyticsConstants.KEY_FEATURE, str), new Pair("slot", slotName), new Pair(AnalyticsConstants.KEY_ACTION, action), new Pair(AnalyticsConstants.KEY_DID_START, String.valueOf(z))));
    }

    public final void deviceCrash(String str, int r18, Boolean bool, String str2, Integer num, String str3, String str4, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, Integer num7, Integer num8, Integer num9, String str5, String environment) {
        Intrinsics.checkNotNullParameter(environment, "environment");
        this.analytics.sendEventMap$firebase_release(AnalyticsConstants.EVENT_DEVICE_CRASH, MapsKt__MapsKt.mapOf(new Pair("type", str), new Pair(AnalyticsConstants.KEY_HW_REASON, String.valueOf(r18)), new Pair(AnalyticsConstants.KEY_REMOTE, String.valueOf(bool)), new Pair(AnalyticsConstants.KEY_FILE_NAME, str2), new Pair(AnalyticsConstants.KEY_LINE_NUMBER, String.valueOf(num)), new Pair(AnalyticsConstants.KEY_ERROR_CODE, str3), new Pair(AnalyticsConstants.KEY_SP, str4), new Pair(AnalyticsConstants.KEY_LR, String.valueOf(num2)), new Pair(AnalyticsConstants.KEY_PC, String.valueOf(num3)), new Pair(AnalyticsConstants.KEY_R0, String.valueOf(num4)), new Pair(AnalyticsConstants.KEY_R1, String.valueOf(num5)), new Pair(AnalyticsConstants.KEY_R2, String.valueOf(num6)), new Pair(AnalyticsConstants.KEY_R3, String.valueOf(num7)), new Pair(AnalyticsConstants.KEY_PSR, String.valueOf(num8)), new Pair(AnalyticsConstants.KEY_R12, String.valueOf(num9)), new Pair(AnalyticsConstants.KEY_S3_URL, str5), new Pair(AnalyticsConstants.KEY_ENVIRONMENT, environment)));
    }

    public final void deviceDisconnected(Integer num, Integer num2, Integer num3) {
        this.analytics.sendEventMap$firebase_release(AnalyticsConstants.EVENT_DEVICE_DEBUG_DISCONNECT, MapsKt__MapsKt.mapOf(new Pair("rssi", String.valueOf(num)), new Pair(AnalyticsConstants.KEY_TIME, String.valueOf(num2)), new Pair("reason", String.valueOf(num3))));
    }

    public final void deviceError(int r3) {
        this.analytics.sendEventMap$firebase_release(AnalyticsConstants.EVENT_DEVICE_ERROR, Rgb$$ExternalSyntheticLambda2.m(AnalyticsConstants.KEY_ERROR_CODE, String.valueOf(r3)));
    }

    public final void dfuFinished(long j) {
        dfuEvent("finish", null, Long.valueOf(j));
    }

    public final void dfuStarted() {
        dfuEvent$default(this, "start", null, null, 6, null);
    }

    public final void dfuStatusChanged(String dfuState, String str) {
        Intrinsics.checkNotNullParameter(dfuState, "dfuState");
        dfuEvent$default(this, dfuState, str, null, 4, null);
    }

    public final void firmwareDownloaded(boolean z, String str) {
        String str2;
        Map<String, String> mapOf = MapsKt__MapsKt.mapOf(new Pair("state", "downloaded"), new Pair(AnalyticsConstants.KEY_VERSION, str));
        if (z) {
            str2 = AnalyticsConstants.EVENT_DEVICE_FOTA;
        } else {
            str2 = AnalyticsConstants.EVENT_DEVICE_DFU;
        }
        this.analytics.sendEventMap$firebase_release(str2, mapOf);
    }

    public final void firmwareRemoved(boolean z) {
        String str;
        Map<String, String> m = Rgb$$ExternalSyntheticLambda2.m("state", "removed");
        if (z) {
            str = AnalyticsConstants.EVENT_DEVICE_FOTA;
        } else {
            str = AnalyticsConstants.EVENT_DEVICE_DFU;
        }
        this.analytics.sendEventMap$firebase_release(str, m);
    }

    public final void fotaProgress(int r4, int r5) {
        this.analytics.sendEventMap$firebase_release(AnalyticsConstants.EVENT_DEVICE_FOTA, MapsKt__MapsKt.mapOf(new Pair("state", "page_completed"), new Pair(AnalyticsConstants.KEY_COMPLETED_PAGES, String.valueOf(r4)), new Pair(AnalyticsConstants.KEY_TOTAL_PAGES, String.valueOf(r5))));
    }

    public final void fotaState(FotaState state, String str) {
        Intrinsics.checkNotNullParameter(state, "state");
        LinkedHashMap mutableMapOf = MapsKt__MapsKt.mutableMapOf(new Pair("state", state.getKey()));
        if (str != null) {
            mutableMapOf.put("msg", str);
        }
        this.analytics.sendEventMap$firebase_release(AnalyticsConstants.EVENT_DEVICE_FOTA, mutableMapOf);
    }

    public final void iftttTrigger(String trigger, String str) {
        Intrinsics.checkNotNullParameter(trigger, "trigger");
        LinkedHashMap mutableMapOf = MapsKt__MapsKt.mutableMapOf(new Pair(AnalyticsConstants.KEY_IFTTT_TRIGGER, trigger));
        if (str != null) {
            mutableMapOf.put("error", str);
        }
        this.analytics.sendEventMap$firebase_release(AnalyticsConstants.EVENT_DEVICE_IFTTT_TRIGGER, mutableMapOf);
    }

    public final void logBuildInfo(Map<String, String> result) {
        Intrinsics.checkNotNullParameter(result, "result");
        this.analytics.sendEventMap$firebase_release(AnalyticsConstants.EVENT_DEVICE_BUILD_INFO, result);
    }

    public final void logBuildInfoBl(Map<String, String> result) {
        Intrinsics.checkNotNullParameter(result, "result");
        this.analytics.sendEventMap$firebase_release(AnalyticsConstants.EVENT_DEVICE_BUILD_INFO_BL, result);
    }

    public final void logDeviceDiagnostics(Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "map");
        this.analytics.sendEventMap$firebase_release(AnalyticsConstants.EVENT_DEVICE_DIAGNOSTICS, map);
    }

    public final void logDeviceInfo(String str, String str2, String str3, String str4, String str5) {
        this.analytics.sendEventMap$firebase_release(AnalyticsConstants.EVENT_DEVICE_INFO, MapsKt__MapsKt.mapOf(new Pair(AnalyticsConstants.KEY_SERIALNUMBER, str), new Pair(AnalyticsConstants.KEY_MODELNUMBER, str2), new Pair(AnalyticsConstants.KEY_MANUFACTURERNAME, str3), new Pair(AnalyticsConstants.KEY_HARDWAREREVISION, str4), new Pair(AnalyticsConstants.KEY_FIRMWAREREVISION, str5)));
    }

    public final void logDeviceSettings(boolean z, int r4, boolean z2) {
        Map<String, String> mapOf = MapsKt__MapsKt.mapOf(new Pair(AnalyticsConstants.KEY_GET_MOVING_ACTIVE, String.valueOf(z)), new Pair(AnalyticsConstants.KEY_STEPS_GOAL, String.valueOf(r4)), new Pair(AnalyticsConstants.KEY_IS_ONBOARDING_FINISH, String.valueOf(z2)));
        if (Intrinsics.areEqual(mapOf, this.previousSettingsMap)) {
            return;
        }
        this.previousSettingsMap = mapOf;
        this.analytics.sendEventMap$firebase_release(AnalyticsConstants.EVENT_DEVICE_SETTINGS, mapOf);
    }

    public final void logDiag(Map<String, String> diagEvent) {
        Intrinsics.checkNotNullParameter(diagEvent, "diagEvent");
        this.analytics.sendEventMap$firebase_release(AnalyticsConstants.EVENT_DEVICE_DIAG_EVENT, diagEvent);
    }

    public final void logSteps(int r3) {
        this.analytics.sendEventMap$firebase_release(AnalyticsConstants.EVENT_DEVICE_STEPS_NOW, Rgb$$ExternalSyntheticLambda2.m(AnalyticsConstants.KEY_STEPS_TODAY, String.valueOf(r3)));
    }

    public final void scanThrottled(long j) {
        this.analytics.sendEventMap$firebase_release(AnalyticsConstants.EVENT_APP_SCAN_THROTTLE, Rgb$$ExternalSyntheticLambda2.m(AnalyticsConstants.KEY_DURATION_SEC, String.valueOf(j)));
    }

    public final void serviceDiscoveryFail(int r3) {
        this.analytics.sendEventMap$firebase_release(AnalyticsConstants.EVENT_APP_FAILED_TO_FIND_SERVICES, Rgb$$ExternalSyntheticLambda2.m(AnalyticsConstants.KEY_SERVICES_FOUND, String.valueOf(r3)));
    }
}
