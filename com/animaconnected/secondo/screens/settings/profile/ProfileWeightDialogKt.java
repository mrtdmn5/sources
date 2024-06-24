package com.animaconnected.secondo.screens.settings.profile;

import android.content.Context;
import com.animaconnected.secondo.screens.BottomSheetKt;
import com.animaconnected.secondo.screens.tipsandtricks.TipsAndTricksConstants;
import com.animaconnected.watch.fitness.FitnessProvider;
import com.animaconnected.watch.workout.utils.ProfileUtilsKt;
import com.kronaby.watch.app.R;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* compiled from: ProfileWeightDialog.kt */
/* loaded from: classes3.dex */
public final class ProfileWeightDialogKt {
    private static final WeightData metricWeightData = new WeightData(new IntRange(30, TipsAndTricksConstants.MUTE_PHONE_CALL_PRIORITY), 70, R.string.units_weight_kg, new Function1<Integer, Integer>() { // from class: com.animaconnected.secondo.screens.settings.profile.ProfileWeightDialogKt$metricWeightData$1
        public final Integer invoke(int r1) {
            return Integer.valueOf(r1 * 1000);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
            return invoke(num.intValue());
        }
    }, new Function1<Integer, Integer>() { // from class: com.animaconnected.secondo.screens.settings.profile.ProfileWeightDialogKt$metricWeightData$2
        @Override // kotlin.jvm.functions.Function1
        public final Integer invoke(Integer num) {
            if (num != null) {
                return Integer.valueOf(num.intValue() / 1000);
            }
            return null;
        }
    });
    private static final WeightData imperialWeightData = new WeightData(new IntRange(66, 661), com.animaconnected.secondo.R.styleable.AppTheme_stepsHistoryHintRoundnessDetail, R.string.units_weight_lbs, new Function1<Integer, Integer>() { // from class: com.animaconnected.secondo.screens.settings.profile.ProfileWeightDialogKt$imperialWeightData$1
        public final Integer invoke(int r1) {
            return Integer.valueOf(ProfileUtilsKt.lbsToGram(r1));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Integer invoke(Integer num) {
            return invoke(num.intValue());
        }
    }, new Function1<Integer, Integer>() { // from class: com.animaconnected.secondo.screens.settings.profile.ProfileWeightDialogKt$imperialWeightData$2
        @Override // kotlin.jvm.functions.Function1
        public final Integer invoke(Integer num) {
            if (num != null) {
                return Integer.valueOf(ProfileUtilsKt.gramToLbs(num.intValue()));
            }
            return null;
        }
    });

    public static final void showWeightDialog(Context context, FitnessProvider.Profile profile, Function1<? super Integer, Unit> picked) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(profile, "profile");
        Intrinsics.checkNotNullParameter(picked, "picked");
        BottomSheetKt.createBottomDialog(context, new ProfileWeightDialogKt$showWeightDialog$1(profile, context, picked)).show();
    }
}
