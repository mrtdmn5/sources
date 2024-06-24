package com.animaconnected.watch.fitness;

import com.amazonaws.mobileconnectors.s3.transferutility.TransferTable;
import com.animaconnected.firebase.AnalyticsConstants;
import java.util.Iterator;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: FitnessMetric.kt */
/* loaded from: classes3.dex */
public final class FitnessMetric {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ FitnessMetric[] $VALUES;
    public static final Companion Companion;
    private final String metric;
    public static final FitnessMetric Unknow = new FitnessMetric("Unknow", 0, "unknow");
    public static final FitnessMetric Timestamp = new FitnessMetric("Timestamp", 1, AnalyticsConstants.KEY_TIMESTAMP);
    public static final FitnessMetric Counter = new FitnessMetric("Counter", 2, "counter");
    public static final FitnessMetric ActivityClass = new FitnessMetric("ActivityClass", 3, "activity_class");
    public static final FitnessMetric Steps = new FitnessMetric("Steps", 4, "steps");
    public static final FitnessMetric WalkSteps = new FitnessMetric("WalkSteps", 5, "walk_steps");
    public static final FitnessMetric RunSteps = new FitnessMetric("RunSteps", 6, "run_steps");
    public static final FitnessMetric OtherSteps = new FitnessMetric("OtherSteps", 7, "other_steps");
    public static final FitnessMetric EnergyExpenditure = new FitnessMetric("EnergyExpenditure", 8, "energy_expenditure");
    public static final FitnessMetric Cadence = new FitnessMetric("Cadence", 9, "cadence");
    public static final FitnessMetric Speed = new FitnessMetric("Speed", 10, TransferTable.COLUMN_SPEED);
    public static final FitnessMetric Distance = new FitnessMetric("Distance", 11, "total_distance");
    public static final FitnessMetric Heartrate = new FitnessMetric("Heartrate", 12, "heartrate");
    public static final FitnessMetric HeartrateLow = new FitnessMetric("HeartrateLow", 13, "heartrate_low");
    public static final FitnessMetric HeartrateHigh = new FitnessMetric("HeartrateHigh", 14, "heartrate_high");
    public static final FitnessMetric RestingHeartrate = new FitnessMetric("RestingHeartrate", 15, "resting_hr");
    public static final FitnessMetric FitnessIndex = new FitnessMetric("FitnessIndex", 16, "vo2max");
    public static final FitnessMetric Stress = new FitnessMetric("Stress", 17, "stress");
    public static final FitnessMetric SleepTime = new FitnessMetric("SleepTime", 18, "sleep_time");
    public static final FitnessMetric SleepState = new FitnessMetric("SleepState", 19, "sleep_state");
    public static final FitnessMetric Stand = new FitnessMetric("Stand", 20, "stand");
    public static final FitnessMetric Exercise = new FitnessMetric("Exercise", 21, "exercise");
    public static final FitnessMetric SessionEvent = new FitnessMetric("SessionEvent", 22, "session_event");
    public static final FitnessMetric SessionType = new FitnessMetric("SessionType", 23, AnalyticsConstants.KEY_SESSION_TYPE);
    public static final FitnessMetric SessionGps = new FitnessMetric("SessionGps", 24, "session_gps");
    public static final FitnessMetric SessionId = new FitnessMetric("SessionId", 25, "session_id");
    public static final FitnessMetric SessionState = new FitnessMetric("SessionState", 26, "session_state");
    public static final FitnessMetric DebugEvent = new FitnessMetric("DebugEvent", 27, "debug");
    public static final FitnessMetric DiagnosticsEvent = new FitnessMetric("DiagnosticsEvent", 28, "diagnostics");
    public static final FitnessMetric Power = new FitnessMetric("Power", 29, "power");
    public static final FitnessMetric Wrist = new FitnessMetric("Wrist", 30, "worn");
    public static final FitnessMetric SpeedCalibration = new FitnessMetric("SpeedCalibration", 31, "speed_calib_coeff");

    /* compiled from: FitnessMetric.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final FitnessMetric parse(String metric) {
            Object obj;
            Intrinsics.checkNotNullParameter(metric, "metric");
            Iterator<E> it = FitnessMetric.getEntries().iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (Intrinsics.areEqual(((FitnessMetric) obj).getMetric(), metric)) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            FitnessMetric fitnessMetric = (FitnessMetric) obj;
            if (fitnessMetric == null) {
                return FitnessMetric.Unknow;
            }
            return fitnessMetric;
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ FitnessMetric[] $values() {
        return new FitnessMetric[]{Unknow, Timestamp, Counter, ActivityClass, Steps, WalkSteps, RunSteps, OtherSteps, EnergyExpenditure, Cadence, Speed, Distance, Heartrate, HeartrateLow, HeartrateHigh, RestingHeartrate, FitnessIndex, Stress, SleepTime, SleepState, Stand, Exercise, SessionEvent, SessionType, SessionGps, SessionId, SessionState, DebugEvent, DiagnosticsEvent, Power, Wrist, SpeedCalibration};
    }

    static {
        FitnessMetric[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        Companion = new Companion(null);
    }

    private FitnessMetric(String str, int r2, String str2) {
        this.metric = str2;
    }

    public static EnumEntries<FitnessMetric> getEntries() {
        return $ENTRIES;
    }

    public static FitnessMetric valueOf(String str) {
        return (FitnessMetric) Enum.valueOf(FitnessMetric.class, str);
    }

    public static FitnessMetric[] values() {
        return (FitnessMetric[]) $VALUES.clone();
    }

    public final String getMetric() {
        return this.metric;
    }
}
