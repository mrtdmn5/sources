package com.animaconnected.watch.workout.utils;

import com.animaconnected.watch.fitness.FitnessProvider;
import com.animaconnected.watch.strings.Key;
import com.animaconnected.watch.strings.StringsExtensionsKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;

/* compiled from: ProfileUtils.kt */
/* loaded from: classes3.dex */
public final class ProfileUtilsKt {
    public static final double FeetInMeters = 0.3048d;
    private static final double InchesInCm = 2.54d;
    private static final double LbsInKgs = 0.45359237d;
    public static final double MilesInMeters = 1609.344d;

    /* compiled from: ProfileUtils.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] r0 = new int[FitnessProvider.Profile.Measurement.values().length];
            try {
                r0[FitnessProvider.Profile.Measurement.Imperial.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                r0[FitnessProvider.Profile.Measurement.Metric.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = r0;
        }
    }

    public static final String formatHeight(int r1, FitnessProvider.Profile.Measurement measurement) {
        Intrinsics.checkNotNullParameter(measurement, "measurement");
        int r2 = WhenMappings.$EnumSwitchMapping$0[measurement.ordinal()];
        if (r2 != 1) {
            if (r2 == 2) {
                return (r1 / 10) + ' ' + StringsExtensionsKt.getAppString(Key.units_height_cm);
            }
            throw new NoWhenBranchMatchedException();
        }
        FeetInches mmToFeetAndInches = mmToFeetAndInches(r1);
        return mmToFeetAndInches.getFeet() + "' " + mmToFeetAndInches.getInches() + '\"';
    }

    public static final String formatWeight(int r2, FitnessProvider.Profile.Measurement measurement) {
        Intrinsics.checkNotNullParameter(measurement, "measurement");
        int r3 = WhenMappings.$EnumSwitchMapping$0[measurement.ordinal()];
        if (r3 != 1) {
            if (r3 == 2) {
                return (r2 / 1000) + ' ' + StringsExtensionsKt.getAppString(Key.units_weight_kg);
            }
            throw new NoWhenBranchMatchedException();
        }
        return gramToLbs(r2) + ' ' + StringsExtensionsKt.getAppString(Key.units_weight_lbs);
    }

    public static final int gramToLbs(int r4) {
        return MathKt__MathJVMKt.roundToInt((r4 / 1000.0d) / LbsInKgs);
    }

    private static final int inchesToMm(int r4) {
        return MathKt__MathJVMKt.roundToInt(r4 * 10.0d * InchesInCm);
    }

    public static final int lbsToGram(int r4) {
        return MathKt__MathJVMKt.roundToInt(r4 * 1000.0d * LbsInKgs);
    }

    public static final double meterToFeet(int r4) {
        return r4 / 0.3048d;
    }

    public static final double meterToMiles(double d) {
        return d / 1609.344d;
    }

    public static final FeetInches mmToFeetAndInches(int r2) {
        int mmToInches = mmToInches(r2);
        return new FeetInches(mmToInches / 12, mmToInches % 12);
    }

    private static final int mmToInches(int r4) {
        return MathKt__MathJVMKt.roundToInt((r4 / 10.0d) / InchesInCm);
    }

    public static final int toMm(FeetInches feetInches) {
        Intrinsics.checkNotNullParameter(feetInches, "<this>");
        return inchesToMm(feetInches.getInches() + (feetInches.getFeet() * 12));
    }
}
