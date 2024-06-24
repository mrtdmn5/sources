package com.animaconnected.secondo.screens.settings.profile;

import android.content.Context;
import com.animaconnected.secondo.screens.BottomSheetKt;
import com.animaconnected.watch.fitness.FitnessProvider;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ProfileDateOfBirthDialog.kt */
/* loaded from: classes3.dex */
public final class ProfileDateOfBirthDialogKt {
    public static final void showDateOfBirthDialog(Context context, FitnessProvider.Profile profile, Function1<? super Long, Unit> picked) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(profile, "profile");
        Intrinsics.checkNotNullParameter(picked, "picked");
        BottomSheetKt.createBottomDialog(context, new ProfileDateOfBirthDialogKt$showDateOfBirthDialog$1(profile, picked)).show();
    }
}
