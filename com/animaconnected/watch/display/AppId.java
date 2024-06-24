package com.animaconnected.watch.display;

import com.animaconnected.secondo.behaviour.music.Music;
import com.animaconnected.secondo.screens.dashboard.DashboardFragment;
import com.animaconnected.secondo.screens.tipsandtricks.TipsAndTricksConstants;
import com.animaconnected.watch.behaviour.stopwatch.Stopwatch;
import com.animaconnected.watch.behaviour.workout.Workout;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: WatchAppInterfaces.kt */
/* loaded from: classes3.dex */
public final class AppId {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ AppId[] $VALUES;
    public static final AppId Alarm;
    public static final AppId AlarmRinging;
    public static final AppId Battery;
    public static final AppId BatteryNotification;
    public static final AppId BootSplash;
    public static final AppId Calls;
    public static final AppId Camera;
    public static final Companion Companion;
    public static final AppId DFU;
    public static final AppId Dashboard;
    public static final AppId DebugDrawCommands;
    public static final AppId DebugFullScreen;
    public static final AppId DebugHorizontalScreenCalibration;
    public static final AppId DebugIcon;
    public static final AppId DebugImages;
    public static final AppId DebugText;
    public static final AppId DebugVerticalScreenCalibration;
    public static final AppId DevCalibration;
    public static final AppId DevDiagnostic;
    public static final AppId FindPhone;
    public static final AppId GhostMode;
    public static final AppId Ifttt;
    public static final AppId Launcher = new AppId("Launcher", 0, 0);
    public static final AppId Music;
    public static final AppId Notification;
    public static final AppId Onboarding;
    public static final AppId QuickAction;
    public static final AppId RememberThisSpot;
    public static final AppId Remote;
    public static final AppId Settings;
    public static final AppId Stopwatch;
    public static final AppId Timer;
    public static final AppId Unknown;
    public static final AppId Unused1;
    public static final AppId WalkMeHome;
    public static final AppId Weather;
    public static final AppId Workout;
    public static final AppId WorldTime;
    private static final List<AppId> defaultApps;
    private final int code;

    /* compiled from: WatchAppInterfaces.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final AppId fromStatus(int r4) {
            Object obj;
            boolean z;
            Iterator<E> it = AppId.getEntries().iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (((AppId) obj).getCode() == r4) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            AppId appId = (AppId) obj;
            if (appId == null) {
                return AppId.Unknown;
            }
            return appId;
        }

        public final List<AppId> getDefaultApps() {
            return AppId.defaultApps;
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ AppId[] $values() {
        return new AppId[]{Launcher, Stopwatch, Settings, Music, Workout, Dashboard, Unused1, Notification, Timer, Calls, Battery, BatteryNotification, Remote, AlarmRinging, DevCalibration, DevDiagnostic, GhostMode, Onboarding, Alarm, DFU, WorldTime, QuickAction, BootSplash, Weather, RememberThisSpot, FindPhone, Camera, Ifttt, WalkMeHome, DebugImages, DebugDrawCommands, DebugFullScreen, DebugVerticalScreenCalibration, DebugHorizontalScreenCalibration, DebugIcon, DebugText, Unknown};
    }

    static {
        AppId appId = new AppId(Stopwatch.TYPE, 1, 1);
        Stopwatch = appId;
        AppId appId2 = new AppId("Settings", 2, 2);
        Settings = appId2;
        AppId appId3 = new AppId(Music.TYPE, 3, 3);
        Music = appId3;
        AppId appId4 = new AppId(Workout.TYPE, 4, 4);
        Workout = appId4;
        Dashboard = new AppId(DashboardFragment.name, 5, 5);
        Unused1 = new AppId("Unused1", 6, 6);
        Notification = new AppId("Notification", 7, 7);
        AppId appId5 = new AppId(com.animaconnected.watch.behaviour.timer.Timer.TYPE, 8, 8);
        Timer = appId5;
        Calls = new AppId("Calls", 9, 9);
        Battery = new AppId("Battery", 10, 10);
        BatteryNotification = new AppId("BatteryNotification", 11, 11);
        Remote = new AppId("Remote", 12, 12);
        AlarmRinging = new AppId("AlarmRinging", 13, 13);
        DevCalibration = new AppId("DevCalibration", 14, 14);
        DevDiagnostic = new AppId("DevDiagnostic", 15, 15);
        GhostMode = new AppId("GhostMode", 16, 16);
        Onboarding = new AppId("Onboarding", 17, 17);
        AppId appId6 = new AppId("Alarm", 18, 18);
        Alarm = appId6;
        DFU = new AppId("DFU", 19, 19);
        AppId appId7 = new AppId("WorldTime", 20, 20);
        WorldTime = appId7;
        QuickAction = new AppId("QuickAction", 21, 21);
        BootSplash = new AppId("BootSplash", 22, 22);
        AppId appId8 = new AppId("Weather", 23, 101);
        Weather = appId8;
        AppId appId9 = new AppId("RememberThisSpot", 24, 102);
        RememberThisSpot = appId9;
        AppId appId10 = new AppId(TipsAndTricksConstants.FIND_PHONE_NAME, 25, 103);
        FindPhone = appId10;
        AppId appId11 = new AppId("Camera", 26, 104);
        Camera = appId11;
        AppId appId12 = new AppId("Ifttt", 27, 105);
        Ifttt = appId12;
        AppId appId13 = new AppId("WalkMeHome", 28, 106);
        WalkMeHome = appId13;
        DebugImages = new AppId("DebugImages", 29, 211);
        DebugDrawCommands = new AppId("DebugDrawCommands", 30, 212);
        DebugFullScreen = new AppId("DebugFullScreen", 31, 213);
        DebugVerticalScreenCalibration = new AppId("DebugVerticalScreenCalibration", 32, 214);
        DebugHorizontalScreenCalibration = new AppId("DebugHorizontalScreenCalibration", 33, 215);
        DebugIcon = new AppId("DebugIcon", 34, 216);
        DebugText = new AppId("DebugText", 35, 217);
        Unknown = new AppId("Unknown", 36, 255);
        AppId[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        Companion = new Companion(null);
        defaultApps = CollectionsKt__CollectionsKt.listOf((Object[]) new AppId[]{appId4, appId3, appId8, appId5, appId, appId10, appId11, appId9, appId12, appId6, appId7, appId6, appId13, appId2});
    }

    private AppId(String str, int r2, int r3) {
        this.code = r3;
    }

    public static EnumEntries<AppId> getEntries() {
        return $ENTRIES;
    }

    public static AppId valueOf(String str) {
        return (AppId) Enum.valueOf(AppId.class, str);
    }

    public static AppId[] values() {
        return (AppId[]) $VALUES.clone();
    }

    public final int getCode() {
        return this.code;
    }
}
