package com.animaconnected.secondo.screens;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import java.util.ArrayList;

/* compiled from: Animator.kt */
/* loaded from: classes3.dex */
public final class WatchViewController$startAndRemove$$inlined$doOnEnd$1 implements Animator.AnimatorListener {
    final /* synthetic */ ObjectAnimator $this_startAndRemove$inlined;
    final /* synthetic */ WatchViewController this$0;

    public WatchViewController$startAndRemove$$inlined$doOnEnd$1(WatchViewController watchViewController, ObjectAnimator objectAnimator) {
        this.this$0 = watchViewController;
        this.$this_startAndRemove$inlined = objectAnimator;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        ArrayList arrayList;
        arrayList = this.this$0.objectAnimators;
        arrayList.remove(this.$this_startAndRemove$inlined);
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
}
