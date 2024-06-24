package com.animaconnected.watch.display;

import com.animaconnected.watch.image.Mitmap;
import java.util.Arrays;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: Kanvas.kt */
/* loaded from: classes3.dex */
public final class KanvasKt {
    public static final Mitmap stretch(Mitmap mitmap, int r14, int r15) {
        int r142;
        int r152;
        int[] pixels;
        Intrinsics.checkNotNullParameter(mitmap, "<this>");
        int width = mitmap.getWidth() / 2;
        if (r14 > mitmap.getWidth()) {
            r142 = r14 - mitmap.getWidth();
        } else {
            r142 = 0;
        }
        if (r15 > mitmap.getHeight()) {
            r152 = r15 - mitmap.getHeight();
        } else {
            r152 = 0;
        }
        int width2 = mitmap.getWidth() + r142;
        int height = mitmap.getHeight() + r152;
        if (r142 > 0) {
            int[] r3 = new int[mitmap.getHeight() * width2];
            int height2 = mitmap.getHeight();
            for (int r7 = 0; r7 < height2; r7++) {
                int width3 = mitmap.getWidth() * r7;
                int r9 = width3 + width;
                int r11 = r142 * r7;
                ArraysKt___ArraysJvmKt.copyInto$default(ArraysKt___ArraysKt.sliceArray(mitmap.getPixels(), new IntRange(width3, r9)), r3, width3 + r11, 0, 12);
                int r112 = r11 + r9;
                int r12 = r112 + r142;
                Arrays.fill(r3, r112, r12, mitmap.getPixels()[r9]);
                ArraysKt___ArraysJvmKt.copyInto$default(ArraysKt___ArraysKt.sliceArray(mitmap.getPixels(), RangesKt___RangesKt.until(r9, mitmap.getWidth() + width3)), r3, r12, 0, 12);
            }
            pixels = r3;
        } else {
            pixels = mitmap.getPixels();
        }
        if (height == mitmap.getHeight()) {
            return new Mitmap(width2, mitmap.getHeight(), pixels, null, null, false, null, 120, null);
        }
        int height3 = (mitmap.getHeight() / 2) * width2;
        int[] sliceArray = ArraysKt___ArraysKt.sliceArray(pixels, RangesKt___RangesKt.until(0, height3));
        int[] sliceArray2 = ArraysKt___ArraysKt.sliceArray(pixels, RangesKt___RangesKt.until(height3, pixels.length));
        int[] sliceArray3 = ArraysKt___ArraysKt.sliceArray(pixels, RangesKt___RangesKt.until(height3, height3 + width2));
        int[] r6 = new int[width2 * height];
        ArraysKt___ArraysJvmKt.copyInto$default(sliceArray, r6, 0, 0, 14);
        for (int r143 = 0; r143 < r152; r143++) {
            ArraysKt___ArraysJvmKt.copyInto$default(sliceArray3, r6, (width2 * r143) + height3, 0, 12);
        }
        ArraysKt___ArraysJvmKt.copyInto$default(sliceArray2, r6, (r152 * width2) + height3, 0, 12);
        return new Mitmap(width2, height, r6, null, null, false, null, 120, null);
    }
}
