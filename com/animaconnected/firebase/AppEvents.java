package com.animaconnected.firebase;

import androidx.compose.animation.AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0;
import androidx.compose.ui.graphics.colorspace.Rgb$$ExternalSyntheticLambda2;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.collections.EmptyMap;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.collections.builders.MapBuilder;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AppEvents.kt */
/* loaded from: classes.dex */
public final class AppEvents {
    private final Analytics analytics;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: AppEvents.kt */
    /* loaded from: classes.dex */
    public static final class Deviation {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Deviation[] $VALUES;
        private final String analyticsName;
        public static final Deviation Reboot = new Deviation("Reboot", 0, "reboot");
        public static final Deviation Late = new Deviation("Late", 1, "late");

        private static final /* synthetic */ Deviation[] $values() {
            return new Deviation[]{Reboot, Late};
        }

        static {
            Deviation[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        private Deviation(String str, int r2, String str2) {
            this.analyticsName = str2;
        }

        public static EnumEntries<Deviation> getEntries() {
            return $ENTRIES;
        }

        public static Deviation valueOf(String str) {
            return (Deviation) Enum.valueOf(Deviation.class, str);
        }

        public static Deviation[] values() {
            return (Deviation[]) $VALUES.clone();
        }

        public final String getAnalyticsName() {
            return this.analyticsName;
        }
    }

    /* compiled from: AppEvents.kt */
    /* loaded from: classes.dex */
    public static final class Device {
        private final boolean active;
        private final String serialNumber;

        public Device(String serialNumber, boolean z) {
            Intrinsics.checkNotNullParameter(serialNumber, "serialNumber");
            this.serialNumber = serialNumber;
            this.active = z;
        }

        public static /* synthetic */ Device copy$default(Device device, String str, boolean z, int r3, Object obj) {
            if ((r3 & 1) != 0) {
                str = device.serialNumber;
            }
            if ((r3 & 2) != 0) {
                z = device.active;
            }
            return device.copy(str, z);
        }

        public final String component1() {
            return this.serialNumber;
        }

        public final boolean component2() {
            return this.active;
        }

        public final Device copy(String serialNumber, boolean z) {
            Intrinsics.checkNotNullParameter(serialNumber, "serialNumber");
            return new Device(serialNumber, z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Device)) {
                return false;
            }
            Device device = (Device) obj;
            if (Intrinsics.areEqual(this.serialNumber, device.serialNumber) && this.active == device.active) {
                return true;
            }
            return false;
        }

        public final boolean getActive() {
            return this.active;
        }

        public final String getSerialNumber() {
            return this.serialNumber;
        }

        public int hashCode() {
            return Boolean.hashCode(this.active) + (this.serialNumber.hashCode() * 31);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("Device(serialNumber=");
            sb.append(this.serialNumber);
            sb.append(", active=");
            return AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0.m(sb, this.active, ')');
        }
    }

    public AppEvents(Analytics analytics) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.analytics = analytics;
    }

    public static /* synthetic */ void remoteConfigFetched$default(AppEvents appEvents, boolean z, long j, String str, String str2, int r12, Object obj) {
        if ((r12 & 8) != 0) {
            str2 = null;
        }
        appEvents.remoteConfigFetched(z, j, str, str2);
    }

    public final void accountCreationConfirm(String str) {
        Map<String, String> map;
        if (str != null) {
            map = Rgb$$ExternalSyntheticLambda2.m("error", str);
        } else {
            map = EmptyMap.INSTANCE;
        }
        this.analytics.sendEventMap$firebase_release(AnalyticsConstants.EVENT_APP_ACCOUNT_CREATE_CONFIRM, map);
    }

    public final void accountCreationStart(String str) {
        Map<String, String> map;
        if (str != null) {
            map = Rgb$$ExternalSyntheticLambda2.m("error", str);
        } else {
            map = EmptyMap.INSTANCE;
        }
        this.analytics.sendEventMap$firebase_release(AnalyticsConstants.EVENT_APP_ACCOUNT_CREATE_START, map);
    }

    public final void accountDelete(String str) {
        Map<String, String> map;
        if (str != null) {
            map = Rgb$$ExternalSyntheticLambda2.m("error", str);
        } else {
            map = EmptyMap.INSTANCE;
        }
        this.analytics.sendEventMap$firebase_release(AnalyticsConstants.EVENT_APP_ACCOUNT_DELETE, map);
    }

    public final void accountDownloadDataExported() {
        this.analytics.sendEvent$firebase_release(AnalyticsConstants.EVENT_APP_ACCOUNT_DOWNLOAD_DATA_EXPORTED);
    }

    public final void accountDownloadDataInitiated(String str) {
        Map<String, String> map;
        if (str != null) {
            map = Rgb$$ExternalSyntheticLambda2.m("error", str);
        } else {
            map = EmptyMap.INSTANCE;
        }
        this.analytics.sendEventMap$firebase_release(AnalyticsConstants.EVENT_APP_ACCOUNT_DOWNLOAD_DATA_INITIATED, map);
    }

    public final void accountForgotPasswordConfirm(String str) {
        Map<String, String> map;
        if (str != null) {
            map = Rgb$$ExternalSyntheticLambda2.m("error", str);
        } else {
            map = EmptyMap.INSTANCE;
        }
        this.analytics.sendEventMap$firebase_release(AnalyticsConstants.EVENT_APP_ACCOUNT_FORGOT_PASSWORD_CONFIRM, map);
    }

    public final void accountForgotPasswordStart(String str) {
        Map<String, String> map;
        if (str != null) {
            map = Rgb$$ExternalSyntheticLambda2.m("error", str);
        } else {
            map = EmptyMap.INSTANCE;
        }
        this.analytics.sendEventMap$firebase_release(AnalyticsConstants.EVENT_APP_ACCOUNT_FORGOT_PASSWORD, map);
    }

    public final void accountLogin(String str, String str2) {
        Pair[] pairArr = new Pair[1];
        if (str == null) {
            str = "unknown";
        }
        pairArr[0] = new Pair("provider", str);
        LinkedHashMap mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
        if (str2 != null) {
            mutableMapOf.put("error", str2);
        }
        this.analytics.sendEventMap$firebase_release(AnalyticsConstants.EVENT_APP_ACCOUNT_LOGIN, mutableMapOf);
    }

    public final void accountLoginSkipped() {
        this.analytics.sendEvent$firebase_release(AnalyticsConstants.EVENT_APP_ACCOUNT_LOGIN_SKIPPED);
    }

    public final void accountLogout(String str) {
        Map<String, String> map;
        if (str != null) {
            map = Rgb$$ExternalSyntheticLambda2.m("error", str);
        } else {
            map = EmptyMap.INSTANCE;
        }
        this.analytics.sendEventMap$firebase_release(AnalyticsConstants.EVENT_APP_ACCOUNT_LOGOUT, map);
    }

    public final void accountResendConfirmationCode(String str) {
        Map<String, String> map;
        if (str != null) {
            map = Rgb$$ExternalSyntheticLambda2.m("error", str);
        } else {
            map = EmptyMap.INSTANCE;
        }
        this.analytics.sendEventMap$firebase_release(AnalyticsConstants.EVENT_APP_ACCOUNT_RESEND_CODE, map);
    }

    public final void alarmChanged(int r3, int r4, int r5, int r6) {
        this.analytics.sendEventMap$firebase_release(AnalyticsConstants.EVENT_APP_SILENT_ALARM, MapsKt__MapsKt.mapOf(new Pair(AnalyticsConstants.KEY_INDEX, String.valueOf(r3)), new Pair(AnalyticsConstants.KEY_DAYS_BIT_SET, String.valueOf(r4)), new Pair(AnalyticsConstants.KEY_HOURS, String.valueOf(r5)), new Pair(AnalyticsConstants.KEY_MINUTES, String.valueOf(r6))));
    }

    public final void appListChangedPositions(String positions) {
        Intrinsics.checkNotNullParameter(positions, "positions");
        this.analytics.sendEventMap$firebase_release(AnalyticsConstants.EVENT_APP_LIST_CHANGED_POSITIONS, MapsKt__MapsJVMKt.mapOf(new Pair("event", positions)));
    }

    public final void appListHideApp(String appName) {
        Intrinsics.checkNotNullParameter(appName, "appName");
        this.analytics.sendEventMap$firebase_release(AnalyticsConstants.EVENT_APP_LIST_HIDE_APP, MapsKt__MapsJVMKt.mapOf(new Pair(AnalyticsConstants.KEY_CODE, appName)));
    }

    public final void appListOpenAppDetail(String appName) {
        Intrinsics.checkNotNullParameter(appName, "appName");
        this.analytics.sendEventMap$firebase_release(AnalyticsConstants.EVENT_APP_LIST_OPEN_DETAIL, MapsKt__MapsJVMKt.mapOf(new Pair(AnalyticsConstants.KEY_CODE, appName)));
    }

    public final void appListRemoveQA(String str) {
        this.analytics.sendEventMap$firebase_release(AnalyticsConstants.EVENT_APP_LIST_REMOVE_QA, MapsKt__MapsJVMKt.mapOf(new Pair(AnalyticsConstants.KEY_CODE, str)));
    }

    public final void appListSetQA(String appName) {
        Intrinsics.checkNotNullParameter(appName, "appName");
        this.analytics.sendEventMap$firebase_release(AnalyticsConstants.EVENT_APP_LIST_SET_QA, MapsKt__MapsJVMKt.mapOf(new Pair(AnalyticsConstants.KEY_CODE, appName)));
    }

    public final void appListShowApp(String appName) {
        Intrinsics.checkNotNullParameter(appName, "appName");
        this.analytics.sendEventMap$firebase_release(AnalyticsConstants.EVENT_APP_LIST_SHOW_APP, MapsKt__MapsJVMKt.mapOf(new Pair(AnalyticsConstants.KEY_CODE, appName)));
    }

    public final void bluetoothOff() {
        this.analytics.sendEventMap$firebase_release(AnalyticsConstants.EVENT_SYSTEM_EVENT, MapsKt__MapsKt.mapOf(new Pair("type", "bt_toogle"), new Pair("state", "disabled")));
    }

    public final void bluetoothOn() {
        this.analytics.sendEventMap$firebase_release(AnalyticsConstants.EVENT_SYSTEM_EVENT, MapsKt__MapsKt.mapOf(new Pair("type", "bt_toogle"), new Pair("state", "enabled")));
    }

    public final void caloriesBMRShared(String str, String str2) {
        Pair[] pairArr = new Pair[1];
        if (str == null) {
            str = "unknown";
        }
        pairArr[0] = new Pair(AnalyticsConstants.KEY_THIRD_PARTY, str);
        LinkedHashMap mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
        if (str2 != null) {
            mutableMapOf.put("error", str2);
        }
        this.analytics.sendEventMap$firebase_release(AnalyticsConstants.EVENT_APP_SHARE_CALORIES_BMR, mutableMapOf);
    }

    public final void cloudEvent(String feature, String name, String type, String str) {
        Intrinsics.checkNotNullParameter(feature, "feature");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(type, "type");
        LinkedHashMap mutableMapOf = MapsKt__MapsKt.mutableMapOf(new Pair(AnalyticsConstants.KEY_FEATURE, feature), new Pair("name", name), new Pair("type", type));
        if (str != null) {
            mutableMapOf.put("msg", str);
        }
        this.analytics.sendEventMap$firebase_release(AnalyticsConstants.EVENT_CLOUD_EVENT, mutableMapOf);
    }

    public final void createTicket(String status, String info) {
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(info, "info");
        this.analytics.sendEventMap$firebase_release(AnalyticsConstants.EVENT_APP_CREATE_TICKET, MapsKt__MapsKt.mapOf(new Pair(AnalyticsConstants.KEY_STATUS, status), new Pair(AnalyticsConstants.KEY_INFO, info)));
    }

    public final void displayAppAction(String appName, int r5, String actionName) {
        Intrinsics.checkNotNullParameter(appName, "appName");
        Intrinsics.checkNotNullParameter(actionName, "actionName");
        this.analytics.sendEventMap$firebase_release(AnalyticsConstants.EVENT_DISPLAY_APP_ACTION, MapsKt__MapsKt.mapOf(new Pair(AnalyticsConstants.KEY_DISPLAY_APP_ID, appName), new Pair(AnalyticsConstants.KEY_DISPLAY_APP_DISPLAY_ID, String.valueOf(r5)), new Pair(AnalyticsConstants.KEY_DISPLAY_APP_ACTION_ID, actionName)));
    }

    public final void displayAppQATriggered(String appName) {
        Intrinsics.checkNotNullParameter(appName, "appName");
        this.analytics.sendEventMap$firebase_release(AnalyticsConstants.EVENT_DISPLAY_APP_QA_ACTION, MapsKt__MapsJVMKt.mapOf(new Pair(AnalyticsConstants.KEY_DISPLAY_APP_ID, appName)));
    }

    public final void displayAppSendAllPositions(String positions) {
        Intrinsics.checkNotNullParameter(positions, "positions");
        this.analytics.sendEventMap$firebase_release(AnalyticsConstants.EVENT_DISPLAY_APP_ALL_POSITIONS, MapsKt__MapsJVMKt.mapOf(new Pair(AnalyticsConstants.KEY_CODE, positions)));
    }

    public final void giftNotInterested() {
        this.analytics.sendEventMap$firebase_release(AnalyticsConstants.EVENT_APP_GIFT, Rgb$$ExternalSyntheticLambda2.m("event", "gift_not_interested"));
    }

    public final void giftNotificationShown() {
        this.analytics.sendEventMap$firebase_release(AnalyticsConstants.EVENT_APP_GIFT, Rgb$$ExternalSyntheticLambda2.m("event", "gift_notification_shown"));
    }

    public final void giftRedeemTapped() {
        this.analytics.sendEventMap$firebase_release(AnalyticsConstants.EVENT_APP_GIFT, Rgb$$ExternalSyntheticLambda2.m("event", "gift_redeem_tapped"));
    }

    public final void giftShown() {
        this.analytics.sendEventMap$firebase_release(AnalyticsConstants.EVENT_APP_GIFT, Rgb$$ExternalSyntheticLambda2.m("event", "gift_shown"));
    }

    public final void giftTapped() {
        this.analytics.sendEventMap$firebase_release(AnalyticsConstants.EVENT_APP_GIFT, Rgb$$ExternalSyntheticLambda2.m("event", "gift_tapped"));
    }

    public final void heartRateShared(String str, String str2) {
        Pair[] pairArr = new Pair[1];
        if (str == null) {
            str = "unknown";
        }
        pairArr[0] = new Pair(AnalyticsConstants.KEY_THIRD_PARTY, str);
        LinkedHashMap mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
        if (str2 != null) {
            mutableMapOf.put("error", str2);
        }
        this.analytics.sendEventMap$firebase_release(AnalyticsConstants.EVENT_APP_SHARE_HEART_RATE, mutableMapOf);
    }

    public final void illegalStateInWatchInit(String errorMessage) {
        Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
        this.analytics.sendEventMap$firebase_release(AnalyticsConstants.EVENT_ILLEGAL_STATE_IN_WATCH_INIT, MapsKt__MapsJVMKt.mapOf(new Pair("error", errorMessage)));
    }

    public final void notificationEventHandled(String str) {
        this.analytics.sendEventMap$firebase_release(AnalyticsConstants.EVENT_APP_NOTIFICATION_EVENT, Rgb$$ExternalSyntheticLambda2.m("package", str));
    }

    public final void notificationHandled(String str, String str2) {
        this.analytics.sendEventMap$firebase_release(AnalyticsConstants.EVENT_APP_NOTIFICATION_HANDLED, MapsKt__MapsKt.mapOf(new Pair("category", str), new Pair("package", str2)));
    }

    public final void onboardingFinished(long j) {
        this.analytics.sendEventMap$firebase_release(AnalyticsConstants.EVENT_APP_ONBOARDING, MapsKt__MapsKt.mapOf(new Pair("state", "finish"), new Pair(AnalyticsConstants.KEY_TIME, String.valueOf(j))));
    }

    public final void onboardingStarted() {
        this.analytics.sendEventMap$firebase_release(AnalyticsConstants.EVENT_APP_ONBOARDING, Rgb$$ExternalSyntheticLambda2.m("state", "start"));
    }

    public final void phoneShutDown() {
        this.analytics.sendEventMap$firebase_release(AnalyticsConstants.EVENT_SYSTEM_EVENT, Rgb$$ExternalSyntheticLambda2.m("type", "shutdown"));
    }

    public final void pingDeviation(Deviation deviation, long j) {
        Intrinsics.checkNotNullParameter(deviation, "deviation");
        this.analytics.sendEventMap$firebase_release(AnalyticsConstants.EVENT_APP_UPTIME_DEVIATION, MapsKt__MapsKt.mapOf(new Pair(AnalyticsConstants.KEY_DEVIATION, deviation.getAnalyticsName()), new Pair(AnalyticsConstants.KEY_TIME, String.valueOf(j))));
    }

    public final void quietHoursSet(boolean z, int r5, int r6, int r7, int r8) {
        String str;
        Pair[] pairArr = new Pair[5];
        if (z) {
            str = "enabled";
        } else {
            str = "disabled";
        }
        pairArr[0] = new Pair("state", str);
        pairArr[1] = new Pair(AnalyticsConstants.KEY_FROM_HOURS, String.valueOf(r5));
        pairArr[2] = new Pair(AnalyticsConstants.KEY_FROM_MINUTES, String.valueOf(r6));
        pairArr[3] = new Pair(AnalyticsConstants.KEY_TO_HOURS, String.valueOf(r7));
        pairArr[4] = new Pair(AnalyticsConstants.KEY_TO_MINUTES, String.valueOf(r8));
        this.analytics.sendEventMap$firebase_release(AnalyticsConstants.EVENT_APP_QUIET_HOURS_CHANGED, MapsKt__MapsKt.mapOf(pairArr));
    }

    public final void remoteConfigFetched(boolean z, long j, String type, String str) {
        String str2;
        Intrinsics.checkNotNullParameter(type, "type");
        Pair[] pairArr = new Pair[3];
        if (z) {
            str2 = "success";
        } else {
            str2 = "fail";
        }
        pairArr[0] = new Pair(AnalyticsConstants.KEY_STATUS, str2);
        pairArr[1] = new Pair(AnalyticsConstants.KEY_VERSION, String.valueOf(j));
        pairArr[2] = new Pair("type", type);
        LinkedHashMap mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
        if (str != null) {
            mutableMapOf.put("msg", str);
        }
        this.analytics.sendEventMap$firebase_release(AnalyticsConstants.EVENT_APP_FIREBASE_CONFIG_FETCH, mutableMapOf);
    }

    public final void sendAction(String str) {
        this.analytics.sendEventMap$firebase_release(AnalyticsConstants.EVENT_SELECT_CONTENT, MapsKt__MapsKt.mapOf(new Pair(AnalyticsConstants.KEY_CONTENT_TYPE, "app_action_used"), new Pair(AnalyticsConstants.KEY_ITEM_ID, str)));
    }

    public final void sendComplicationSetting(String str, String str2) {
        this.analytics.sendEventMap$firebase_release(AnalyticsConstants.EVENT_APP_COMPLICATIONS, MapsKt__MapsKt.mapOf(new Pair(AnalyticsConstants.KEY_MAIN, str), new Pair(AnalyticsConstants.KEY_DOUBLE, str2)));
    }

    public final void sendDevices(List<Device> devices) {
        String str;
        Intrinsics.checkNotNullParameter(devices, "devices");
        if (devices.isEmpty()) {
            this.analytics.sendEvent$firebase_release(AnalyticsConstants.EVENT_APP_DEVICES);
            return;
        }
        Analytics analytics = this.analytics;
        List<Device> list = devices;
        int mapCapacity = MapsKt__MapsJVMKt.mapCapacity(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(list, 10));
        if (mapCapacity < 16) {
            mapCapacity = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(mapCapacity);
        for (Device device : list) {
            String serialNumber = device.getSerialNumber();
            if (device.getActive()) {
                str = "active";
            } else {
                str = "inactive";
            }
            linkedHashMap.put(serialNumber, str);
        }
        analytics.sendEventMap$firebase_release(AnalyticsConstants.EVENT_APP_DEVICES, linkedHashMap);
    }

    public final Map<String, String> sendFilterNotification(String calls, String texts, boolean z, int r7, int r8, int r9) {
        Intrinsics.checkNotNullParameter(calls, "calls");
        Intrinsics.checkNotNullParameter(texts, "texts");
        Map<String, String> mapOf = MapsKt__MapsKt.mapOf(new Pair(AnalyticsConstants.KEY_FN_CALLS, calls), new Pair(AnalyticsConstants.KEY_FN_TEXTS, texts), new Pair(AnalyticsConstants.KEY_FN_IS_ALL_APPS_ON, String.valueOf(z)), new Pair(AnalyticsConstants.KEY_FN_NBR_IMPORTANT_PERSONS, String.valueOf(r7)), new Pair(AnalyticsConstants.KEY_FN_NBR_APPS, String.valueOf(r8)), new Pair(AnalyticsConstants.KEY_FN_NBR_ACTIVE_APPS, String.valueOf(r9)));
        this.analytics.sendEventMap$firebase_release(AnalyticsConstants.EVENT_APP_FILTERED_NOTIFICATIONS, mapOf);
        return mapOf;
    }

    public final void sendFilterNotificationSetting(String[] filterNotificationsNameList) {
        Intrinsics.checkNotNullParameter(filterNotificationsNameList, "filterNotificationsNameList");
        this.analytics.sendEventMap$firebase_release(AnalyticsConstants.EVENT_APP_FILTERED_NOTIFICATIONS, MapsKt__MapsKt.mapOf(new Pair(AnalyticsConstants.KEY_FN_0_0, filterNotificationsNameList[0]), new Pair(AnalyticsConstants.KEY_FN_0_1, filterNotificationsNameList[1]), new Pair(AnalyticsConstants.KEY_FN_0_2, filterNotificationsNameList[2]), new Pair(AnalyticsConstants.KEY_FN_0_3, filterNotificationsNameList[3]), new Pair(AnalyticsConstants.KEY_FN_1_0, filterNotificationsNameList[4]), new Pair(AnalyticsConstants.KEY_FN_1_1, filterNotificationsNameList[5]), new Pair(AnalyticsConstants.KEY_FN_1_2, filterNotificationsNameList[6]), new Pair(AnalyticsConstants.KEY_FN_1_3, filterNotificationsNameList[7]), new Pair(AnalyticsConstants.KEY_FN_2_0, filterNotificationsNameList[8]), new Pair(AnalyticsConstants.KEY_FN_2_1, filterNotificationsNameList[9]), new Pair(AnalyticsConstants.KEY_FN_2_2, filterNotificationsNameList[10]), new Pair(AnalyticsConstants.KEY_FN_2_3, filterNotificationsNameList[11])));
    }

    public final void sendFindPhoneSoundChanged(String str, String str2) {
        this.analytics.sendEventMap$firebase_release(AnalyticsConstants.EVENT_APP_FIND_PHONE_CHANGED, MapsKt__MapsKt.mapOf(new Pair(AnalyticsConstants.KEY_PREVIOUS, str), new Pair(AnalyticsConstants.KEY_CURRENT, str2)));
    }

    public final void sendFindPhoneSoundPlayed(String str, String str2) {
        this.analytics.sendEventMap$firebase_release(AnalyticsConstants.EVENT_APP_FIND_PHONE_USED, MapsKt__MapsKt.mapOf(new Pair(AnalyticsConstants.KEY_SOUND, str), new Pair("slot", str2)));
    }

    public final void sendForegroundStart(String service, boolean z, Boolean bool, Boolean bool2, String str) {
        Intrinsics.checkNotNullParameter(service, "service");
        MapBuilder mapBuilder = new MapBuilder();
        mapBuilder.put(AnalyticsConstants.KEY_SERVICE, service);
        mapBuilder.put(AnalyticsConstants.KEY_SUCCESSFUL, String.valueOf(z));
        mapBuilder.put(AnalyticsConstants.KEY_ASSOCIATED, String.valueOf(bool));
        mapBuilder.put(AnalyticsConstants.KEY_POWER_OPT_OUT, String.valueOf(bool2));
        if (str != null) {
            mapBuilder.put(AnalyticsConstants.KEY_EXTRA, str);
        }
        mapBuilder.checkIsMutable$kotlin_stdlib();
        mapBuilder.isReadOnly = true;
        if (mapBuilder.size <= 0) {
            mapBuilder = MapBuilder.Empty;
            Intrinsics.checkNotNull(mapBuilder, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.builders.MapBuilder, V of kotlin.collections.builders.MapBuilder>");
        }
        this.analytics.sendEventMap$firebase_release(AnalyticsConstants.EVENT_APP_START_FOREGROUND_SERVICE, mapBuilder);
    }

    public final void sendFragmentVisited(String str, Long l) {
        this.analytics.sendEventMap$firebase_release(AnalyticsConstants.EVENT_APP_FRAGMENT_VIEWED, MapsKt__MapsKt.mapOf(new Pair(AnalyticsConstants.KEY_FRAGMENT_NAME, str), new Pair(AnalyticsConstants.KEY_VIEWING_DURATION_MS, String.valueOf(l))));
    }

    public final void sendGiftAction(String str) {
        this.analytics.sendEventMap$firebase_release(AnalyticsConstants.EVENT_APP_GIFT, Rgb$$ExternalSyntheticLambda2.m("event", str));
    }

    public final void sendLostWatchEvent(String str, Long l) {
        this.analytics.sendEventMap$firebase_release(AnalyticsConstants.EVENT_APP_LOST_WATCH, MapsKt__MapsKt.mapOf(new Pair("type", str), new Pair(AnalyticsConstants.KEY_TIME, String.valueOf(l))));
    }

    public final void sendMiniOnboardingStarted(String str, boolean z) {
        this.analytics.sendEventMap$firebase_release(AnalyticsConstants.EVENT_APP_MINI_ONBOARDING_STARTED, MapsKt__MapsKt.mapOf(new Pair(AnalyticsConstants.KEY_FRAGMENT_NAME, str), new Pair(AnalyticsConstants.KEY_REQUESTED_BY_USER, String.valueOf(z))));
    }

    public final void sendNewsletter(String str) {
        this.analytics.sendEventMap$firebase_release(AnalyticsConstants.EVENT_APP_NEWSLETTER, Rgb$$ExternalSyntheticLambda2.m(AnalyticsConstants.KEY_STATUS, str));
    }

    public final void sendNotificationDetails(Map<String, String> details) {
        Intrinsics.checkNotNullParameter(details, "details");
        this.analytics.sendEventMap$firebase_release(AnalyticsConstants.EVENT_APP_NOTIFICATIONS_DETAILS, details);
    }

    public final void sendPageCreated(String str) {
        this.analytics.sendEventMap$firebase_release(AnalyticsConstants.EVENT_SELECT_CONTENT, MapsKt__MapsKt.mapOf(new Pair(AnalyticsConstants.KEY_CONTENT_TYPE, "app_page_created"), new Pair(AnalyticsConstants.KEY_ITEM_ID, str)));
    }

    public final void sendPeriodicRSSI(int r3) {
        this.analytics.sendEventMap$firebase_release(AnalyticsConstants.EVENT_APP_PERIODIC_RSSI_CHECK, Rgb$$ExternalSyntheticLambda2.m(AnalyticsConstants.KEY_CURRENT_RSSI_VALUE, String.valueOf(r3)));
    }

    public final void sendPusherSetting(String str, String str2) {
        this.analytics.sendEventMap$firebase_release(AnalyticsConstants.EVENT_APP_PUSHERS, MapsKt__MapsKt.mapOf(new Pair(AnalyticsConstants.KEY_TOP, str), new Pair(AnalyticsConstants.KEY_BOTTOM, str2)));
    }

    public final void sendSession(String start, String end, boolean z, String type) {
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(end, "end");
        Intrinsics.checkNotNullParameter(type, "type");
        this.analytics.sendEventMap$firebase_release(AnalyticsConstants.EVENT_APP_WORKOUT_SESSION, MapsKt__MapsKt.mapOf(new Pair(AnalyticsConstants.KEY_START_TIMESTAMP, start), new Pair(AnalyticsConstants.KEY_END_TIMESTAMP, end), new Pair(AnalyticsConstants.KEY_GPS_USED, String.valueOf(z)), new Pair(AnalyticsConstants.KEY_SESSION_TYPE, type)));
    }

    public final void sendSleep(List<Pair<Long, String>> data) {
        Intrinsics.checkNotNullParameter(data, "data");
        Iterator<T> it = data.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            this.analytics.sendEventMap$firebase_release(AnalyticsConstants.EVENT_APP_ACTIVITY_SLEEP, MapsKt__MapsKt.mapOf(new Pair(AnalyticsConstants.KEY_TIMESTAMP, String.valueOf(pair.first)), new Pair("type", pair.second)));
        }
    }

    public final void sendStrongVibrationToggle(String str) {
        this.analytics.sendEventMap$firebase_release(AnalyticsConstants.EVENT_APP_STRONG_VIBRATION_TOGGLE, Rgb$$ExternalSyntheticLambda2.m("state", str));
    }

    public final void sendSubComplicationSetting(String str, String str2) {
        this.analytics.sendEventMap$firebase_release(AnalyticsConstants.EVENT_APP_SUB_COMPLICATIONS, MapsKt__MapsKt.mapOf(new Pair(AnalyticsConstants.KEY_SUB1, str), new Pair(AnalyticsConstants.KEY_SUB2, str2)));
    }

    public final void sleepSessionShared(String str, String str2) {
        Pair[] pairArr = new Pair[1];
        if (str == null) {
            str = "unknown";
        }
        pairArr[0] = new Pair(AnalyticsConstants.KEY_THIRD_PARTY, str);
        LinkedHashMap mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
        if (str2 != null) {
            mutableMapOf.put("error", str2);
        }
        this.analytics.sendEventMap$firebase_release(AnalyticsConstants.EVENT_APP_SHARE_SLEEP_SESSION, mutableMapOf);
    }

    public final void stepsShared(String str, String str2) {
        Pair[] pairArr = new Pair[1];
        if (str == null) {
            str = "unknown";
        }
        pairArr[0] = new Pair(AnalyticsConstants.KEY_THIRD_PARTY, str);
        LinkedHashMap mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
        if (str2 != null) {
            mutableMapOf.put("error", str2);
        }
        this.analytics.sendEventMap$firebase_release(AnalyticsConstants.EVENT_APP_SHARE_STEPS, mutableMapOf);
    }

    public final void walkerUpdated(String walkerId, String followerId, String timestamp, String error) {
        Intrinsics.checkNotNullParameter(walkerId, "walkerId");
        Intrinsics.checkNotNullParameter(followerId, "followerId");
        Intrinsics.checkNotNullParameter(timestamp, "timestamp");
        Intrinsics.checkNotNullParameter(error, "error");
        this.analytics.sendEventMap$firebase_release(AnalyticsConstants.EVENT_APP_WMH_LOCATION_UPDATE, MapsKt__MapsKt.mapOf(new Pair(AnalyticsConstants.KEY_WALKERID, walkerId), new Pair(AnalyticsConstants.KEY_FOLLOWERID, followerId), new Pair(AnalyticsConstants.KEY_TIMESTAMP, timestamp), new Pair("error", error)));
    }

    public final void workoutSessionShared(String str, String str2) {
        Pair[] pairArr = new Pair[1];
        if (str == null) {
            str = "unknown";
        }
        pairArr[0] = new Pair(AnalyticsConstants.KEY_THIRD_PARTY, str);
        LinkedHashMap mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
        if (str2 != null) {
            mutableMapOf.put("error", str2);
        }
        this.analytics.sendEventMap$firebase_release(AnalyticsConstants.EVENT_APP_SHARE_WORKOUT_SESSION, mutableMapOf);
    }
}
