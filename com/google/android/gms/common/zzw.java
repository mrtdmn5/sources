package com.google.android.gms.common;

import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.AnimationVector;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* loaded from: classes3.dex */
public final /* synthetic */ class zzw {
    public static AnimationState AnimationState$default(float f, int r17) {
        float f2;
        long j;
        long j2;
        if ((r17 & 2) != 0) {
            f2 = 0.0f;
        } else {
            f2 = f;
        }
        if ((r17 & 4) != 0) {
            j = Long.MIN_VALUE;
        } else {
            j = 0;
        }
        if ((r17 & 8) != 0) {
            j2 = Long.MIN_VALUE;
        } else {
            j2 = 0;
        }
        return new AnimationState(VectorConvertersKt.FloatToVector, Float.valueOf(0.0f), new AnimationVector1D(f2), j, j2, false);
    }

    public static AnimationState copy$default(AnimationState animationState, float f, int r19) {
        float f2;
        float f3;
        long j;
        boolean z;
        if ((r19 & 1) != 0) {
            f2 = ((Number) animationState.getValue()).floatValue();
        } else {
            f2 = 0.0f;
        }
        if ((r19 & 2) != 0) {
            f3 = ((AnimationVector1D) animationState.velocityVector).value;
        } else {
            f3 = f;
        }
        long j2 = 0;
        if ((r19 & 4) != 0) {
            j = animationState.lastFrameTimeNanos;
        } else {
            j = 0;
        }
        if ((r19 & 8) != 0) {
            j2 = animationState.finishedTimeNanos;
        }
        long j3 = j2;
        if ((r19 & 16) != 0) {
            z = animationState.isRunning;
        } else {
            z = false;
        }
        Intrinsics.checkNotNullParameter(animationState, "<this>");
        return new AnimationState(animationState.typeConverter, Float.valueOf(f2), new AnimationVector1D(f3), j, j3, z);
    }

    public static final AnimationVector createZeroVectorFrom(TwoWayConverter twoWayConverter, Object obj) {
        Intrinsics.checkNotNullParameter(twoWayConverter, "<this>");
        return zzy.newInstance((AnimationVector) twoWayConverter.getConvertToVector().invoke(obj));
    }
}
