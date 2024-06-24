package com.animaconnected.secondo.utils.animations;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.lifecycle.LifecycleCoroutineScopeImpl;
import com.animaconnected.secondo.screens.BaseFragment;
import com.animaconnected.secondo.screens.details.OnDismissedListener;
import com.animaconnected.secondo.utils.ViewKt;
import com.google.common.collect.Hashing;
import com.kronaby.watch.app.R;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.internal.MainDispatcherLoader;
import kotlinx.coroutines.scheduling.DefaultScheduler;

/* compiled from: AnimationFactoryKotlin.kt */
/* loaded from: classes3.dex */
public final class AnimationFactoryKotlinKt {
    public static final String BOTTOM = "BOTTOM";
    public static final String LEFT = "LEFT";
    public static final String RIGHT = "RIGHT";
    public static final String SHOULD_REVEAL = "SHOULD_REVEAL";
    public static final String TOP = "TOP";
    private static final float endScale = 0.9f;
    private static final Rect fullScreenRect = new Rect(0, 0, 0, 0);
    private static boolean isTransitionRunning = false;
    private static final float startScale = 1.0f;

    public static final void enterCardRevealAnim(BaseFragment baseFragment, View viewToReveal, View viewAnimContainer, Rect startViewRect) {
        Intrinsics.checkNotNullParameter(baseFragment, "<this>");
        Intrinsics.checkNotNullParameter(viewToReveal, "viewToReveal");
        Intrinsics.checkNotNullParameter(viewAnimContainer, "viewAnimContainer");
        Intrinsics.checkNotNullParameter(startViewRect, "startViewRect");
        BaseFragment currentFragment = getCurrentFragment(baseFragment);
        if (currentFragment == null) {
            return;
        }
        View requireView = currentFragment.requireView();
        Intrinsics.checkNotNullExpressionValue(requireView, "requireView(...)");
        viewAnimContainer.setAlpha(startScale);
        registerCardRevealAnimation(viewToReveal, viewAnimContainer, requireView, startViewRect);
    }

    public static final void exitCardRevealAnim(BaseFragment baseFragment, View viewToReveal, View viewAnimContainer, Rect cardBounds, final OnDismissedListener onDismissedListener) {
        Intrinsics.checkNotNullParameter(baseFragment, "<this>");
        Intrinsics.checkNotNullParameter(viewToReveal, "viewToReveal");
        Intrinsics.checkNotNullParameter(viewAnimContainer, "viewAnimContainer");
        Intrinsics.checkNotNullParameter(cardBounds, "cardBounds");
        BaseFragment currentFragment = getCurrentFragment(baseFragment);
        if (currentFragment == null) {
            return;
        }
        View requireView = currentFragment.requireView();
        Intrinsics.checkNotNullExpressionValue(requireView, "requireView(...)");
        viewAnimContainer.setAlpha(startScale);
        final Function0 function0 = null;
        registerCardCloseAnimation(viewToReveal, viewAnimContainer, requireView, cardBounds, new AnimationFinishedListener() { // from class: com.animaconnected.secondo.utils.animations.AnimationFactoryKotlinKt$$ExternalSyntheticLambda0
            @Override // com.animaconnected.secondo.utils.animations.AnimationFinishedListener
            public final void onAnimationFinished() {
                AnimationFactoryKotlinKt.exitCardRevealAnim$lambda$5(OnDismissedListener.this);
            }
        }, new Function0<Unit>() { // from class: com.animaconnected.secondo.utils.animations.AnimationFactoryKotlinKt$exitCardRevealAnim$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Function0<Unit> function02 = function0;
                if (function02 != null) {
                    function02.invoke();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void exitCardRevealAnim$lambda$5(OnDismissedListener onDismissedListener) {
        if (onDismissedListener != null) {
            onDismissedListener.onDismissed();
        }
    }

    private static final BaseFragment getCurrentFragment(BaseFragment baseFragment) {
        Fragment fragment;
        FragmentManager supportFragmentManager;
        FragmentActivity activity = baseFragment.getActivity();
        if (activity != null && (supportFragmentManager = activity.getSupportFragmentManager()) != null) {
            fragment = supportFragmentManager.findFragmentById(R.id.content);
        } else {
            fragment = null;
        }
        if (!(fragment instanceof BaseFragment)) {
            return null;
        }
        return (BaseFragment) fragment;
    }

    private static final void registerCardCloseAnimation(final View view, View view2, View view3, Rect rect, final AnimationFinishedListener animationFinishedListener, final Function0<Unit> function0) {
        FastOutSlowInInterpolator fastOutSlowInInterpolator = new FastOutSlowInInterpolator();
        Rect rect2 = fullScreenRect;
        view3.getDrawingRect(rect2);
        ObjectAnimator clipAnimator = AnimatorsKt.clipAnimator(view, rect2, rect, 250L, fastOutSlowInInterpolator);
        clipAnimator.addListener(new Animator.AnimatorListener() { // from class: com.animaconnected.secondo.utils.animations.AnimationFactoryKotlinKt$registerCardCloseAnimation$lambda$2$$inlined$doOnEnd$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ViewKt.gone(view);
                animationFinishedListener.onAnimationFinished();
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
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(clipAnimator, AnimatorsKt.scaleAnimator(view3, endScale, startScale, 250L, fastOutSlowInInterpolator), AnimatorsKt.fadeInAnimator(view2, 250L, fastOutSlowInInterpolator));
        animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.animaconnected.secondo.utils.animations.AnimationFactoryKotlinKt$registerCardCloseAnimation$lambda$4$$inlined$doOnEnd$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                Function0 function02 = Function0.this;
                if (function02 != null) {
                    function02.invoke();
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
        animatorSet.start();
    }

    public static /* synthetic */ void registerCardCloseAnimation$default(View view, View view2, View view3, Rect rect, AnimationFinishedListener animationFinishedListener, Function0 function0, int r12, Object obj) {
        if ((r12 & 32) != 0) {
            function0 = null;
        }
        registerCardCloseAnimation(view, view2, view3, rect, animationFinishedListener, function0);
    }

    @SuppressLint({"Recycle"})
    private static final void registerCardRevealAnimation(View view, View view2, View view3, Rect rect) {
        FastOutSlowInInterpolator fastOutSlowInInterpolator = new FastOutSlowInInterpolator();
        Rect rect2 = fullScreenRect;
        view3.getDrawingRect(rect2);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(AnimatorsKt.fadeOutAnimator(view2, 300L, fastOutSlowInInterpolator), AnimatorsKt.clipAnimator(view, rect, rect2, 300L, fastOutSlowInInterpolator), AnimatorsKt.scaleAnimator(view3, startScale, endScale, 300L, fastOutSlowInInterpolator));
        animatorSet.start();
    }

    public static final void registerCircularRevealAnimation(final Context context, View view, final int r10, final int r11, final int r12, final int r13, final View animationView) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(animationView, "animationView");
        view.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.animaconnected.secondo.utils.animations.AnimationFactoryKotlinKt$registerCircularRevealAnimation$1
            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View v, int r8, int r9, int r102, int r112, int r122, int r132, int r14, int r15) {
                Intrinsics.checkNotNullParameter(v, "v");
                v.removeOnLayoutChangeListener(this);
                int integer = context.getResources().getInteger(android.R.integer.config_mediumAnimTime);
                int r92 = r12;
                int r103 = r13;
                Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(v, r10, r11, 0.0f, (float) Math.sqrt((r103 * r103) + (r92 * r92)));
                long j = integer;
                createCircularReveal.setDuration(j);
                createCircularReveal.setInterpolator(new AccelerateDecelerateInterpolator());
                createCircularReveal.start();
                animationView.setAlpha(0.0f);
                long j2 = (long) (integer * 0.6d);
                ObjectAnimator fadeInAnimator$default = AnimatorsKt.fadeInAnimator$default(animationView, j - j2, null, 2, null);
                fadeInAnimator$default.setInterpolator(new DecelerateInterpolator());
                fadeInAnimator$default.setStartDelay(j2);
                fadeInAnimator$default.start();
            }
        });
    }

    public static final void setupAnimVariables(BaseFragment baseFragment, Rect rect, boolean z) {
        Intrinsics.checkNotNullParameter(baseFragment, "<this>");
        Intrinsics.checkNotNullParameter(rect, "rect");
        Bundle arguments = baseFragment.getArguments();
        if (arguments == null) {
            arguments = new Bundle();
        }
        arguments.putInt(LEFT, rect.left);
        arguments.putInt(TOP, rect.top);
        arguments.putInt(RIGHT, rect.right);
        arguments.putInt(BOTTOM, rect.bottom);
        arguments.putBoolean(SHOULD_REVEAL, z);
        baseFragment.setArguments(arguments);
    }

    public static final void startCardTransition(BaseFragment baseFragment, View contentView, BaseFragment destination) {
        Intrinsics.checkNotNullParameter(baseFragment, "<this>");
        Intrinsics.checkNotNullParameter(contentView, "contentView");
        Intrinsics.checkNotNullParameter(destination, "destination");
        if (isTransitionRunning) {
            return;
        }
        LifecycleCoroutineScopeImpl lifecycleScope = Hashing.getLifecycleScope(baseFragment);
        DefaultScheduler defaultScheduler = Dispatchers.Default;
        BuildersKt.launch$default(lifecycleScope, MainDispatcherLoader.dispatcher, null, new AnimationFactoryKotlinKt$startCardTransition$1(contentView, baseFragment, destination, null), 2);
    }

    public static final void startCircularRevealExitAnimation(Context context, final View view, int r8, int r9, int r10, int r11, View view2, final AnimationFinishedListener listener) {
        ObjectAnimator fadeOutAnimator$default;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(listener, "listener");
        float sqrt = (float) Math.sqrt((r11 * r11) + (r10 * r10));
        long integer = context.getResources().getInteger(android.R.integer.config_mediumAnimTime);
        Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(view, r8, r9, sqrt, 0.0f);
        createCircularReveal.setDuration(integer);
        createCircularReveal.setInterpolator(new AccelerateDecelerateInterpolator());
        createCircularReveal.addListener(new Animator.AnimatorListener() { // from class: com.animaconnected.secondo.utils.animations.AnimationFactoryKotlinKt$startCircularRevealExitAnimation$lambda$8$$inlined$doOnEnd$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ViewKt.gone(view);
                listener.onAnimationFinished();
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
        createCircularReveal.start();
        if (view2 != null && (fadeOutAnimator$default = AnimatorsKt.fadeOutAnimator$default(view2, integer, null, 2, null)) != null) {
            fadeOutAnimator$default.setInterpolator(new DecelerateInterpolator());
            fadeOutAnimator$default.start();
        }
    }
}
