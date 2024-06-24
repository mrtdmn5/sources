package com.google.android.material.transformation;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.View;
import android.view.animation.LinearInterpolator;
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable$$ExternalSyntheticOutline0;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.animation.MotionTiming;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import org.slf4j.helpers.NOPMDCAdapter;

@Deprecated
/* loaded from: classes3.dex */
public abstract class FabTransformationBehavior extends ExpandableTransformationBehavior {
    public float dependencyOriginalTranslationX;
    public float dependencyOriginalTranslationY;
    public final int[] tmpArray;
    public final Rect tmpRect;
    public final RectF tmpRectF1;
    public final RectF tmpRectF2;

    /* loaded from: classes3.dex */
    public static class FabTransformationSpec {
        public NOPMDCAdapter positioning;
        public MotionSpec timings;
    }

    public FabTransformationBehavior() {
        this.tmpRect = new Rect();
        this.tmpRectF1 = new RectF();
        this.tmpRectF2 = new RectF();
        this.tmpArray = new int[2];
    }

    public static Pair calculateMotionTiming(float f, float f2, boolean z, FabTransformationSpec fabTransformationSpec) {
        MotionTiming timing;
        MotionTiming timing2;
        if (f != 0.0f && f2 != 0.0f) {
            if ((z && f2 < 0.0f) || (!z && f2 > 0.0f)) {
                timing = fabTransformationSpec.timings.getTiming("translationXCurveUpwards");
                timing2 = fabTransformationSpec.timings.getTiming("translationYCurveUpwards");
            } else {
                timing = fabTransformationSpec.timings.getTiming("translationXCurveDownwards");
                timing2 = fabTransformationSpec.timings.getTiming("translationYCurveDownwards");
            }
        } else {
            timing = fabTransformationSpec.timings.getTiming("translationXLinear");
            timing2 = fabTransformationSpec.timings.getTiming("translationYLinear");
        }
        return new Pair(timing, timing2);
    }

    public static float calculateValueOfAnimationAtEndOfExpansion(FabTransformationSpec fabTransformationSpec, MotionTiming motionTiming, float f) {
        long j = motionTiming.delay;
        MotionTiming timing = fabTransformationSpec.timings.getTiming("expansion");
        float interpolation = motionTiming.getInterpolator().getInterpolation(((float) (((timing.delay + timing.duration) + 17) - j)) / ((float) motionTiming.duration));
        LinearInterpolator linearInterpolator = AnimationUtils.LINEAR_INTERPOLATOR;
        return DrawerArrowDrawable$$ExternalSyntheticOutline0.m(0.0f, f, interpolation, f);
    }

    public final float calculateTranslationX(View view, View view2, NOPMDCAdapter nOPMDCAdapter) {
        RectF rectF = this.tmpRectF1;
        RectF rectF2 = this.tmpRectF2;
        calculateWindowBounds(view, rectF);
        rectF.offset(this.dependencyOriginalTranslationX, this.dependencyOriginalTranslationY);
        calculateWindowBounds(view2, rectF2);
        nOPMDCAdapter.getClass();
        return (rectF2.centerX() - rectF.centerX()) + 0.0f;
    }

    public final float calculateTranslationY(View view, View view2, NOPMDCAdapter nOPMDCAdapter) {
        RectF rectF = this.tmpRectF1;
        RectF rectF2 = this.tmpRectF2;
        calculateWindowBounds(view, rectF);
        rectF.offset(this.dependencyOriginalTranslationX, this.dependencyOriginalTranslationY);
        calculateWindowBounds(view2, rectF2);
        nOPMDCAdapter.getClass();
        return (rectF2.centerY() - rectF.centerY()) + 0.0f;
    }

    public final void calculateWindowBounds(View view, RectF rectF) {
        rectF.set(0.0f, 0.0f, view.getWidth(), view.getHeight());
        view.getLocationInWindow(this.tmpArray);
        rectF.offsetTo(r0[0], r0[1]);
        rectF.offset((int) (-view.getTranslationX()), (int) (-view.getTranslationY()));
    }

    @Override // com.google.android.material.transformation.ExpandableBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean layoutDependsOn(View view, View view2) {
        int expandedComponentIdHint;
        if (view.getVisibility() != 8) {
            if ((view2 instanceof FloatingActionButton) && ((expandedComponentIdHint = ((FloatingActionButton) view2).getExpandedComponentIdHint()) == 0 || expandedComponentIdHint == view.getId())) {
                return true;
            }
            return false;
        }
        throw new IllegalStateException("This behavior cannot be attached to a GONE view. Set the view to INVISIBLE instead.");
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void onAttachedToLayoutParams(CoordinatorLayout.LayoutParams layoutParams) {
        if (layoutParams.dodgeInsetEdges == 0) {
            layoutParams.dodgeInsetEdges = 80;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:33:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0302  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x035d  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0391  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x03e2 A[LOOP:0: B:61:0x03e0->B:62:0x03e2, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0307  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01a9  */
    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.animation.AnimatorSet onCreateExpandedStateChangeAnimation(final android.view.View r26, final android.view.View r27, boolean r28, boolean r29) {
        /*
            Method dump skipped, instructions count: 1021
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.transformation.FabTransformationBehavior.onCreateExpandedStateChangeAnimation(android.view.View, android.view.View, boolean, boolean):android.animation.AnimatorSet");
    }

    public abstract FabTransformationSpec onCreateMotionSpec(Context context, boolean z);

    public FabTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.tmpRect = new Rect();
        this.tmpRectF1 = new RectF();
        this.tmpRectF2 = new RectF();
        this.tmpArray = new int[2];
    }
}
