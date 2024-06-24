package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class Fade extends Visibility {

    /* loaded from: classes.dex */
    public static class FadeAnimatorListener extends AnimatorListenerAdapter {
        public boolean mLayerTypeChanged = false;
        public final View mView;

        public FadeAnimatorListener(View view) {
            this.mView = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            ViewUtilsApi23 viewUtilsApi23 = ViewUtils.IMPL;
            View view = this.mView;
            viewUtilsApi23.setTransitionAlpha(view, 1.0f);
            if (this.mLayerTypeChanged) {
                view.setLayerType(0, null);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator animator) {
            WeakHashMap<View, ViewPropertyAnimatorCompat> weakHashMap = ViewCompat.sViewPropertyAnimatorMap;
            View view = this.mView;
            if (ViewCompat.Api16Impl.hasOverlappingRendering(view) && view.getLayerType() == 0) {
                this.mLayerTypeChanged = true;
                view.setLayerType(2, null);
            }
        }
    }

    public Fade(int r2) {
        if ((r2 & (-4)) == 0) {
            this.mMode = r2;
            return;
        }
        throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
    }

    @Override // androidx.transition.Transition
    public final void captureStartValues(TransitionValues transitionValues) {
        captureValues(transitionValues);
        transitionValues.values.put("android:fade:transitionAlpha", Float.valueOf(ViewUtils.IMPL.getTransitionAlpha(transitionValues.view)));
    }

    public final ObjectAnimator createAnimation(final View view, float f, float f2) {
        if (f == f2) {
            return null;
        }
        ViewUtils.IMPL.setTransitionAlpha(view, f);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, ViewUtils.TRANSITION_ALPHA, f2);
        ofFloat.addListener(new FadeAnimatorListener(view));
        addListener(new TransitionListenerAdapter() { // from class: androidx.transition.Fade.1
            @Override // androidx.transition.Transition.TransitionListener
            public final void onTransitionEnd(Transition transition) {
                ViewUtilsApi23 viewUtilsApi23 = ViewUtils.IMPL;
                viewUtilsApi23.setTransitionAlpha(view, 1.0f);
                viewUtilsApi23.getClass();
                transition.removeListener(this);
            }
        });
        return ofFloat;
    }
}
