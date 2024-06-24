package org.slf4j.helpers;

import androidx.compose.animation.core.AnimationVector;
import androidx.compose.animation.core.VectorizedAnimationSpec;
import androidx.compose.ui.graphics.colorspace.WhitePoint;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class MessageFormatter {
    public static final WhitePoint C = new WhitePoint(0.31006f, 0.31616f);
    public static final WhitePoint D50 = new WhitePoint(0.34567f, 0.3585f);
    public static final WhitePoint D60 = new WhitePoint(0.32168f, 0.33767f);
    public static final WhitePoint D65 = new WhitePoint(0.31271f, 0.32902f);
    public static final float[] D50Xyz = {0.964212f, 1.0f, 0.825188f};

    public static final Object[] access$insertEntryAtIndex(Object[] objArr, int r4, Object obj, Object obj2) {
        Object[] objArr2 = new Object[objArr.length + 2];
        ArraysKt___ArraysJvmKt.copyInto$default(objArr, objArr2, 0, r4, 6);
        ArraysKt___ArraysJvmKt.copyInto(r4 + 2, r4, objArr.length, objArr, objArr2);
        objArr2[r4] = obj;
        objArr2[r4 + 1] = obj2;
        return objArr2;
    }

    public static final Object[] access$removeEntryAtIndex(int r3, Object[] objArr) {
        Object[] objArr2 = new Object[objArr.length - 2];
        ArraysKt___ArraysJvmKt.copyInto$default(objArr, objArr2, 0, r3, 6);
        ArraysKt___ArraysJvmKt.copyInto(r3, r3 + 2, objArr.length, objArr, objArr2);
        return objArr2;
    }

    public static final Object[] access$removeNodeAtIndex(int r3, Object[] objArr) {
        Object[] objArr2 = new Object[objArr.length - 1];
        ArraysKt___ArraysJvmKt.copyInto$default(objArr, objArr2, 0, r3, 6);
        ArraysKt___ArraysJvmKt.copyInto(r3, r3 + 1, objArr.length, objArr, objArr2);
        return objArr2;
    }

    public static final AnimationVector getValueFromMillis(VectorizedAnimationSpec vectorizedAnimationSpec, long j, AnimationVector start, AnimationVector end, AnimationVector startVelocity) {
        Intrinsics.checkNotNullParameter(vectorizedAnimationSpec, "<this>");
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(end, "end");
        Intrinsics.checkNotNullParameter(startVelocity, "startVelocity");
        return vectorizedAnimationSpec.getValueFromNanos(j * 1000000, start, end, startVelocity);
    }

    public static final void toCharArray(String str, char[] destination, int r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        str.getChars(r4, r5, destination, r3);
    }
}
