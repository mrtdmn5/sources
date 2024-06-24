package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.graphics.Rect;
import android.os.Build;
import android.util.Property;
import android.view.View;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public final class FloatingActionButtonImplLollipop extends FloatingActionButtonImpl {
    public final AnimatorSet createElevationAnimator(float f, float f2) {
        AnimatorSet animatorSet = new AnimatorSet();
        FloatingActionButton floatingActionButton = this.view;
        animatorSet.play(ObjectAnimator.ofFloat(floatingActionButton, "elevation", f).setDuration(0L)).with(ObjectAnimator.ofFloat(floatingActionButton, (Property<FloatingActionButton, Float>) View.TRANSLATION_Z, f2).setDuration(100L));
        animatorSet.setInterpolator(FloatingActionButtonImpl.ELEVATION_ANIM_INTERPOLATOR);
        return animatorSet;
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    public final float getElevation() {
        return this.view.getElevation();
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    public final void getPadding(Rect rect) {
        boolean z;
        if (FloatingActionButton.this.compatPadding) {
            super.getPadding(rect);
            return;
        }
        boolean z2 = this.ensureMinTouchTargetSize;
        FloatingActionButton floatingActionButton = this.view;
        if (z2 && floatingActionButton.getSizeDimension() < 0) {
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            int sizeDimension = (0 - floatingActionButton.getSizeDimension()) / 2;
            rect.set(sizeDimension, sizeDimension, sizeDimension, sizeDimension);
        } else {
            rect.set(0, 0, 0, 0);
        }
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    public final void onCompatShadowChanged() {
        updatePadding();
        throw null;
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    public final void onElevationsChanged(float f, float f2, float f3) {
        int r0 = Build.VERSION.SDK_INT;
        StateListAnimator stateListAnimator = new StateListAnimator();
        stateListAnimator.addState(FloatingActionButtonImpl.PRESSED_ENABLED_STATE_SET, createElevationAnimator(f, f3));
        stateListAnimator.addState(FloatingActionButtonImpl.HOVERED_FOCUSED_ENABLED_STATE_SET, createElevationAnimator(f, f2));
        stateListAnimator.addState(FloatingActionButtonImpl.FOCUSED_ENABLED_STATE_SET, createElevationAnimator(f, f2));
        stateListAnimator.addState(FloatingActionButtonImpl.HOVERED_ENABLED_STATE_SET, createElevationAnimator(f, f2));
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        FloatingActionButton floatingActionButton = this.view;
        arrayList.add(ObjectAnimator.ofFloat(floatingActionButton, "elevation", f).setDuration(0L));
        if (r0 <= 24) {
            arrayList.add(ObjectAnimator.ofFloat(floatingActionButton, (Property<FloatingActionButton, Float>) View.TRANSLATION_Z, floatingActionButton.getTranslationZ()).setDuration(100L));
        }
        arrayList.add(ObjectAnimator.ofFloat(floatingActionButton, (Property<FloatingActionButton, Float>) View.TRANSLATION_Z, 0.0f).setDuration(100L));
        animatorSet.playSequentially((Animator[]) arrayList.toArray(new Animator[0]));
        animatorSet.setInterpolator(FloatingActionButtonImpl.ELEVATION_ANIM_INTERPOLATOR);
        stateListAnimator.addState(FloatingActionButtonImpl.ENABLED_STATE_SET, animatorSet);
        stateListAnimator.addState(FloatingActionButtonImpl.EMPTY_STATE_SET, createElevationAnimator(0.0f, 0.0f));
        floatingActionButton.setStateListAnimator(stateListAnimator);
        if (!shouldAddPadding()) {
            return;
        }
        updatePadding();
        throw null;
    }

    public final boolean shouldAddPadding() {
        boolean z;
        if (FloatingActionButton.this.compatPadding) {
            return true;
        }
        if (this.ensureMinTouchTargetSize && this.view.getSizeDimension() < 0) {
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    public final void jumpDrawableToCurrentState() {
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    public final void setRippleColor() {
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    public final void updateFromViewRotation() {
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl
    public final void onDrawableStateChanged(int[] r1) {
    }
}
