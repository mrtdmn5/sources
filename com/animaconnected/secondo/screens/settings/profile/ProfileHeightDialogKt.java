package com.animaconnected.secondo.screens.settings.profile;

import android.content.Context;
import com.animaconnected.secondo.screens.BottomSheetKt;
import com.animaconnected.watch.fitness.FitnessProvider;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* compiled from: ProfileHeightDialog.kt */
/* loaded from: classes3.dex */
public final class ProfileHeightDialogKt {
    private static final int defaultHeightMm = 1700;
    private static final IntRange cmRange = new IntRange(30, 250);
    private static final IntRange inchesRange = new IntRange(0, 11);
    private static final IntRange feetRange = new IntRange(1, 8);

    public static final void showHeightDialog(Context context, FitnessProvider.Profile profile, Function1<? super Integer, Unit> picked) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(profile, "profile");
        Intrinsics.checkNotNullParameter(picked, "picked");
        if (profile.getMeasurement() == FitnessProvider.Profile.Measurement.Metric) {
            showMetricHeightDialog(context, profile, picked);
        } else {
            showImperialHeightDialog(context, profile, picked);
        }
    }

    private static final void showImperialHeightDialog(Context context, FitnessProvider.Profile profile, Function1<? super Integer, Unit> function1) {
        BottomSheetKt.createBottomDialog(context, new ProfileHeightDialogKt$showImperialHeightDialog$1(profile, function1)).show();
    }

    private static final void showMetricHeightDialog(Context context, FitnessProvider.Profile profile, Function1<? super Integer, Unit> function1) {
        BottomSheetKt.createBottomDialog(context, new ProfileHeightDialogKt$showMetricHeightDialog$1(profile, function1)).show();
    }
}
