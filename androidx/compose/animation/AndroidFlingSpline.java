package androidx.compose.animation;

import androidx.appcompat.graphics.drawable.DrawerArrowDrawable$$ExternalSyntheticOutline0;

/* compiled from: SplineBasedDecay.kt */
/* loaded from: classes.dex */
public final class AndroidFlingSpline {
    public static final float[] SplinePositions;

    /* compiled from: SplineBasedDecay.kt */
    /* loaded from: classes.dex */
    public static final class FlingResult {
        public final float distanceCoefficient;
        public final float velocityCoefficient;

        public FlingResult(float f, float f2) {
            this.distanceCoefficient = f;
            this.velocityCoefficient = f2;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof FlingResult)) {
                return false;
            }
            FlingResult flingResult = (FlingResult) obj;
            if (Float.compare(this.distanceCoefficient, flingResult.distanceCoefficient) == 0 && Float.compare(this.velocityCoefficient, flingResult.velocityCoefficient) == 0) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            return Float.hashCode(this.velocityCoefficient) + (Float.hashCode(this.distanceCoefficient) * 31);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("FlingResult(distanceCoefficient=");
            sb.append(this.distanceCoefficient);
            sb.append(", velocityCoefficient=");
            return AndroidFlingSpline$FlingResult$$ExternalSyntheticOutline0.m(sb, this.velocityCoefficient, ')');
        }
    }

    static {
        float f;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        float[] fArr = new float[101];
        SplinePositions = fArr;
        float[] fArr2 = new float[101];
        float f9 = 0.0f;
        float f10 = 0.0f;
        for (int r4 = 0; r4 < 100; r4++) {
            float f11 = r4 / 100;
            float f12 = 1.0f;
            while (true) {
                f = ((f12 - f9) / 2.0f) + f9;
                f2 = 1.0f - f;
                f3 = f * 3.0f * f2;
                f4 = f * f * f;
                float f13 = (((f * 0.35000002f) + (f2 * 0.175f)) * f3) + f4;
                if (Math.abs(f13 - f11) < 1.0E-5d) {
                    break;
                } else if (f13 > f11) {
                    f12 = f;
                } else {
                    f9 = f;
                }
            }
            float f14 = 0.5f;
            fArr[r4] = (((f2 * 0.5f) + f) * f3) + f4;
            float f15 = 1.0f;
            while (true) {
                f5 = ((f15 - f10) / 2.0f) + f10;
                f6 = 1.0f - f5;
                f7 = f5 * 3.0f * f6;
                f8 = f5 * f5 * f5;
                float f16 = (((f6 * f14) + f5) * f7) + f8;
                if (Math.abs(f16 - f11) >= 1.0E-5d) {
                    if (f16 > f11) {
                        f15 = f5;
                    } else {
                        f10 = f5;
                    }
                    f14 = 0.5f;
                }
            }
            fArr2[r4] = (((f5 * 0.35000002f) + (f6 * 0.175f)) * f7) + f8;
        }
        fArr2[100] = 1.0f;
        fArr[100] = 1.0f;
    }

    public static FlingResult flingPosition(float f) {
        float f2;
        float f3;
        float f4 = 100;
        int r2 = (int) (f4 * f);
        if (r2 < 100) {
            float f5 = r2 / f4;
            int r3 = r2 + 1;
            float f6 = r3 / f4;
            float[] fArr = SplinePositions;
            float f7 = fArr[r2];
            f3 = (fArr[r3] - f7) / (f6 - f5);
            f2 = DrawerArrowDrawable$$ExternalSyntheticOutline0.m(f, f5, f3, f7);
        } else {
            f2 = 1.0f;
            f3 = 0.0f;
        }
        return new FlingResult(f2, f3);
    }
}
