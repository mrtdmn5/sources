package androidx.core.content.res;

import java.util.ArrayList;

/* loaded from: classes.dex */
public final class GradientColorInflaterCompat$ColorStops {
    public final int[] mColors;
    public final float[] mOffsets;

    public GradientColorInflaterCompat$ColorStops(ArrayList arrayList, ArrayList arrayList2) {
        int size = arrayList.size();
        this.mColors = new int[size];
        this.mOffsets = new float[size];
        for (int r1 = 0; r1 < size; r1++) {
            this.mColors[r1] = ((Integer) arrayList.get(r1)).intValue();
            this.mOffsets[r1] = ((Float) arrayList2.get(r1)).floatValue();
        }
    }

    public GradientColorInflaterCompat$ColorStops(int r1, int r2) {
        this.mColors = new int[]{r1, r2};
        this.mOffsets = new float[]{0.0f, 1.0f};
    }

    public GradientColorInflaterCompat$ColorStops(int r1, int r2, int r3) {
        this.mColors = new int[]{r1, r2, r3};
        this.mOffsets = new float[]{0.0f, 0.5f, 1.0f};
    }
}
