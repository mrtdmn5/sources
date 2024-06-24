package com.animaconnected.secondo.screens.settings.profile;

import android.content.Context;
import com.animaconnected.secondo.screens.BottomSheetKt;
import com.animaconnected.watch.fitness.FitnessProvider;
import com.animaconnected.watch.strings.Key;
import com.animaconnected.watch.strings.StringsExtensionsKt;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ProfileGenderDialog.kt */
/* loaded from: classes3.dex */
public final class ProfileGenderDialogKt {
    private static final Map<FitnessProvider.Profile.Gender, String> genderValues = MapsKt__MapsKt.mapOf(new Pair(FitnessProvider.Profile.Gender.Male, StringsExtensionsKt.getAppString(Key.profile_gender_male)), new Pair(FitnessProvider.Profile.Gender.Female, StringsExtensionsKt.getAppString(Key.profile_gender_female)), new Pair(FitnessProvider.Profile.Gender.Other, StringsExtensionsKt.getAppString(Key.profile_gender_other)));

    public static final Map<FitnessProvider.Profile.Gender, String> getGenderValues() {
        return genderValues;
    }

    public static final void showGenderDialog(Context context, FitnessProvider.Profile profile, Function1<? super FitnessProvider.Profile.Gender, Unit> picked) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(profile, "profile");
        Intrinsics.checkNotNullParameter(picked, "picked");
        BottomSheetKt.createBottomDialog(context, new ProfileGenderDialogKt$showGenderDialog$1(profile, picked)).show();
    }
}
