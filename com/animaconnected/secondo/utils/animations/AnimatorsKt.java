package com.animaconnected.secondo.utils.animations;

import android.animation.ObjectAnimator;
import android.animation.RectEvaluator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.graphics.Rect;
import android.util.Property;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable$$ExternalSyntheticOutline0;
import com.animaconnected.secondo.screens.workout.utils.LocationMapUtilsKt;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$DoubleRef;
import kotlin.jvm.internal.Ref$FloatRef;

/* compiled from: Animators.kt */
/* loaded from: classes3.dex */
public final class AnimatorsKt {
    public static final long LARGE_AREA_ENTER_ANIM_TIME = 300;
    public static final long LARGE_AREA_EXIT_ANIM_TIME = 250;
    public static final long SMALL_AREA_ENTER_ANIM_TIME = 200;
    public static final long SMALL_AREA_EXIT_ANIM_TIME = 150;

    public static final ObjectAnimator clipAnimator(View view, Rect from, Rect to, long j, TimeInterpolator interpolator) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(to, "to");
        Intrinsics.checkNotNullParameter(interpolator, "interpolator");
        ObjectAnimator ofObject = ObjectAnimator.ofObject(view, "clipBounds", new RectEvaluator(), from, to);
        ofObject.setInterpolator(interpolator);
        ofObject.setDuration(j);
        return ofObject;
    }

    public static /* synthetic */ ObjectAnimator clipAnimator$default(View view, Rect rect, Rect rect2, long j, TimeInterpolator timeInterpolator, int r12, Object obj) {
        if ((r12 & 8) != 0) {
            timeInterpolator = new AccelerateDecelerateInterpolator();
        }
        return clipAnimator(view, rect, rect2, j, timeInterpolator);
    }

    public static final ObjectAnimator fadeInAnimator(View view, long j, TimeInterpolator interpolator) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(interpolator, "interpolator");
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.ALPHA, 0.0f, 1.0f);
        ofFloat.setDuration(j);
        ofFloat.setInterpolator(interpolator);
        return ofFloat;
    }

    public static /* synthetic */ ObjectAnimator fadeInAnimator$default(View view, long j, TimeInterpolator timeInterpolator, int r4, Object obj) {
        if ((r4 & 2) != 0) {
            timeInterpolator = new DecelerateInterpolator();
        }
        return fadeInAnimator(view, j, timeInterpolator);
    }

    public static final ObjectAnimator fadeOutAnimator(View view, long j, TimeInterpolator interpolator) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(interpolator, "interpolator");
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.ALPHA, 1.0f, 0.0f);
        ofFloat.setDuration(j);
        ofFloat.setInterpolator(interpolator);
        return ofFloat;
    }

    public static /* synthetic */ ObjectAnimator fadeOutAnimator$default(View view, long j, TimeInterpolator timeInterpolator, int r4, Object obj) {
        if ((r4 & 2) != 0) {
            timeInterpolator = new AccelerateInterpolator();
        }
        return fadeOutAnimator(view, j, timeInterpolator);
    }

    private static final float getCameraValue(float f, float f2, float f3) {
        return DrawerArrowDrawable$$ExternalSyntheticOutline0.m(f2, f3, f, f3);
    }

    public static final ValueAnimator mapsAnimator(final GoogleMap googleMap, long j, final LatLng cameraTarget, final float f, TimeInterpolator interpolator) {
        float f2;
        Intrinsics.checkNotNullParameter(googleMap, "<this>");
        Intrinsics.checkNotNullParameter(cameraTarget, "cameraTarget");
        Intrinsics.checkNotNullParameter(interpolator, "interpolator");
        if (googleMap.getCameraPosition().bearing > 180.0f) {
            f2 = 359.999f;
        } else {
            f2 = 0.0f;
        }
        final float f3 = f2;
        final Ref$DoubleRef ref$DoubleRef = new Ref$DoubleRef();
        ref$DoubleRef.element = googleMap.getCameraPosition().target.latitude;
        final Ref$DoubleRef ref$DoubleRef2 = new Ref$DoubleRef();
        ref$DoubleRef2.element = googleMap.getCameraPosition().target.longitude;
        final Ref$FloatRef ref$FloatRef = new Ref$FloatRef();
        ref$FloatRef.element = googleMap.getCameraPosition().zoom;
        final Ref$FloatRef ref$FloatRef2 = new Ref$FloatRef();
        ref$FloatRef2.element = googleMap.getCameraPosition().bearing;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(j);
        ofFloat.setInterpolator(interpolator);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.animaconnected.secondo.utils.animations.AnimatorsKt$$ExternalSyntheticLambda0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AnimatorsKt.mapsAnimator$lambda$8(f, googleMap, ref$FloatRef, f3, ref$FloatRef2, cameraTarget, ref$DoubleRef, ref$DoubleRef2, valueAnimator);
            }
        });
        return ofFloat;
    }

    public static /* synthetic */ ValueAnimator mapsAnimator$default(GoogleMap googleMap, long j, LatLng latLng, float f, TimeInterpolator timeInterpolator, int r12, Object obj) {
        if ((r12 & 4) != 0) {
            f = 0.0f;
        }
        float f2 = f;
        if ((r12 & 8) != 0) {
            timeInterpolator = new AccelerateDecelerateInterpolator();
        }
        return mapsAnimator(googleMap, j, latLng, f2, timeInterpolator);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mapsAnimator$lambda$8(float f, GoogleMap this_mapsAnimator, Ref$FloatRef newZoomLevel, float f2, Ref$FloatRef newBearing, LatLng cameraTarget, Ref$DoubleRef newLatitude, Ref$DoubleRef newLongitude, ValueAnimator listener) {
        boolean z;
        boolean z2;
        boolean z3;
        Intrinsics.checkNotNullParameter(this_mapsAnimator, "$this_mapsAnimator");
        Intrinsics.checkNotNullParameter(newZoomLevel, "$newZoomLevel");
        Intrinsics.checkNotNullParameter(newBearing, "$newBearing");
        Intrinsics.checkNotNullParameter(cameraTarget, "$cameraTarget");
        Intrinsics.checkNotNullParameter(newLatitude, "$newLatitude");
        Intrinsics.checkNotNullParameter(newLongitude, "$newLongitude");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Object animatedValue = listener.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        boolean z4 = true;
        if (f == this_mapsAnimator.getCameraPosition().zoom) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            newZoomLevel.element = getCameraValue(floatValue, f, this_mapsAnimator.getCameraPosition().zoom);
        }
        if (f2 == this_mapsAnimator.getCameraPosition().bearing) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2) {
            newBearing.element = getCameraValue(floatValue, f2, this_mapsAnimator.getCameraPosition().bearing);
        }
        double d = this_mapsAnimator.getCameraPosition().target.latitude;
        if (cameraTarget.latitude == d) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (!z3) {
            newLatitude.element = getCameraValue(floatValue, (float) r5, (float) this_mapsAnimator.getCameraPosition().target.latitude);
        }
        double d2 = this_mapsAnimator.getCameraPosition().target.longitude;
        if (cameraTarget.longitude != d2) {
            z4 = false;
        }
        if (!z4) {
            newLongitude.element = getCameraValue(floatValue, (float) r5, (float) this_mapsAnimator.getCameraPosition().target.longitude);
        }
        LocationMapUtilsKt.setNewCameraPosition(this_mapsAnimator, new LatLng(newLatitude.element, newLongitude.element), newZoomLevel.element, this_mapsAnimator.getCameraPosition().tilt, newBearing.element);
    }

    public static final ValueAnimator resizeAnimator(final View view, long j, int r4) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        ValueAnimator ofInt = ValueAnimator.ofInt(view.getLayoutParams().height, r4);
        ofInt.setDuration(j);
        ofInt.setInterpolator(new AccelerateDecelerateInterpolator());
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.animaconnected.secondo.utils.animations.AnimatorsKt$$ExternalSyntheticLambda2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AnimatorsKt.resizeAnimator$lambda$6(view, valueAnimator);
            }
        });
        return ofInt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void resizeAnimator$lambda$6(View this_resizeAnimator, ValueAnimator listener) {
        Intrinsics.checkNotNullParameter(this_resizeAnimator, "$this_resizeAnimator");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Object animatedValue = listener.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        this_resizeAnimator.getLayoutParams().height = ((Integer) animatedValue).intValue();
        this_resizeAnimator.requestLayout();
    }

    public static final ValueAnimator scaleAnimator(final View view, float f, float f2, long j, TimeInterpolator interpolator) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(interpolator, "interpolator");
        ValueAnimator ofFloat = ValueAnimator.ofFloat(f, f2);
        ofFloat.setDuration(j);
        ofFloat.setInterpolator(interpolator);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.animaconnected.secondo.utils.animations.AnimatorsKt$$ExternalSyntheticLambda1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AnimatorsKt.scaleAnimator$lambda$3$lambda$2(view, valueAnimator);
            }
        });
        return ofFloat;
    }

    public static /* synthetic */ ValueAnimator scaleAnimator$default(View view, float f, float f2, long j, TimeInterpolator timeInterpolator, int r12, Object obj) {
        if ((r12 & 8) != 0) {
            timeInterpolator = new AccelerateDecelerateInterpolator();
        }
        return scaleAnimator(view, f, f2, j, timeInterpolator);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void scaleAnimator$lambda$3$lambda$2(View this_scaleAnimator, ValueAnimator listener) {
        Intrinsics.checkNotNullParameter(this_scaleAnimator, "$this_scaleAnimator");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Object animatedValue = listener.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        this_scaleAnimator.setScaleX(floatValue);
        this_scaleAnimator.setScaleY(floatValue);
    }
}
