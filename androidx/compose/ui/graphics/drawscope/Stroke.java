package androidx.compose.ui.graphics.drawscope;

import androidx.compose.animation.FlingCalculator$FlingInfo$$ExternalSyntheticOutline1;
import androidx.compose.foundation.text.HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DrawScope.kt */
/* loaded from: classes.dex */
public final class Stroke extends DrawStyle {
    public final int cap;
    public final int join;
    public final float miter;
    public final float width;

    public Stroke(float f, float f2, int r5, int r6, int r7) {
        f = (r7 & 1) != 0 ? 0.0f : f;
        f2 = (r7 & 2) != 0 ? 4.0f : f2;
        r5 = (r7 & 4) != 0 ? 0 : r5;
        r6 = (r7 & 8) != 0 ? 0 : r6;
        this.width = f;
        this.miter = f2;
        this.cap = r5;
        this.join = r6;
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Stroke)) {
            return false;
        }
        Stroke stroke = (Stroke) obj;
        if (this.width == stroke.width) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            return false;
        }
        if (this.miter == stroke.miter) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2) {
            return false;
        }
        if (this.cap == stroke.cap) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (!z3) {
            return false;
        }
        if (this.join == stroke.join) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (!z4) {
            return false;
        }
        stroke.getClass();
        if (Intrinsics.areEqual((Object) null, (Object) null)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.join, HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.cap, FlingCalculator$FlingInfo$$ExternalSyntheticOutline1.m(this.miter, Float.hashCode(this.width) * 31, 31), 31), 31) + 0;
    }

    public final String toString() {
        return "Stroke(width=" + this.width + ", miter=" + this.miter + ", cap=" + ((Object) StrokeCap.m342toStringimpl(this.cap)) + ", join=" + ((Object) StrokeJoin.m343toStringimpl(this.join)) + ", pathEffect=" + ((Object) null) + ')';
    }
}
