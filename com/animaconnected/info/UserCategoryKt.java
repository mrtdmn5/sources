package com.animaconnected.info;

import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;

/* compiled from: UserCategory.kt */
/* loaded from: classes.dex */
public final class UserCategoryKt {
    public static final boolean allowAnyPascalFirmware(UserCategory userCategory) {
        Intrinsics.checkNotNullParameter(userCategory, "<this>");
        return anyOf(userCategory, UserCategory.Develop);
    }

    public static final boolean anyOf(UserCategory userCategory, UserCategory... category) {
        Intrinsics.checkNotNullParameter(userCategory, "<this>");
        Intrinsics.checkNotNullParameter(category, "category");
        return ArraysKt___ArraysKt.toList(category).contains(userCategory);
    }

    public static final boolean attachAppLogsToCrashZip(UserCategory userCategory) {
        Intrinsics.checkNotNullParameter(userCategory, "<this>");
        return anyOf(userCategory, UserCategory.Pretest, UserCategory.Develop, UserCategory.Internal);
    }

    public static final boolean debugMenuEnabled(UserCategory userCategory) {
        Intrinsics.checkNotNullParameter(userCategory, "<this>");
        return anyOf(userCategory, UserCategory.Pretest, UserCategory.Develop, UserCategory.Internal);
    }

    public static final int diagnosticsReportIntervalInSeconds(UserCategory userCategory) {
        long coerceIn;
        Intrinsics.checkNotNullParameter(userCategory, "<this>");
        if (anyOf(userCategory, UserCategory.Pretest, UserCategory.Develop, UserCategory.Internal, UserCategory.Dogfooding)) {
            int r9 = Duration.$r8$clinit;
            long duration = DurationKt.toDuration(1, DurationUnit.HOURS);
            DurationUnit unit = DurationUnit.SECONDS;
            Intrinsics.checkNotNullParameter(unit, "unit");
            coerceIn = RangesKt___RangesKt.coerceIn(Duration.m1689toLongimpl(duration, unit), -2147483648L, 2147483647L);
        } else {
            int r92 = Duration.$r8$clinit;
            long duration2 = DurationKt.toDuration(1, DurationUnit.DAYS);
            DurationUnit unit2 = DurationUnit.SECONDS;
            Intrinsics.checkNotNullParameter(unit2, "unit");
            coerceIn = RangesKt___RangesKt.coerceIn(Duration.m1689toLongimpl(duration2, unit2), -2147483648L, 2147483647L);
        }
        return (int) coerceIn;
    }

    public static final boolean useDogfoodingLogger(UserCategory userCategory) {
        Intrinsics.checkNotNullParameter(userCategory, "<this>");
        return anyOf(userCategory, UserCategory.Pretest, UserCategory.Develop, UserCategory.Internal, UserCategory.Dogfooding);
    }
}
