package androidx.compose.ui.graphics.vector;

import androidx.compose.animation.FlingCalculator$FlingInfo$$ExternalSyntheticOutline1;
import androidx.compose.foundation.text.HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0;
import androidx.compose.ui.graphics.Brush;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ImageVector.kt */
/* loaded from: classes.dex */
public final class VectorPath extends VectorNode {
    public final Brush fill;
    public final float fillAlpha;
    public final String name;
    public final List<PathNode> pathData;
    public final int pathFillType;
    public final Brush stroke;
    public final float strokeAlpha;
    public final int strokeLineCap;
    public final int strokeLineJoin;
    public final float strokeLineMiter;
    public final float strokeLineWidth;
    public final float trimPathEnd;
    public final float trimPathOffset;
    public final float trimPathStart;

    public VectorPath(String name, List pathData, int r4, Brush brush, float f, Brush brush2, float f2, float f3, int r10, int r11, float f4, float f5, float f6, float f7) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(pathData, "pathData");
        this.name = name;
        this.pathData = pathData;
        this.pathFillType = r4;
        this.fill = brush;
        this.fillAlpha = f;
        this.stroke = brush2;
        this.strokeAlpha = f2;
        this.strokeLineWidth = f3;
        this.strokeLineCap = r10;
        this.strokeLineJoin = r11;
        this.strokeLineMiter = f4;
        this.trimPathStart = f5;
        this.trimPathEnd = f6;
        this.trimPathOffset = f7;
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        if (this == obj) {
            return true;
        }
        if (obj == null || VectorPath.class != obj.getClass()) {
            return false;
        }
        VectorPath vectorPath = (VectorPath) obj;
        if (!Intrinsics.areEqual(this.name, vectorPath.name) || !Intrinsics.areEqual(this.fill, vectorPath.fill)) {
            return false;
        }
        if (this.fillAlpha == vectorPath.fillAlpha) {
            z = true;
        } else {
            z = false;
        }
        if (!z || !Intrinsics.areEqual(this.stroke, vectorPath.stroke)) {
            return false;
        }
        if (this.strokeAlpha == vectorPath.strokeAlpha) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2) {
            return false;
        }
        if (this.strokeLineWidth == vectorPath.strokeLineWidth) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (!z3) {
            return false;
        }
        if (this.strokeLineCap == vectorPath.strokeLineCap) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (!z4) {
            return false;
        }
        if (this.strokeLineJoin == vectorPath.strokeLineJoin) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (!z5) {
            return false;
        }
        if (this.strokeLineMiter == vectorPath.strokeLineMiter) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (!z6) {
            return false;
        }
        if (this.trimPathStart == vectorPath.trimPathStart) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (!z7) {
            return false;
        }
        if (this.trimPathEnd == vectorPath.trimPathEnd) {
            z8 = true;
        } else {
            z8 = false;
        }
        if (!z8) {
            return false;
        }
        if (this.trimPathOffset == vectorPath.trimPathOffset) {
            z9 = true;
        } else {
            z9 = false;
        }
        if (!z9) {
            return false;
        }
        if (this.pathFillType == vectorPath.pathFillType) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10 && Intrinsics.areEqual(this.pathData, vectorPath.pathData)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int r2;
        int m = VectorGroup$$ExternalSyntheticOutline0.m(this.pathData, this.name.hashCode() * 31, 31);
        int r1 = 0;
        Brush brush = this.fill;
        if (brush != null) {
            r2 = brush.hashCode();
        } else {
            r2 = 0;
        }
        int m2 = FlingCalculator$FlingInfo$$ExternalSyntheticOutline1.m(this.fillAlpha, (m + r2) * 31, 31);
        Brush brush2 = this.stroke;
        if (brush2 != null) {
            r1 = brush2.hashCode();
        }
        return Integer.hashCode(this.pathFillType) + FlingCalculator$FlingInfo$$ExternalSyntheticOutline1.m(this.trimPathOffset, FlingCalculator$FlingInfo$$ExternalSyntheticOutline1.m(this.trimPathEnd, FlingCalculator$FlingInfo$$ExternalSyntheticOutline1.m(this.trimPathStart, FlingCalculator$FlingInfo$$ExternalSyntheticOutline1.m(this.strokeLineMiter, HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.strokeLineJoin, HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.strokeLineCap, FlingCalculator$FlingInfo$$ExternalSyntheticOutline1.m(this.strokeLineWidth, FlingCalculator$FlingInfo$$ExternalSyntheticOutline1.m(this.strokeAlpha, (m2 + r1) * 31, 31), 31), 31), 31), 31), 31), 31), 31);
    }
}
