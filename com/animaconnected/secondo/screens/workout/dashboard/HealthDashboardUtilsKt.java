package com.animaconnected.secondo.screens.workout.dashboard;

import com.animaconnected.secondo.KronabyApplication;
import com.animaconnected.watch.AndroidDateFormatter;
import com.animaconnected.watch.device.DateFormatter;
import com.animaconnected.watch.fitness.SessionType;
import com.animaconnected.watch.provider.DateTimeFormattersKt;
import com.animaconnected.watch.strings.Key;
import com.animaconnected.watch.strings.StringsExtensionsKt;
import com.animaconnected.watch.workout.SessionListItem;
import com.animaconnected.watch.workout.utils.WorkoutFormatUtilsKt;
import com.animaconnected.widget.SessionCardData;
import com.kronaby.watch.app.R;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HealthDashboardUtils.kt */
/* loaded from: classes3.dex */
public final class HealthDashboardUtilsKt {

    /* compiled from: HealthDashboardUtils.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] r0 = new int[SessionType.values().length];
            try {
                r0[SessionType.Running.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                r0[SessionType.Walking.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                r0[SessionType.Bike.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                r0[SessionType.Other.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = r0;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final SessionCardData toSessionCardData(SessionListItem sessionListItem) {
        Pair pair;
        Intrinsics.checkNotNullParameter(sessionListItem, "<this>");
        int r0 = WhenMappings.$EnumSwitchMapping$0[sessionListItem.getSessionType().ordinal()];
        boolean z = true;
        if (r0 != 1) {
            if (r0 != 2) {
                if (r0 != 3) {
                    if (r0 == 4) {
                        pair = new Pair(StringsExtensionsKt.getAppString(Key.workout_type_other), Integer.valueOf(R.drawable.ic_other));
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                } else {
                    pair = new Pair(StringsExtensionsKt.getAppString(Key.workout_type_bike), Integer.valueOf(R.drawable.ic_bike));
                }
            } else {
                pair = new Pair(StringsExtensionsKt.getAppString(Key.workout_type_walk), Integer.valueOf(R.drawable.ic_walk));
            }
        } else {
            pair = new Pair(StringsExtensionsKt.getAppString(Key.workout_type_run), Integer.valueOf(R.drawable.ic_run));
        }
        String str = (String) pair.first;
        int intValue = ((Number) pair.second).intValue();
        long timestamp = sessionListItem.getTimestamp();
        String distance = sessionListItem.getDistance();
        if (distance.length() != 0) {
            z = false;
        }
        if (z) {
            distance = sessionListItem.getTotalCalories() + ' ' + KronabyApplication.Companion.getContext().getString(R.string.health_workouts_metric_calories_total);
        }
        return new SessionCardData(timestamp, str, intValue, distance, DateFormatter.format$default(new AndroidDateFormatter(DateTimeFormattersKt.getHourMinuteFormat(), null, 2, null), sessionListItem.getTimestamp(), null, false, 6, null), sessionListItem.getTotalTime(), WorkoutFormatUtilsKt.toReadablePastDay(sessionListItem.getTimestamp(), new AndroidDateFormatter(DateTimeFormattersKt.shortMonthAndDateFormat, null, 2, null)));
    }
}
