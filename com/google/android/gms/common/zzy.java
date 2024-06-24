package com.google.android.gms.common;

import androidx.compose.animation.core.AnimationVector;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* loaded from: classes3.dex */
public final class zzy {
    public static final AnimationVector copy(AnimationVector animationVector) {
        Intrinsics.checkNotNullParameter(animationVector, "<this>");
        AnimationVector newInstance = newInstance(animationVector);
        int size$animation_core_release = newInstance.getSize$animation_core_release();
        for (int r2 = 0; r2 < size$animation_core_release; r2++) {
            newInstance.set$animation_core_release(animationVector.get$animation_core_release(r2), r2);
        }
        return newInstance;
    }

    public static final AnimationVector newInstance(AnimationVector animationVector) {
        Intrinsics.checkNotNullParameter(animationVector, "<this>");
        AnimationVector newVector$animation_core_release = animationVector.newVector$animation_core_release();
        Intrinsics.checkNotNull(newVector$animation_core_release, "null cannot be cast to non-null type T of androidx.compose.animation.core.AnimationVectorsKt.newInstance");
        return newVector$animation_core_release;
    }

    public static int zza(int r5) {
        int[] r1 = {1, 2, 3, 4, 5, 6};
        for (int r2 = 0; r2 < 6; r2++) {
            int r3 = r1[r2];
            int r4 = r3 - 1;
            if (r3 != 0) {
                if (r4 == r5) {
                    return r3;
                }
            } else {
                throw null;
            }
        }
        return 1;
    }
}
