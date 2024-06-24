package com.animaconnected.secondo.screens.onboarding;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import com.animaconnected.secondo.provider.ThemeProviderBase;
import com.animaconnected.secondo.widget.WatchLayout;
import com.kronaby.watch.app.R;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OnboardingWatchAnimationsLayout.kt */
/* loaded from: classes3.dex */
public final class OnboardingWatchAnimationsLayout extends WatchLayout {
    private static final float ANGLE_HOURS_INIT_START = 300.0f;
    private static final float ANGLE_MINUTES_INIT_START = 60.0f;
    private static final int ARROW_ANIMATION_DURATION = 1200;
    private static final int ARROW_FADE_IN_OUT = 1000;
    private static final int ARROW_FADE_OUT_DELAY = 500;
    private static final int ARROW_SPAN_DP = 5;
    private static final int BUTTON_ANIMATION_DURATION = 1500;
    private static final int BUTTON_DELAY = 300;
    private static final int BUTTON_OUT_ANIMATIONS = 3;
    private static final int BUTTON_SPAN_DP = 5;
    private static final float MAX_ANGLE = 360.0f;
    public static final long WATCH_HANDS_CANCEL_DURATION = 2592;
    private static final int WATCH_HAND_HOURS_ANIMATION_DURATION = 17280;
    private static final int WATCH_HAND_MINUTES_ANIMATION_DURATION = 4320;
    private AnimatorSet buttonAndArrowInAnimatorSet;
    private AnimatorSet buttonAndArrowOutAnimatorSet;
    private int buttonOutAnimationsIndex;
    private CancelAnimationsStartedCallback cancelAnimationsStartedCallback;
    private boolean cancelledButtonAndArrowAnimations;
    private ImageView imageViewArrow;
    private ImageView imageViewButton;
    private boolean onSizeChangedCalled;
    private final int sArrowOffset;
    private final int sButtonOffset;
    private boolean shouldCancelMinutesAnimations;
    private boolean shouldCancelWatchHandAnimations;
    private boolean shouldStartButtonAndArrowAnimation;
    private boolean shouldStartWatchHandAnimations;
    private ObjectAnimator watchHandHoursAnimator;
    private ObjectAnimator watchHandMinutesAnimator;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: OnboardingWatchAnimationsLayout.kt */
    /* loaded from: classes3.dex */
    public interface CancelAnimationsStartedCallback {
        void cancelAnimationsStarted();
    }

    /* compiled from: OnboardingWatchAnimationsLayout.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public OnboardingWatchAnimationsLayout(Context context) {
        this(context, null, 0, 6, null);
    }

    private final void cancelButtonAndArrowAnimationsIfNeeded() {
        AnimatorSet animatorSet = this.buttonAndArrowInAnimatorSet;
        if (animatorSet != null) {
            animatorSet.removeAllListeners();
        }
        AnimatorSet animatorSet2 = this.buttonAndArrowInAnimatorSet;
        if (animatorSet2 != null) {
            animatorSet2.cancel();
        }
        AnimatorSet animatorSet3 = this.buttonAndArrowOutAnimatorSet;
        if (animatorSet3 != null) {
            animatorSet3.removeAllListeners();
        }
        AnimatorSet animatorSet4 = this.buttonAndArrowOutAnimatorSet;
        if (animatorSet4 != null) {
            animatorSet4.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startButtonAndArrowInAnimation(boolean z) {
        cancelButtonAndArrowAnimationsIfNeeded();
        AnimatorSet animatorSet = this.buttonAndArrowInAnimatorSet;
        if (animatorSet != null) {
            Intrinsics.checkNotNull(animatorSet);
            if (animatorSet.isRunning()) {
                return;
            }
        }
        ImageView imageView = this.imageViewArrow;
        if (imageView != null) {
            imageView.setX(0.0f);
            ImageView imageView2 = this.imageViewArrow;
            if (imageView2 != null) {
                float[] fArr = new float[2];
                if (imageView2 != null) {
                    fArr[0] = imageView2.getX();
                    ImageView imageView3 = this.imageViewArrow;
                    if (imageView3 != null) {
                        fArr[1] = imageView3.getX() - this.sArrowOffset;
                        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView2, "x", fArr);
                        ofFloat.setDuration(1200L);
                        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
                        ImageView imageView4 = this.imageViewArrow;
                        if (imageView4 != null) {
                            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(imageView4, "alpha", 0.0f, 1.0f);
                            ofFloat2.setDuration(1000L);
                            ImageView imageView5 = this.imageViewButton;
                            if (imageView5 != null) {
                                imageView5.setX(0.0f);
                                ImageView imageView6 = this.imageViewButton;
                                if (imageView6 != null) {
                                    float[] fArr2 = new float[2];
                                    if (imageView6 != null) {
                                        fArr2[0] = imageView6.getX();
                                        ImageView imageView7 = this.imageViewButton;
                                        if (imageView7 != null) {
                                            fArr2[1] = imageView7.getX() - this.sButtonOffset;
                                            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(imageView6, "x", fArr2);
                                            ofFloat3.setDuration(1500L);
                                            ofFloat3.setInterpolator(new AccelerateDecelerateInterpolator());
                                            ofFloat3.setStartDelay(300L);
                                            AnimatorSet animatorSet2 = new AnimatorSet();
                                            if (z) {
                                                animatorSet2.playTogether(ofFloat, ofFloat2, ofFloat3);
                                            } else {
                                                animatorSet2.playTogether(ofFloat, ofFloat3);
                                            }
                                            animatorSet2.addListener(new AnimatorListenerAdapter() { // from class: com.animaconnected.secondo.screens.onboarding.OnboardingWatchAnimationsLayout$startButtonAndArrowInAnimation$1$1
                                                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                                public void onAnimationEnd(Animator animation) {
                                                    Intrinsics.checkNotNullParameter(animation, "animation");
                                                    OnboardingWatchAnimationsLayout.this.startButtonAndArrowOutAnimation();
                                                }
                                            });
                                            animatorSet2.start();
                                            this.buttonAndArrowInAnimatorSet = animatorSet2;
                                            return;
                                        }
                                        Intrinsics.throwUninitializedPropertyAccessException("imageViewButton");
                                        throw null;
                                    }
                                    Intrinsics.throwUninitializedPropertyAccessException("imageViewButton");
                                    throw null;
                                }
                                Intrinsics.throwUninitializedPropertyAccessException("imageViewButton");
                                throw null;
                            }
                            Intrinsics.throwUninitializedPropertyAccessException("imageViewButton");
                            throw null;
                        }
                        Intrinsics.throwUninitializedPropertyAccessException("imageViewArrow");
                        throw null;
                    }
                    Intrinsics.throwUninitializedPropertyAccessException("imageViewArrow");
                    throw null;
                }
                Intrinsics.throwUninitializedPropertyAccessException("imageViewArrow");
                throw null;
            }
            Intrinsics.throwUninitializedPropertyAccessException("imageViewArrow");
            throw null;
        }
        Intrinsics.throwUninitializedPropertyAccessException("imageViewArrow");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startButtonAndArrowOutAnimation() {
        AnimatorSet animatorSet = this.buttonAndArrowOutAnimatorSet;
        if (animatorSet != null) {
            Intrinsics.checkNotNull(animatorSet);
            if (animatorSet.isRunning()) {
                return;
            }
        }
        this.buttonOutAnimationsIndex++;
        ImageView imageView = this.imageViewArrow;
        if (imageView != null) {
            float[] fArr = new float[2];
            if (imageView != null) {
                fArr[0] = imageView.getX();
                ImageView imageView2 = this.imageViewArrow;
                if (imageView2 != null) {
                    fArr[1] = imageView2.getX() + this.sButtonOffset;
                    ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, "x", fArr);
                    ofFloat.setDuration(1200L);
                    ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
                    ImageView imageView3 = this.imageViewButton;
                    if (imageView3 != null) {
                        float[] fArr2 = new float[2];
                        if (imageView3 != null) {
                            fArr2[0] = imageView3.getX();
                            ImageView imageView4 = this.imageViewButton;
                            if (imageView4 != null) {
                                fArr2[1] = imageView4.getX() + this.sButtonOffset;
                                ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(imageView3, "x", fArr2);
                                ofFloat2.setDuration(1500L);
                                ofFloat2.setInterpolator(new AccelerateDecelerateInterpolator());
                                ofFloat2.setStartDelay(300L);
                                ImageView imageView5 = this.imageViewArrow;
                                if (imageView5 != null) {
                                    ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(imageView5, "alpha", 1.0f, 0.0f);
                                    ofFloat3.setDuration(1000L);
                                    ofFloat3.setStartDelay(500L);
                                    AnimatorSet animatorSet2 = new AnimatorSet();
                                    if (this.buttonOutAnimationsIndex != 3 && !this.cancelledButtonAndArrowAnimations) {
                                        animatorSet2.playTogether(ofFloat, ofFloat2);
                                    } else {
                                        animatorSet2.playTogether(ofFloat, ofFloat2, ofFloat3);
                                    }
                                    animatorSet2.addListener(new AnimatorListenerAdapter() { // from class: com.animaconnected.secondo.screens.onboarding.OnboardingWatchAnimationsLayout$startButtonAndArrowOutAnimation$1$1
                                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                        public void onAnimationEnd(Animator animation) {
                                            boolean z;
                                            ImageView imageView6;
                                            ImageView imageView7;
                                            Intrinsics.checkNotNullParameter(animation, "animation");
                                            z = OnboardingWatchAnimationsLayout.this.cancelledButtonAndArrowAnimations;
                                            boolean z2 = false;
                                            if (!z) {
                                                OnboardingWatchAnimationsLayout.this.startButtonAndArrowInAnimation(false);
                                                return;
                                            }
                                            imageView6 = OnboardingWatchAnimationsLayout.this.imageViewArrow;
                                            if (imageView6 != null) {
                                                if (imageView6.getAlpha() == 0.0f) {
                                                    z2 = true;
                                                }
                                                if (!z2) {
                                                    imageView7 = OnboardingWatchAnimationsLayout.this.imageViewArrow;
                                                    if (imageView7 != null) {
                                                        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(imageView7, "alpha", 1.0f, 0.0f);
                                                        ofFloat4.setDuration(1000L);
                                                        ofFloat4.start();
                                                        return;
                                                    }
                                                    Intrinsics.throwUninitializedPropertyAccessException("imageViewArrow");
                                                    throw null;
                                                }
                                                return;
                                            }
                                            Intrinsics.throwUninitializedPropertyAccessException("imageViewArrow");
                                            throw null;
                                        }
                                    });
                                    animatorSet2.start();
                                    this.buttonAndArrowOutAnimatorSet = animatorSet2;
                                    return;
                                }
                                Intrinsics.throwUninitializedPropertyAccessException("imageViewArrow");
                                throw null;
                            }
                            Intrinsics.throwUninitializedPropertyAccessException("imageViewButton");
                            throw null;
                        }
                        Intrinsics.throwUninitializedPropertyAccessException("imageViewButton");
                        throw null;
                    }
                    Intrinsics.throwUninitializedPropertyAccessException("imageViewButton");
                    throw null;
                }
                Intrinsics.throwUninitializedPropertyAccessException("imageViewArrow");
                throw null;
            }
            Intrinsics.throwUninitializedPropertyAccessException("imageViewArrow");
            throw null;
        }
        Intrinsics.throwUninitializedPropertyAccessException("imageViewArrow");
        throw null;
    }

    private final void startHoursAnimations() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "hoursProgress", 0.0f, 1.0f);
        ofFloat.setRepeatCount(-1);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.setDuration(17280L).start();
        this.watchHandHoursAnimator = ofFloat;
    }

    private final void startHoursCancelAnimations() {
        ImageView imageView = this.mImageViewWatchHandHours;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, "rotation", imageView.getRotation(), MAX_ANGLE);
        ofFloat.setDuration(WATCH_HANDS_CANCEL_DURATION);
        ofFloat.setInterpolator(new DecelerateInterpolator());
        ofFloat.start();
    }

    private final void startMinutesAnimations() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "minutesProgress", 0.0f, 1.0f);
        ofFloat.setRepeatCount(-1);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.setDuration(4320L).start();
        this.watchHandMinutesAnimator = ofFloat;
    }

    private final void startMinutesCancelAnimations() {
        ImageView imageView = this.mImageViewWatchHandMinutes;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, "rotation", imageView.getRotation(), MAX_ANGLE);
        ofFloat.setDuration(WATCH_HANDS_CANCEL_DURATION);
        ofFloat.setInterpolator(new DecelerateInterpolator());
        ofFloat.start();
    }

    public final void cancelButtonAndArrowAnimations() {
        this.cancelledButtonAndArrowAnimations = true;
    }

    public final void cancelWatchHandAnimations() {
        if (isWatchHandAnimationsRunning()) {
            this.shouldCancelWatchHandAnimations = true;
        }
    }

    public final boolean isWatchHandAnimationsRunning() {
        ObjectAnimator objectAnimator = this.watchHandHoursAnimator;
        if (objectAnimator != null) {
            Intrinsics.checkNotNull(objectAnimator);
            if (objectAnimator.isRunning()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.animaconnected.secondo.widget.WatchLayout, android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        View findViewById = findViewById(R.id.imageViewButton);
        ImageView imageView = (ImageView) findViewById;
        ThemeProviderBase.Companion companion = ThemeProviderBase.Companion;
        Context context = imageView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        if (companion.getBoolean(context, R.attr.onboardingAnimationButtonBelowWatchBody)) {
            imageView.setTranslationZ(-1.0f);
        }
        Intrinsics.checkNotNullExpressionValue(findViewById, "apply(...)");
        this.imageViewButton = (ImageView) findViewById;
        View findViewById2 = findViewById(R.id.imageViewArrow);
        ((ImageView) findViewById2).setAlpha(0.0f);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "apply(...)");
        this.imageViewArrow = (ImageView) findViewById2;
        this.mImageViewWatchHandHours.setRotation(ANGLE_HOURS_INIT_START);
        this.mImageViewWatchHandMinutes.setRotation(ANGLE_MINUTES_INIT_START);
    }

    @Override // com.animaconnected.secondo.widget.WatchLayout, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int r5, int r6, int r7, int r8) {
        super.onLayout(z, r5, r6, r7, r8);
        int r72 = r7 - r5;
        int paddingLeft = r72 - (getPaddingLeft() + getPaddingRight());
        ImageView imageView = this.imageViewButton;
        if (imageView != null) {
            int measuredWidth = imageView.getMeasuredWidth();
            ImageView imageView2 = this.imageViewButton;
            if (imageView2 != null) {
                int measuredHeight = imageView2.getMeasuredHeight();
                int paddingLeft2 = ((paddingLeft - measuredWidth) / 2) + getPaddingLeft();
                int paddingTop = getPaddingTop();
                int r4 = measuredWidth + paddingLeft2;
                int r82 = measuredHeight + paddingTop;
                ImageView imageView3 = this.imageViewButton;
                if (imageView3 != null) {
                    imageView3.layout(paddingLeft2, paddingTop, r4, r82);
                    ImageView imageView4 = this.imageViewArrow;
                    if (imageView4 != null) {
                        int measuredWidth2 = imageView4.getMeasuredWidth();
                        ImageView imageView5 = this.imageViewArrow;
                        if (imageView5 != null) {
                            int measuredHeight2 = imageView5.getMeasuredHeight();
                            int paddingLeft3 = ((paddingLeft - measuredWidth2) / 2) + getPaddingLeft();
                            int paddingTop2 = getPaddingTop();
                            int r42 = measuredWidth2 + paddingLeft3;
                            int r83 = measuredHeight2 + paddingTop2;
                            ImageView imageView6 = this.imageViewArrow;
                            if (imageView6 != null) {
                                imageView6.layout(paddingLeft3, paddingTop2, r42, r83);
                                return;
                            } else {
                                Intrinsics.throwUninitializedPropertyAccessException("imageViewArrow");
                                throw null;
                            }
                        }
                        Intrinsics.throwUninitializedPropertyAccessException("imageViewArrow");
                        throw null;
                    }
                    Intrinsics.throwUninitializedPropertyAccessException("imageViewArrow");
                    throw null;
                }
                Intrinsics.throwUninitializedPropertyAccessException("imageViewButton");
                throw null;
            }
            Intrinsics.throwUninitializedPropertyAccessException("imageViewButton");
            throw null;
        }
        Intrinsics.throwUninitializedPropertyAccessException("imageViewButton");
        throw null;
    }

    @Override // com.animaconnected.secondo.widget.WatchLayout, android.view.View
    public void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        if (this.shouldStartWatchHandAnimations) {
            startHoursAnimations();
            startMinutesAnimations();
            this.shouldStartWatchHandAnimations = false;
        }
        if (this.shouldStartButtonAndArrowAnimation) {
            this.buttonOutAnimationsIndex = 0;
            startButtonAndArrowInAnimation(true);
            this.shouldStartButtonAndArrowAnimation = false;
        }
        this.onSizeChangedCalled = true;
    }

    public final void resetAnimations() {
        this.mImageViewWatchHandHours.setRotation(ANGLE_HOURS_INIT_START);
        this.mImageViewWatchHandMinutes.setRotation(ANGLE_MINUTES_INIT_START);
        ImageView imageView = this.imageViewButton;
        if (imageView != null) {
            imageView.setX(0.0f);
            ImageView imageView2 = this.imageViewArrow;
            if (imageView2 != null) {
                imageView2.setX(0.0f);
                ImageView imageView3 = this.imageViewArrow;
                if (imageView3 != null) {
                    imageView3.setAlpha(0.0f);
                    return;
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("imageViewArrow");
                    throw null;
                }
            }
            Intrinsics.throwUninitializedPropertyAccessException("imageViewArrow");
            throw null;
        }
        Intrinsics.throwUninitializedPropertyAccessException("imageViewButton");
        throw null;
    }

    public final void setCancelAnimationsStartedCallback(CancelAnimationsStartedCallback cancelAnimationsStartedCallback) {
        this.cancelAnimationsStartedCallback = cancelAnimationsStartedCallback;
    }

    @SuppressLint({"AnimatorKeep"})
    public final void setHoursProgress(float f) {
        this.mImageViewWatchHandHours.setRotation(((f * MAX_ANGLE) + ANGLE_HOURS_INIT_START) % 360);
        if (this.shouldCancelWatchHandAnimations) {
            CancelAnimationsStartedCallback cancelAnimationsStartedCallback = this.cancelAnimationsStartedCallback;
            if (cancelAnimationsStartedCallback != null) {
                cancelAnimationsStartedCallback.cancelAnimationsStarted();
            }
            this.shouldCancelMinutesAnimations = true;
            ObjectAnimator objectAnimator = this.watchHandHoursAnimator;
            if (objectAnimator != null) {
                objectAnimator.cancel();
            }
            startHoursCancelAnimations();
        }
    }

    @SuppressLint({"AnimatorKeep"})
    public final void setMinutesProgress(float f) {
        this.mImageViewWatchHandMinutes.setRotation(((f * MAX_ANGLE) + ANGLE_MINUTES_INIT_START) % 360);
        if (this.shouldCancelMinutesAnimations) {
            ObjectAnimator objectAnimator = this.watchHandMinutesAnimator;
            boolean z = false;
            if (objectAnimator != null && objectAnimator.isRunning()) {
                z = true;
            }
            if (z) {
                ObjectAnimator objectAnimator2 = this.watchHandMinutesAnimator;
                if (objectAnimator2 != null) {
                    objectAnimator2.cancel();
                }
                startMinutesCancelAnimations();
            }
        }
    }

    public final void startButtonAndArrowAnimations() {
        cancelButtonAndArrowAnimationsIfNeeded();
        if (this.onSizeChangedCalled) {
            this.buttonOutAnimationsIndex = 0;
            this.cancelledButtonAndArrowAnimations = false;
            startButtonAndArrowInAnimation(true);
            return;
        }
        this.shouldStartButtonAndArrowAnimation = true;
    }

    public final void startWatchHandAnimations() {
        if (this.onSizeChangedCalled) {
            ObjectAnimator objectAnimator = this.watchHandHoursAnimator;
            if (objectAnimator != null) {
                Intrinsics.checkNotNull(objectAnimator);
                if (objectAnimator.isRunning()) {
                    return;
                }
            }
            ObjectAnimator objectAnimator2 = this.watchHandMinutesAnimator;
            if (objectAnimator2 != null) {
                Intrinsics.checkNotNull(objectAnimator2);
                if (objectAnimator2.isRunning()) {
                    return;
                }
            }
            startHoursAnimations();
            startMinutesAnimations();
            return;
        }
        this.shouldStartWatchHandAnimations = true;
    }

    public final void stopAnimations() {
        ObjectAnimator objectAnimator = this.watchHandHoursAnimator;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        ObjectAnimator objectAnimator2 = this.watchHandMinutesAnimator;
        if (objectAnimator2 != null) {
            objectAnimator2.cancel();
        }
        AnimatorSet animatorSet = this.buttonAndArrowInAnimatorSet;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
    }

    public OnboardingWatchAnimationsLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ OnboardingWatchAnimationsLayout(Context context, AttributeSet attributeSet, int r3, int r4, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (r4 & 2) != 0 ? null : attributeSet, (r4 & 4) != 0 ? 0 : r3);
    }

    public OnboardingWatchAnimationsLayout(Context context, AttributeSet attributeSet, int r3) {
        super(context, attributeSet, r3);
        this.sButtonOffset = (int) TypedValue.applyDimension(1, 5.0f, getResources().getDisplayMetrics());
        this.sArrowOffset = (int) TypedValue.applyDimension(1, 5.0f, getResources().getDisplayMetrics());
        setScalingEnabled(false);
    }
}
