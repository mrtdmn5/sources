package com.google.android.material.animation;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.Log;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.collection.SimpleArrayMap;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public final class MotionSpec {
    public final SimpleArrayMap<String, MotionTiming> timings = new SimpleArrayMap<>();
    public final SimpleArrayMap<String, PropertyValuesHolder[]> propertyValues = new SimpleArrayMap<>();

    public static MotionSpec createFromResource(Context context, int r4) {
        try {
            Animator loadAnimator = AnimatorInflater.loadAnimator(context, r4);
            if (loadAnimator instanceof AnimatorSet) {
                return createSpecFromAnimators(((AnimatorSet) loadAnimator).getChildAnimations());
            }
            if (loadAnimator == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(loadAnimator);
            return createSpecFromAnimators(arrayList);
        } catch (Exception e) {
            Log.w("MotionSpec", "Can't load animation resource ID #0x" + Integer.toHexString(r4), e);
            return null;
        }
    }

    public static MotionSpec createSpecFromAnimators(ArrayList arrayList) {
        MotionSpec motionSpec = new MotionSpec();
        int size = arrayList.size();
        for (int r2 = 0; r2 < size; r2++) {
            Animator animator = (Animator) arrayList.get(r2);
            if (animator instanceof ObjectAnimator) {
                ObjectAnimator objectAnimator = (ObjectAnimator) animator;
                motionSpec.propertyValues.put(objectAnimator.getPropertyName(), objectAnimator.getValues());
                String propertyName = objectAnimator.getPropertyName();
                long startDelay = objectAnimator.getStartDelay();
                long duration = objectAnimator.getDuration();
                TimeInterpolator interpolator = objectAnimator.getInterpolator();
                if (!(interpolator instanceof AccelerateDecelerateInterpolator) && interpolator != null) {
                    if (interpolator instanceof AccelerateInterpolator) {
                        interpolator = AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR;
                    } else if (interpolator instanceof DecelerateInterpolator) {
                        interpolator = AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR;
                    }
                } else {
                    interpolator = AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR;
                }
                MotionTiming motionTiming = new MotionTiming(startDelay, duration, interpolator);
                motionTiming.repeatCount = objectAnimator.getRepeatCount();
                motionTiming.repeatMode = objectAnimator.getRepeatMode();
                motionSpec.timings.put(propertyName, motionTiming);
            } else {
                throw new IllegalArgumentException("Animator must be an ObjectAnimator: " + animator);
            }
        }
        return motionSpec;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MotionSpec)) {
            return false;
        }
        return this.timings.equals(((MotionSpec) obj).timings);
    }

    public final MotionTiming getTiming(String str) {
        boolean z;
        SimpleArrayMap<String, MotionTiming> simpleArrayMap = this.timings;
        if (simpleArrayMap.getOrDefault(str, null) != null) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return simpleArrayMap.getOrDefault(str, null);
        }
        throw new IllegalArgumentException();
    }

    public final int hashCode() {
        return this.timings.hashCode();
    }

    public final String toString() {
        return "\n" + MotionSpec.class.getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " timings: " + this.timings + "}\n";
    }
}
