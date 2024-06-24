package androidx.compose.ui;

import androidx.compose.animation.AndroidFlingSpline$FlingResult$$ExternalSyntheticOutline0;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;

/* compiled from: Alignment.kt */
/* loaded from: classes.dex */
public final class BiasAlignment implements Alignment {
    public final float horizontalBias;
    public final float verticalBias;

    /* compiled from: Alignment.kt */
    /* loaded from: classes.dex */
    public static final class Horizontal implements Alignment.Horizontal {
        public final float bias;

        public Horizontal(float f) {
            this.bias = f;
        }

        @Override // androidx.compose.ui.Alignment.Horizontal
        public final int align(int r2, int r3, LayoutDirection layoutDirection) {
            Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
            float f = (r3 - r2) / 2.0f;
            LayoutDirection layoutDirection2 = LayoutDirection.Ltr;
            float f2 = this.bias;
            if (layoutDirection != layoutDirection2) {
                f2 *= -1;
            }
            return MathKt__MathJVMKt.roundToInt((1 + f2) * f);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof Horizontal) && Float.compare(this.bias, ((Horizontal) obj).bias) == 0) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            return Float.hashCode(this.bias);
        }

        public final String toString() {
            return AndroidFlingSpline$FlingResult$$ExternalSyntheticOutline0.m(new StringBuilder("Horizontal(bias="), this.bias, ')');
        }
    }

    /* compiled from: Alignment.kt */
    /* loaded from: classes.dex */
    public static final class Vertical implements Alignment.Vertical {
        public final float bias;

        public Vertical(float f) {
            this.bias = f;
        }

        @Override // androidx.compose.ui.Alignment.Vertical
        public final int align(int r2, int r3) {
            return MathKt__MathJVMKt.roundToInt((1 + this.bias) * ((r3 - r2) / 2.0f));
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof Vertical) && Float.compare(this.bias, ((Vertical) obj).bias) == 0) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            return Float.hashCode(this.bias);
        }

        public final String toString() {
            return AndroidFlingSpline$FlingResult$$ExternalSyntheticOutline0.m(new StringBuilder("Vertical(bias="), this.bias, ')');
        }
    }

    public BiasAlignment(float f, float f2) {
        this.horizontalBias = f;
        this.verticalBias = f2;
    }

    @Override // androidx.compose.ui.Alignment
    /* renamed from: align-KFBX0sM */
    public final long mo229alignKFBX0sM(long j, long j2, LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        float f = (((int) (j2 >> 32)) - ((int) (j >> 32))) / 2.0f;
        float m593getHeightimpl = (IntSize.m593getHeightimpl(j2) - IntSize.m593getHeightimpl(j)) / 2.0f;
        LayoutDirection layoutDirection2 = LayoutDirection.Ltr;
        float f2 = this.horizontalBias;
        if (layoutDirection != layoutDirection2) {
            f2 *= -1;
        }
        float f3 = 1;
        return IntOffsetKt.IntOffset(MathKt__MathJVMKt.roundToInt((f2 + f3) * f), MathKt__MathJVMKt.roundToInt((f3 + this.verticalBias) * m593getHeightimpl));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BiasAlignment)) {
            return false;
        }
        BiasAlignment biasAlignment = (BiasAlignment) obj;
        if (Float.compare(this.horizontalBias, biasAlignment.horizontalBias) == 0 && Float.compare(this.verticalBias, biasAlignment.verticalBias) == 0) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Float.hashCode(this.verticalBias) + (Float.hashCode(this.horizontalBias) * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("BiasAlignment(horizontalBias=");
        sb.append(this.horizontalBias);
        sb.append(", verticalBias=");
        return AndroidFlingSpline$FlingResult$$ExternalSyntheticOutline0.m(sb, this.verticalBias, ')');
    }
}
