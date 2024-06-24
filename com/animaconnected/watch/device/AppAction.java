package com.animaconnected.watch.device;

import com.animaconnected.secondo.screens.tipsandtricks.TipsAndTricksConstants;
import java.util.Iterator;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: DeviceUtils.kt */
/* loaded from: classes3.dex */
public final class AppAction {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ AppAction[] $VALUES;
    public static final AppAction AlarmDismiss;
    public static final AppAction AlarmSelect;
    public static final AppAction BottomPusher;
    public static final AppAction Button5;
    public static final AppAction ButtonLast;
    public static final AppAction CallAnswer;
    public static final AppAction CallDecline;
    public static final AppAction CallHangUp;
    public static final AppAction CallLoudSpeaker;
    public static final AppAction CallMute;
    public static final AppAction ChronoBack;
    public static final AppAction ChronoExit;
    public static final AppAction ChronoLap;
    public static final AppAction ChronoReset;
    public static final AppAction ChronoResume;
    public static final AppAction ChronoReview;
    public static final AppAction ChronoStart;
    public static final AppAction ChronoStop;
    public static final Companion Companion;
    public static final AppAction EvPlaceholder1;
    public static final AppAction EvPlaceholder2;
    public static final AppAction EvPlaceholder3;
    public static final AppAction EvPlaceholder4;
    public static final AppAction MusicNext;
    public static final AppAction MusicPrev;
    public static final AppAction MusicStartPause;
    public static final AppAction MusicVolumeDown;
    public static final AppAction MusicVolumeUp;
    public static final AppAction NotificationDismiss;
    public static final AppAction TimerAddTime;
    public static final AppAction TimerMinuteSelect;
    public static final AppAction TimerReset;
    public static final AppAction WorkoutBike;
    public static final AppAction WorkoutDiscard;
    public static final AppAction WorkoutDiscardNo;
    public static final AppAction WorkoutDiscardYes;
    public static final AppAction WorkoutOthers;
    public static final AppAction WorkoutPause;
    public static final AppAction WorkoutResume;
    public static final AppAction WorkoutRun;
    public static final AppAction WorkoutSave;
    public static final AppAction WorkoutStart;
    public static final AppAction WorkoutStop;
    public static final AppAction WorkoutWalk;
    private final int id;
    public static final AppAction Unknown = new AppAction("Unknown", 0, Integer.MAX_VALUE);
    public static final AppAction AppStart = new AppAction("AppStart", 1, 0);
    public static final AppAction Button1 = new AppAction("Button1", 2, 1);
    public static final AppAction Button2 = new AppAction("Button2", 3, 2);
    public static final AppAction Button3 = new AppAction("Button3", 4, 3);
    public static final AppAction Button4 = new AppAction("Button4", 5, 4);

    /* compiled from: DeviceUtils.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final AppAction parse$watch_release(int r4) {
            Object obj;
            boolean z;
            Iterator<E> it = AppAction.getEntries().iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (((AppAction) obj).getId() == r4) {
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
            AppAction appAction = (AppAction) obj;
            if (appAction == null) {
                return AppAction.Unknown;
            }
            return appAction;
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ AppAction[] $values() {
        return new AppAction[]{Unknown, AppStart, Button1, Button2, Button3, Button4, Button5, ButtonLast, NotificationDismiss, ChronoStart, ChronoExit, ChronoLap, ChronoStop, ChronoResume, ChronoReset, ChronoReview, ChronoBack, MusicStartPause, MusicPrev, MusicNext, WorkoutWalk, WorkoutRun, WorkoutBike, WorkoutOthers, WorkoutStart, WorkoutPause, WorkoutResume, WorkoutStop, WorkoutSave, WorkoutDiscard, WorkoutDiscardYes, WorkoutDiscardNo, CallAnswer, CallDecline, CallHangUp, CallMute, CallLoudSpeaker, TimerMinuteSelect, TimerAddTime, TimerReset, EvPlaceholder1, EvPlaceholder2, EvPlaceholder3, EvPlaceholder4, MusicVolumeUp, MusicVolumeDown, AlarmDismiss, AlarmSelect, BottomPusher};
    }

    static {
        AppAction appAction = new AppAction("Button5", 6, 5);
        Button5 = appAction;
        ButtonLast = new AppAction("ButtonLast", 7, appAction.id);
        NotificationDismiss = new AppAction("NotificationDismiss", 8, 6);
        ChronoStart = new AppAction("ChronoStart", 9, 7);
        ChronoExit = new AppAction("ChronoExit", 10, 8);
        ChronoLap = new AppAction("ChronoLap", 11, 9);
        ChronoStop = new AppAction("ChronoStop", 12, 10);
        ChronoResume = new AppAction("ChronoResume", 13, 11);
        ChronoReset = new AppAction("ChronoReset", 14, 12);
        ChronoReview = new AppAction("ChronoReview", 15, 13);
        ChronoBack = new AppAction("ChronoBack", 16, 14);
        MusicStartPause = new AppAction("MusicStartPause", 17, 15);
        MusicPrev = new AppAction("MusicPrev", 18, 16);
        MusicNext = new AppAction(TipsAndTricksConstants.MUSIC_NEXT_NAME, 19, 17);
        WorkoutWalk = new AppAction("WorkoutWalk", 20, 18);
        WorkoutRun = new AppAction("WorkoutRun", 21, 19);
        WorkoutBike = new AppAction("WorkoutBike", 22, 20);
        WorkoutOthers = new AppAction("WorkoutOthers", 23, 21);
        WorkoutStart = new AppAction("WorkoutStart", 24, 22);
        WorkoutPause = new AppAction("WorkoutPause", 25, 23);
        WorkoutResume = new AppAction("WorkoutResume", 26, 24);
        WorkoutStop = new AppAction("WorkoutStop", 27, 25);
        WorkoutSave = new AppAction("WorkoutSave", 28, 26);
        WorkoutDiscard = new AppAction("WorkoutDiscard", 29, 27);
        WorkoutDiscardYes = new AppAction("WorkoutDiscardYes", 30, 28);
        WorkoutDiscardNo = new AppAction("WorkoutDiscardNo", 31, 29);
        CallAnswer = new AppAction("CallAnswer", 32, 30);
        CallDecline = new AppAction("CallDecline", 33, 31);
        CallHangUp = new AppAction("CallHangUp", 34, 32);
        CallMute = new AppAction("CallMute", 35, 33);
        CallLoudSpeaker = new AppAction("CallLoudSpeaker", 36, 34);
        TimerMinuteSelect = new AppAction("TimerMinuteSelect", 37, 35);
        TimerAddTime = new AppAction("TimerAddTime", 38, 36);
        TimerReset = new AppAction("TimerReset", 39, 37);
        EvPlaceholder1 = new AppAction("EvPlaceholder1", 40, 38);
        EvPlaceholder2 = new AppAction("EvPlaceholder2", 41, 39);
        EvPlaceholder3 = new AppAction("EvPlaceholder3", 42, 40);
        EvPlaceholder4 = new AppAction("EvPlaceholder4", 43, 41);
        MusicVolumeUp = new AppAction("MusicVolumeUp", 44, 42);
        MusicVolumeDown = new AppAction("MusicVolumeDown", 45, 43);
        AlarmDismiss = new AppAction("AlarmDismiss", 46, 44);
        AlarmSelect = new AppAction("AlarmSelect", 47, 45);
        BottomPusher = new AppAction("BottomPusher", 48, 46);
        AppAction[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        Companion = new Companion(null);
    }

    private AppAction(String str, int r2, int r3) {
        this.id = r3;
    }

    public static EnumEntries<AppAction> getEntries() {
        return $ENTRIES;
    }

    public static AppAction valueOf(String str) {
        return (AppAction) Enum.valueOf(AppAction.class, str);
    }

    public static AppAction[] values() {
        return (AppAction[]) $VALUES.clone();
    }

    public final int getId() {
        return this.id;
    }
}
