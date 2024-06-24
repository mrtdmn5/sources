package com.animaconnected.watch.display;

import androidx.compose.animation.AndroidFlingSpline$FlingResult$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: Kanvas.kt */
/* loaded from: classes3.dex */
public final class PointF {
    public static final Companion Companion = new Companion(null);
    private static final PointF Zero = new PointF(0.0f, 0.0f);
    private final float x;
    private final float y;

    /* compiled from: Kanvas.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final PointF getZero() {
            return PointF.Zero;
        }

        private Companion() {
        }
    }

    public PointF(float f, float f2) {
        this.x = f;
        this.y = f2;
    }

    public static /* synthetic */ PointF copy$default(PointF pointF, float f, float f2, int r3, Object obj) {
        if ((r3 & 1) != 0) {
            f = pointF.x;
        }
        if ((r3 & 2) != 0) {
            f2 = pointF.y;
        }
        return pointF.copy(f, f2);
    }

    public final float component1() {
        return this.x;
    }

    public final float component2() {
        return this.y;
    }

    public final PointF copy(float f, float f2) {
        return new PointF(f, f2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PointF)) {
            return false;
        }
        PointF pointF = (PointF) obj;
        if (Float.compare(this.x, pointF.x) == 0 && Float.compare(this.y, pointF.y) == 0) {
            return true;
        }
        return false;
    }

    public final float getX() {
        return this.x;
    }

    public final float getY() {
        return this.y;
    }

    public int hashCode() {
        return Float.hashCode(this.y) + (Float.hashCode(this.x) * 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PointF(x=");
        sb.append(this.x);
        sb.append(", y=");
        return AndroidFlingSpline$FlingResult$$ExternalSyntheticOutline0.m(sb, this.y, ')');
    }
}
