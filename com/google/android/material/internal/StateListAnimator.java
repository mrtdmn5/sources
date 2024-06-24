package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public final class StateListAnimator {
    public final ArrayList<Tuple> tuples = new ArrayList<>();
    public ValueAnimator runningAnimator = null;
    public final AnonymousClass1 animationListener = new AnimatorListenerAdapter() { // from class: com.google.android.material.internal.StateListAnimator.1
        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            StateListAnimator stateListAnimator = StateListAnimator.this;
            if (stateListAnimator.runningAnimator == animator) {
                stateListAnimator.runningAnimator = null;
            }
        }
    };

    /* loaded from: classes3.dex */
    public static class Tuple {
        public Tuple(int[] r1, ValueAnimator valueAnimator) {
        }
    }

    public final void addState(int[] r2, ValueAnimator valueAnimator) {
        Tuple tuple = new Tuple(r2, valueAnimator);
        valueAnimator.addListener(this.animationListener);
        this.tuples.add(tuple);
    }
}
