package com.animaconnected.watch.display;

import androidx.compose.animation.AndroidFlingSpline$FlingResult$$ExternalSyntheticOutline0;
import androidx.compose.animation.FlingCalculator$FlingInfo$$ExternalSyntheticOutline1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: Kanvas.kt */
/* loaded from: classes3.dex */
public final class RectF {
    public static final Companion Companion = new Companion(null);
    private static final RectF Zero = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
    private float bottom;
    private float left;
    private float right;
    private float top;

    /* compiled from: Kanvas.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final RectF getZero() {
            return RectF.Zero;
        }

        private Companion() {
        }
    }

    public RectF() {
        this(0.0f, 0.0f, 0.0f, 0.0f, 15, null);
    }

    public static /* synthetic */ RectF copy$default(RectF rectF, float f, float f2, float f3, float f4, int r5, Object obj) {
        if ((r5 & 1) != 0) {
            f = rectF.left;
        }
        if ((r5 & 2) != 0) {
            f2 = rectF.top;
        }
        if ((r5 & 4) != 0) {
            f3 = rectF.right;
        }
        if ((r5 & 8) != 0) {
            f4 = rectF.bottom;
        }
        return rectF.copy(f, f2, f3, f4);
    }

    public static /* synthetic */ void inset$default(RectF rectF, float f, float f2, int r4, Object obj) {
        if ((r4 & 1) != 0) {
            f = 0.0f;
        }
        if ((r4 & 2) != 0) {
            f2 = 0.0f;
        }
        rectF.inset(f, f2);
    }

    public static /* synthetic */ void offset$default(RectF rectF, float f, float f2, int r4, Object obj) {
        if ((r4 & 1) != 0) {
            f = 0.0f;
        }
        if ((r4 & 2) != 0) {
            f2 = 0.0f;
        }
        rectF.offset(f, f2);
    }

    public final float component1() {
        return this.left;
    }

    public final float component2() {
        return this.top;
    }

    public final float component3() {
        return this.right;
    }

    public final float component4() {
        return this.bottom;
    }

    public final boolean contains(PointF pointF) {
        boolean z;
        boolean z2;
        if (pointF == null) {
            return false;
        }
        float f = this.left;
        float f2 = this.right;
        float x = pointF.getX();
        if (f <= x && x <= f2) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            return false;
        }
        float f3 = this.top;
        float f4 = this.bottom;
        float y = pointF.getY();
        if (f3 <= y && y <= f4) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2) {
            return false;
        }
        return true;
    }

    public final RectF copy(float f, float f2, float f3, float f4) {
        return new RectF(f, f2, f3, f4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RectF)) {
            return false;
        }
        RectF rectF = (RectF) obj;
        if (Float.compare(this.left, rectF.left) == 0 && Float.compare(this.top, rectF.top) == 0 && Float.compare(this.right, rectF.right) == 0 && Float.compare(this.bottom, rectF.bottom) == 0) {
            return true;
        }
        return false;
    }

    public final float getBottom() {
        return this.bottom;
    }

    public final float getCenterX() {
        return (this.left + this.right) / 2;
    }

    public final float getCenterY() {
        return (this.top + this.bottom) / 2;
    }

    public final float getHeight() {
        return Math.abs(this.bottom - this.top);
    }

    public final float getLeft() {
        return this.left;
    }

    public final float getRight() {
        return this.right;
    }

    public final float getTop() {
        return this.top;
    }

    public final float getWidth() {
        return Math.abs(this.right - this.left);
    }

    public int hashCode() {
        return Float.hashCode(this.bottom) + FlingCalculator$FlingInfo$$ExternalSyntheticOutline1.m(this.right, FlingCalculator$FlingInfo$$ExternalSyntheticOutline1.m(this.top, Float.hashCode(this.left) * 31, 31), 31);
    }

    public final void inset(float f, float f2) {
        this.left += f;
        this.right -= f;
        this.top += f2;
        this.bottom -= f2;
    }

    public final boolean isEmpty() {
        if (this.left < this.right && this.top < this.bottom) {
            return false;
        }
        return true;
    }

    public final void offset(float f, float f2) {
        this.left += f;
        this.top += f2;
        this.right += f;
        this.bottom += f2;
    }

    public final void setBottom(float f) {
        this.bottom = f;
    }

    public final void setEmpty() {
        this.bottom = 0.0f;
        this.top = 0.0f;
        this.right = 0.0f;
        this.left = 0.0f;
    }

    public final void setLeft(float f) {
        this.left = f;
    }

    public final void setRight(float f) {
        this.right = f;
    }

    public final void setTop(float f) {
        this.top = f;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("RectF(left=");
        sb.append(this.left);
        sb.append(", top=");
        sb.append(this.top);
        sb.append(", right=");
        sb.append(this.right);
        sb.append(", bottom=");
        return AndroidFlingSpline$FlingResult$$ExternalSyntheticOutline0.m(sb, this.bottom, ')');
    }

    public RectF(float f, float f2, float f3, float f4) {
        this.left = f;
        this.top = f2;
        this.right = f3;
        this.bottom = f4;
    }

    public /* synthetic */ RectF(float f, float f2, float f3, float f4, int r6, DefaultConstructorMarker defaultConstructorMarker) {
        this((r6 & 1) != 0 ? 0.0f : f, (r6 & 2) != 0 ? 0.0f : f2, (r6 & 4) != 0 ? 0.0f : f3, (r6 & 8) != 0 ? 0.0f : f4);
    }
}
