package com.animaconnected.watch.behaviour.util;

import com.animaconnected.info.DeviceType;
import com.animaconnected.secondo.R;
import com.animaconnected.secondo.screens.tipsandtricks.TipsAndTricksConstants;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VibratorPatterns.kt */
/* loaded from: classes3.dex */
public final class VibratorPatterns {
    private static final Map<Strength, Map<Vibration, int[]>> fks927Patterns;
    private static final Map<Strength, Map<Vibration, int[]>> fks933Patterns;
    private static final Map<Strength, Map<Vibration, int[]>> fks934Patterns;
    private static final int fks934PauseInterval = 1200;
    private static final Map<Strength, Map<Vibration, int[]>> otherPatterns;
    public static final VibratorPatterns INSTANCE = new VibratorPatterns();
    private static final int[] distressAcknowledge = {TipsAndTricksConstants.MUTE_PHONE_CALL_PRIORITY, 100, 100, 100, TipsAndTricksConstants.MUTE_PHONE_CALL_PRIORITY};
    private static final int[] errorDistress = {100, 100, TipsAndTricksConstants.MUTE_PHONE_CALL_PRIORITY, 100, 100};
    private static final int[] enterDistress = {200, 100, 100, 2000, 200, 100, 100, 2000, 200, 100, 100};
    private static final int[] calibrationWheelTouch = {70, 30, 50};
    private static final int[] habitTrackerGoalReached = {100, 200, 80, 100, 80, 100, R.styleable.AppTheme_stepsHistoryHintRoundnessDetail};
    private static final int[] error = {R.styleable.AppTheme_statusTopStripeSetup, R.styleable.AppTheme_statusTopStripeSetup, R.styleable.AppTheme_statusTopStripeSetup};

    /* compiled from: VibratorPatterns.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] r0 = new int[DeviceType.values().length];
            try {
                r0[DeviceType.FKS927.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                r0[DeviceType.FKS933.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                r0[DeviceType.PASCAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                r0[DeviceType.PASCAL_FULL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = r0;
        }
    }

    static {
        Strength strength = Strength.Normal;
        Vibration vibration = Vibration.One;
        Pair pair = new Pair(vibration, new int[]{31, 15, 80, 15, 35, 15, 35, 15, 40, 15, 90});
        Vibration vibration2 = Vibration.Two;
        Pair pair2 = new Pair(vibration2, new int[]{31, 15, 61, 15, 110, TipsAndTricksConstants.MUTE_PHONE_CALL_PRIORITY, 31, 15, 61, 15, 110});
        Vibration vibration3 = Vibration.Three;
        Pair pair3 = new Pair(strength, MapsKt__MapsKt.mapOf(pair, pair2, new Pair(vibration3, new int[]{31, 15, 190, TipsAndTricksConstants.MUTE_PHONE_CALL_PRIORITY, 50, 15, 190, TipsAndTricksConstants.MUTE_PHONE_CALL_PRIORITY, 50, 15, 190})));
        Strength strength2 = Strength.Stronger;
        fks933Patterns = MapsKt__MapsKt.mapOf(pair3, new Pair(strength2, MapsKt__MapsKt.mapOf(new Pair(vibration, new int[]{600}), new Pair(vibration2, new int[]{400, TipsAndTricksConstants.MUTE_PHONE_CALL_PRIORITY, 400}), new Pair(vibration3, new int[]{330, 250, 330, 250, 330}))));
        fks927Patterns = MapsKt__MapsKt.mapOf(new Pair(strength, MapsKt__MapsKt.mapOf(new Pair(vibration, new int[]{R.styleable.AppTheme_stepsHistoryHintRoundnessDetail}), new Pair(vibration2, new int[]{125, TipsAndTricksConstants.MUTE_PHONE_CALL_PRIORITY, 125}), new Pair(vibration3, new int[]{125, TipsAndTricksConstants.MUTE_PHONE_CALL_PRIORITY, 125, TipsAndTricksConstants.MUTE_PHONE_CALL_PRIORITY, 125}))), new Pair(strength2, MapsKt__MapsKt.mapOf(new Pair(vibration, new int[]{200}), new Pair(vibration2, new int[]{R.styleable.AppTheme_toolbarActionTextStyle, TipsAndTricksConstants.MUTE_PHONE_CALL_PRIORITY, R.styleable.AppTheme_toolbarActionTextStyle}), new Pair(vibration3, new int[]{R.styleable.AppTheme_toolbarActionTextStyle, TipsAndTricksConstants.MUTE_PHONE_CALL_PRIORITY, R.styleable.AppTheme_toolbarActionTextStyle, TipsAndTricksConstants.MUTE_PHONE_CALL_PRIORITY, R.styleable.AppTheme_toolbarActionTextStyle}))));
        fks934Patterns = MapsKt__MapsKt.mapOf(new Pair(strength, MapsKt__MapsKt.mapOf(new Pair(vibration, new int[]{80, 15, 100, fks934PauseInterval}), new Pair(vibration2, new int[]{80, 15, 100, fks934PauseInterval}), new Pair(vibration3, new int[]{80, 15, 100, fks934PauseInterval}))), new Pair(strength2, MapsKt__MapsKt.mapOf(new Pair(vibration, new int[]{R.styleable.AppTheme_stepsHistoryHintRoundnessDetail, 15, 170, 15, 170, fks934PauseInterval}), new Pair(vibration2, new int[]{R.styleable.AppTheme_stepsHistoryHintRoundnessDetail, 15, 170, 15, 170, fks934PauseInterval}), new Pair(vibration3, new int[]{R.styleable.AppTheme_stepsHistoryHintRoundnessDetail, 15, 170, 15, 170, fks934PauseInterval}))));
        otherPatterns = MapsKt__MapsKt.mapOf(new Pair(strength, MapsKt__MapsKt.mapOf(new Pair(vibration, new int[]{50, 25, 80, 25, 35, 25, 35, 25, 40, 25, 90}), new Pair(vibration2, new int[]{31, 30, 61, 30, 110, TipsAndTricksConstants.MUTE_PHONE_CALL_PRIORITY, 31, 30, 61, 30, 110}), new Pair(vibration3, new int[]{31, 30, 190, TipsAndTricksConstants.MUTE_PHONE_CALL_PRIORITY, 50, 30, 90, TipsAndTricksConstants.MUTE_PHONE_CALL_PRIORITY, 50, 30, 90}))), new Pair(strength2, MapsKt__MapsKt.mapOf(new Pair(vibration, new int[]{600}), new Pair(vibration2, new int[]{400, TipsAndTricksConstants.MUTE_PHONE_CALL_PRIORITY, 400}), new Pair(vibration3, new int[]{330, 250, 330, 250, 330}))));
    }

    private VibratorPatterns() {
    }

    public static final int[] getCalibrationWheelTouch() {
        return calibrationWheelTouch;
    }

    public static final int[] getDistressAcknowledge() {
        return distressAcknowledge;
    }

    public static final int[] getEnterDistress() {
        return enterDistress;
    }

    public static final int[] getError() {
        return error;
    }

    public static final int[] getErrorDistress() {
        return errorDistress;
    }

    public static final int[] getHabitTrackerGoalReached() {
        return habitTrackerGoalReached;
    }

    public final int[] get(Vibration vibration, Strength strength, DeviceType deviceType) {
        Map<Strength, Map<Vibration, int[]>> map;
        Intrinsics.checkNotNullParameter(vibration, "vibration");
        Intrinsics.checkNotNullParameter(strength, "strength");
        Intrinsics.checkNotNullParameter(deviceType, "deviceType");
        int r4 = WhenMappings.$EnumSwitchMapping$0[deviceType.ordinal()];
        if (r4 != 1) {
            if (r4 != 2) {
                if (r4 != 3 && r4 != 4) {
                    map = otherPatterns;
                } else {
                    map = fks934Patterns;
                }
            } else {
                map = fks933Patterns;
            }
        } else {
            map = fks927Patterns;
        }
        Map<Vibration, int[]> map2 = map.get(strength);
        Intrinsics.checkNotNull(map2);
        int[] r2 = map2.get(vibration);
        Intrinsics.checkNotNull(r2);
        return r2;
    }

    public static /* synthetic */ void getCalibrationWheelTouch$annotations() {
    }

    public static /* synthetic */ void getDistressAcknowledge$annotations() {
    }

    public static /* synthetic */ void getEnterDistress$annotations() {
    }

    public static /* synthetic */ void getError$annotations() {
    }

    public static /* synthetic */ void getErrorDistress$annotations() {
    }

    public static /* synthetic */ void getHabitTrackerGoalReached$annotations() {
    }
}
