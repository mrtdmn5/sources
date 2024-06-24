package com.animaconnected.secondo.screens;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.PathInterpolator;
import android.widget.ImageView;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import com.animaconnected.secondo.screens.WatchViewController;
import com.animaconnected.watch.provider.DateTimeFormattersKt;
import java.util.ArrayList;
import java.util.WeakHashMap;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;

/* compiled from: WatchViewController.kt */
/* loaded from: classes3.dex */
public final class WatchViewController {
    public static final int $stable = 8;
    private int containerDefaultX;
    private int containerDefaultY;
    private boolean isInitiated;
    private final ArrayList<ObjectAnimator> objectAnimators;
    private final float shadowAlpha;
    private int shadowDefaultX;
    private int shadowDefaultY;
    private final View watchContainer;
    private final ImageView watchShadow;
    private int watchXOffset;
    private int watchYOffset;

    /* compiled from: WatchViewController.kt */
    /* loaded from: classes3.dex */
    public interface WatchViewControllerStatus {
        void onWatchViewsReady();
    }

    public WatchViewController(View watchContainer, ImageView watchShadow, float f, final WatchViewControllerStatus watchViewControllerStatus) {
        Intrinsics.checkNotNullParameter(watchContainer, "watchContainer");
        Intrinsics.checkNotNullParameter(watchShadow, "watchShadow");
        Intrinsics.checkNotNullParameter(watchViewControllerStatus, "watchViewControllerStatus");
        this.watchContainer = watchContainer;
        this.watchShadow = watchShadow;
        this.shadowAlpha = f;
        this.objectAnimators = new ArrayList<>();
        WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
        if (ViewCompat.Api19Impl.isLaidOut(watchShadow) && !watchShadow.isLayoutRequested()) {
            watchViewControllerStatus.onWatchViewsReady();
        } else {
            watchShadow.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.animaconnected.secondo.screens.WatchViewController$special$$inlined$doOnLayout$1
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
                    view.removeOnLayoutChangeListener(this);
                    WatchViewController.WatchViewControllerStatus.this.onWatchViewsReady();
                }
            });
        }
        this.isInitiated = false;
        watchContainer.setVisibility(4);
        watchShadow.setVisibility(4);
    }

    private final PathInterpolator createInterpolator() {
        return new PathInterpolator(0.25f, 0.1f, 0.25f, 1.0f);
    }

    @SuppressLint({"Recycle"})
    private final void fadeOut(long j) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.watchContainer, "alpha", 0.0f);
        Intrinsics.checkNotNullExpressionValue(ofFloat, "ofFloat(...)");
        this.objectAnimators.add(ofFloat);
        ofFloat.setInterpolator(new DecelerateInterpolator());
        ofFloat.setDuration(j);
        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.animaconnected.secondo.screens.WatchViewController$fadeOut$lambda$10$$inlined$doOnEnd$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                View view;
                view = WatchViewController.this.watchContainer;
                view.setVisibility(8);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        ofFloat.addListener(new WatchViewController$startAndRemove$$inlined$doOnEnd$1(this, ofFloat));
        ofFloat.start();
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.watchShadow, "alpha", 0.0f);
        Intrinsics.checkNotNullExpressionValue(ofFloat2, "ofFloat(...)");
        this.objectAnimators.add(ofFloat2);
        ofFloat2.setInterpolator(new DecelerateInterpolator());
        ofFloat2.setDuration(j);
        ofFloat2.addListener(new WatchViewController$startAndRemove$$inlined$doOnEnd$1(this, ofFloat2));
        ofFloat2.start();
    }

    private final void initiateIfNeeded() {
        if (this.isInitiated) {
            return;
        }
        this.watchContainer.setVisibility(0);
        this.watchShadow.setVisibility(0);
        this.containerDefaultX = MathKt__MathJVMKt.roundToInt(this.watchContainer.getX());
        this.containerDefaultY = MathKt__MathJVMKt.roundToInt(this.watchContainer.getY());
        this.shadowDefaultX = MathKt__MathJVMKt.roundToInt(this.watchShadow.getX());
        this.shadowDefaultY = MathKt__MathJVMKt.roundToInt(this.watchShadow.getY());
        this.isInitiated = true;
    }

    private final void startAndRemove(ObjectAnimator objectAnimator, Function1<? super ObjectAnimator, Unit> function1) {
        this.objectAnimators.add(objectAnimator);
        function1.invoke(objectAnimator);
        objectAnimator.addListener(new WatchViewController$startAndRemove$$inlined$doOnEnd$1(this, objectAnimator));
        objectAnimator.start();
    }

    @SuppressLint({"Recycle"})
    private final void startAnimation(float f, float f2, float f3, float f4, long j) {
        final boolean z;
        String str;
        for (ObjectAnimator objectAnimator : CollectionsKt___CollectionsKt.toList(this.objectAnimators)) {
            objectAnimator.cancel();
            objectAnimator.end();
        }
        if (f < 0.0f) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            if (this.watchContainer.getVisibility() == 8) {
                return;
            }
        } else {
            this.watchContainer.setVisibility(0);
        }
        if (this.watchContainer.getAlpha() < 0.9999d) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.watchContainer, "alpha", 1.0f);
            Intrinsics.checkNotNullExpressionValue(ofFloat, "ofFloat(...)");
            this.objectAnimators.add(ofFloat);
            ofFloat.setInterpolator(new DecelerateInterpolator());
            ofFloat.setDuration(2 * j);
            ofFloat.start();
            ofFloat.addListener(new WatchViewController$startAndRemove$$inlined$doOnEnd$1(this, ofFloat));
            ofFloat.start();
        }
        double alpha = this.watchShadow.getAlpha();
        float f5 = this.shadowAlpha;
        if (alpha >= f5 * 0.9999d) {
            str = "ofFloat(...)";
        } else {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.watchShadow, "alpha", f5);
            str = "ofFloat(...)";
            Intrinsics.checkNotNullExpressionValue(ofFloat2, str);
            this.objectAnimators.add(ofFloat2);
            ofFloat2.setInterpolator(new DecelerateInterpolator());
            ofFloat2.setDuration(2 * j);
            ofFloat2.addListener(new WatchViewController$startAndRemove$$inlined$doOnEnd$1(this, ofFloat2));
            ofFloat2.start();
        }
        if (j <= 0) {
            this.watchContainer.setX(f);
            this.watchContainer.setY(f2);
            this.watchShadow.setX(f3);
            this.watchShadow.setY(f4);
            if (z) {
                this.watchContainer.setVisibility(8);
                return;
            }
            return;
        }
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.watchContainer, "x", f);
        Intrinsics.checkNotNullExpressionValue(ofFloat3, str);
        this.objectAnimators.add(ofFloat3);
        ofFloat3.setDuration(j);
        ofFloat3.setInterpolator(createInterpolator());
        ofFloat3.addListener(new Animator.AnimatorListener() { // from class: com.animaconnected.secondo.screens.WatchViewController$startAnimation$lambda$5$$inlined$doOnEnd$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                View view;
                if (z) {
                    view = this.watchContainer;
                    view.setVisibility(8);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        ofFloat3.addListener(new WatchViewController$startAndRemove$$inlined$doOnEnd$1(this, ofFloat3));
        ofFloat3.start();
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.watchContainer, DateTimeFormattersKt.yearNoPaddingFormat, f2);
        Intrinsics.checkNotNullExpressionValue(ofFloat4, str);
        this.objectAnimators.add(ofFloat4);
        ofFloat4.setDuration(j);
        ofFloat4.setInterpolator(createInterpolator());
        ofFloat4.addListener(new WatchViewController$startAndRemove$$inlined$doOnEnd$1(this, ofFloat4));
        ofFloat4.start();
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.watchShadow, "x", f3);
        Intrinsics.checkNotNullExpressionValue(ofFloat5, str);
        this.objectAnimators.add(ofFloat5);
        ofFloat5.setDuration(j);
        ofFloat5.setInterpolator(createInterpolator());
        ofFloat5.start();
        ofFloat5.addListener(new WatchViewController$startAndRemove$$inlined$doOnEnd$1(this, ofFloat5));
        ofFloat5.start();
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.watchShadow, DateTimeFormattersKt.yearNoPaddingFormat, f4);
        Intrinsics.checkNotNullExpressionValue(ofFloat6, str);
        this.objectAnimators.add(ofFloat6);
        ofFloat6.setDuration(j);
        ofFloat6.setInterpolator(createInterpolator());
        ofFloat6.addListener(new WatchViewController$startAndRemove$$inlined$doOnEnd$1(this, ofFloat6));
        ofFloat6.start();
    }

    public final int getWatchXOffset() {
        return this.watchXOffset;
    }

    public final int getWatchYOffset() {
        return this.watchYOffset;
    }

    public final void hideWatch(int r9, int r10, boolean z) {
        initiateIfNeeded();
        float f = this.containerDefaultX - r9;
        float f2 = this.containerDefaultY;
        float f3 = this.shadowDefaultX - r9;
        float f4 = this.shadowDefaultY;
        if (z) {
            fadeOut(r10);
        } else {
            startAnimation(f, f2, f3, f4, r10);
        }
    }

    public final void updateWatchLocation(int r9, int r10, int r11) {
        initiateIfNeeded();
        this.watchXOffset = r9;
        this.watchYOffset = r10;
        startAnimation(this.containerDefaultX + r9, this.containerDefaultY + r10, this.shadowDefaultX + r9, this.shadowDefaultY, r11);
    }
}
