package com.animaconnected.secondo.screens.onboarding;

import android.content.Context;
import android.content.SharedPreferences;
import com.animaconnected.secondo.behaviour.distress.permission.PermissionCompat$PermissionHelper$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OnboardingStorage.kt */
/* loaded from: classes3.dex */
public final class OnboardingStorage {
    public static final int $stable = 0;
    private static final String INITIAL_ONBOARDING_STORAGE = "initialOnboardingStorage";
    public static final OnboardingStorage INSTANCE = new OnboardingStorage();
    private static final String KEY_HAS_SHOWED_WHAT_IS_NEW_ANIMATION = "showWhatIsNewAnimation";

    private OnboardingStorage() {
    }

    private final SharedPreferences getSharedPreferences(Context context) {
        return context.getSharedPreferences(INITIAL_ONBOARDING_STORAGE, 0);
    }

    public final boolean getHasShowedWhatIsNewAnimation(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return getSharedPreferences(context).getBoolean(KEY_HAS_SHOWED_WHAT_IS_NEW_ANIMATION, false);
    }

    public final void setHasShowedWhatIsNewAnimation(Context context, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        PermissionCompat$PermissionHelper$$ExternalSyntheticOutline0.m(getSharedPreferences(context), KEY_HAS_SHOWED_WHAT_IS_NEW_ANIMATION, z);
    }
}
