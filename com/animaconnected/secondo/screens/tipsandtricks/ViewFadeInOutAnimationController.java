package com.animaconnected.secondo.screens.tipsandtricks;

import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ViewFadeInOutAnimationController.kt */
/* loaded from: classes3.dex */
public final class ViewFadeInOutAnimationController {
    public static final int $stable = 8;
    private final View animationView;
    private final float fadeInFraction;
    private final long fadeInOutDuration;
    private final float fadeOutAlpha;
    private final float fadeOutFraction;
    private boolean fadedIn;

    public ViewFadeInOutAnimationController(View animationView, float f, float f2, long j, float f3, boolean z) {
        Intrinsics.checkNotNullParameter(animationView, "animationView");
        this.animationView = animationView;
        this.fadeInFraction = f;
        this.fadeOutFraction = f2;
        this.fadeInOutDuration = j;
        this.fadeOutAlpha = f3;
        this.fadedIn = true;
        if (z) {
            animationView.setAlpha(f3);
            this.fadedIn = false;
        }
    }

    private final void startFadeIn() {
        this.animationView.animate().alpha(1.0f).setDuration(this.fadeInOutDuration).setInterpolator(new AccelerateDecelerateInterpolator()).setListener(null);
    }

    private final void startFadeOut() {
        this.animationView.animate().alpha(this.fadeOutAlpha).setDuration(this.fadeInOutDuration).setInterpolator(new AccelerateDecelerateInterpolator()).setListener(null);
    }

    public final void update(float f) {
        if (f > this.fadeInFraction && f < this.fadeOutFraction) {
            if (!this.fadedIn) {
                startFadeIn();
                this.fadedIn = true;
                return;
            }
            return;
        }
        if (this.fadedIn) {
            startFadeOut();
            this.fadedIn = false;
        }
    }
}
