package com.animaconnected.secondo.screens.workout.dashboard;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.TweenSpec;

/* compiled from: HealthOnboarding.kt */
/* loaded from: classes3.dex */
public final class HealthOnboardingAnimations {
    public static final int $stable = 0;
    public static final HealthOnboardingAnimations INSTANCE = new HealthOnboardingAnimations();
    public static final float alphaTarget = 0.4f;
    private static final int durationAlphaCardEnter = 500;
    private static final int durationAlphaCardExit = 400;

    private HealthOnboardingAnimations() {
    }

    private final int scrollDurationMillis(int r3, float f) {
        return (int) ((r3 / f) * 1000.0d);
    }

    public static /* synthetic */ int scrollDurationMillis$default(HealthOnboardingAnimations healthOnboardingAnimations, int r1, float f, int r3, Object obj) {
        if ((r3 & 2) != 0) {
            f = 1000.0f;
        }
        return healthOnboardingAnimations.scrollDurationMillis(r1, f);
    }

    public final TweenSpec<Float> alphaTweenSpec(boolean z) {
        int r4;
        if (z) {
            r4 = 500;
        } else {
            r4 = 400;
        }
        return AnimationSpecKt.tween$default(r4, 0, null, 6);
    }

    public final TweenSpec<Float> scrollDownTweenSpec(int r4) {
        return AnimationSpecKt.tween$default(scrollDurationMillis$default(this, r4, 0.0f, 2, null), 0, null, 6);
    }

    public final TweenSpec<Float> scrollUpTweenSpec(int r4) {
        return AnimationSpecKt.tween$default(scrollDurationMillis$default(this, r4, 0.0f, 2, null), 0, null, 6);
    }
}
