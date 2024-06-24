package com.animaconnected.watch.graphs.utils;

import androidx.compose.animation.AndroidFlingSpline$FlingResult$$ExternalSyntheticOutline0;
import androidx.compose.animation.FlingCalculator$FlingInfo$$ExternalSyntheticOutline1;
import androidx.compose.foundation.text.HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChartDrawUtils.kt */
/* loaded from: classes3.dex */
public final class DrawBarOptions {
    private final int backTiltDegrees;
    private final float cornerRadius;
    private final int frontTiltDegrees;
    private final float margin;
    private final float segmentSpace;
    private final Float tiltBLCornerRadius;
    private final Float tiltBRCornerRadius;
    private final Float tiltTLCornerRadius;
    private final Float tiltTRCornerRadius;

    public DrawBarOptions() {
        this(0, 0, null, null, null, null, 0.0f, 0.0f, 0.0f, 511, null);
    }

    public static /* synthetic */ DrawBarOptions copy$default(DrawBarOptions drawBarOptions, int r11, int r12, Float f, Float f2, Float f3, Float f4, float f5, float f6, float f7, int r20, Object obj) {
        int r2;
        int r3;
        Float f8;
        Float f9;
        Float f10;
        Float f11;
        float f12;
        float f13;
        float f14;
        if ((r20 & 1) != 0) {
            r2 = drawBarOptions.backTiltDegrees;
        } else {
            r2 = r11;
        }
        if ((r20 & 2) != 0) {
            r3 = drawBarOptions.frontTiltDegrees;
        } else {
            r3 = r12;
        }
        if ((r20 & 4) != 0) {
            f8 = drawBarOptions.tiltTRCornerRadius;
        } else {
            f8 = f;
        }
        if ((r20 & 8) != 0) {
            f9 = drawBarOptions.tiltBRCornerRadius;
        } else {
            f9 = f2;
        }
        if ((r20 & 16) != 0) {
            f10 = drawBarOptions.tiltBLCornerRadius;
        } else {
            f10 = f3;
        }
        if ((r20 & 32) != 0) {
            f11 = drawBarOptions.tiltTLCornerRadius;
        } else {
            f11 = f4;
        }
        if ((r20 & 64) != 0) {
            f12 = drawBarOptions.cornerRadius;
        } else {
            f12 = f5;
        }
        if ((r20 & 128) != 0) {
            f13 = drawBarOptions.margin;
        } else {
            f13 = f6;
        }
        if ((r20 & 256) != 0) {
            f14 = drawBarOptions.segmentSpace;
        } else {
            f14 = f7;
        }
        return drawBarOptions.copy(r2, r3, f8, f9, f10, f11, f12, f13, f14);
    }

    public final int component1() {
        return this.backTiltDegrees;
    }

    public final int component2() {
        return this.frontTiltDegrees;
    }

    public final Float component3() {
        return this.tiltTRCornerRadius;
    }

    public final Float component4() {
        return this.tiltBRCornerRadius;
    }

    public final Float component5() {
        return this.tiltBLCornerRadius;
    }

    public final Float component6() {
        return this.tiltTLCornerRadius;
    }

    public final float component7() {
        return this.cornerRadius;
    }

    public final float component8() {
        return this.margin;
    }

    public final float component9() {
        return this.segmentSpace;
    }

    public final DrawBarOptions copy(int r12, int r13, Float f, Float f2, Float f3, Float f4, float f5, float f6, float f7) {
        return new DrawBarOptions(r12, r13, f, f2, f3, f4, f5, f6, f7);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DrawBarOptions)) {
            return false;
        }
        DrawBarOptions drawBarOptions = (DrawBarOptions) obj;
        if (this.backTiltDegrees == drawBarOptions.backTiltDegrees && this.frontTiltDegrees == drawBarOptions.frontTiltDegrees && Intrinsics.areEqual(this.tiltTRCornerRadius, drawBarOptions.tiltTRCornerRadius) && Intrinsics.areEqual(this.tiltBRCornerRadius, drawBarOptions.tiltBRCornerRadius) && Intrinsics.areEqual(this.tiltBLCornerRadius, drawBarOptions.tiltBLCornerRadius) && Intrinsics.areEqual(this.tiltTLCornerRadius, drawBarOptions.tiltTLCornerRadius) && Float.compare(this.cornerRadius, drawBarOptions.cornerRadius) == 0 && Float.compare(this.margin, drawBarOptions.margin) == 0 && Float.compare(this.segmentSpace, drawBarOptions.segmentSpace) == 0) {
            return true;
        }
        return false;
    }

    public final int getBackTiltDegrees() {
        return this.backTiltDegrees;
    }

    public final float getCornerRadius() {
        return this.cornerRadius;
    }

    public final int getFrontTiltDegrees() {
        return this.frontTiltDegrees;
    }

    public final float getMargin() {
        return this.margin;
    }

    public final float getSegmentSpace() {
        return this.segmentSpace;
    }

    public final Float getTiltBLCornerRadius() {
        return this.tiltBLCornerRadius;
    }

    public final Float getTiltBRCornerRadius() {
        return this.tiltBRCornerRadius;
    }

    public final Float getTiltTLCornerRadius() {
        return this.tiltTLCornerRadius;
    }

    public final Float getTiltTRCornerRadius() {
        return this.tiltTRCornerRadius;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int m = HorizontalScrollLayoutModifier$$ExternalSyntheticOutline0.m(this.frontTiltDegrees, Integer.hashCode(this.backTiltDegrees) * 31, 31);
        Float f = this.tiltTRCornerRadius;
        int r2 = 0;
        if (f == null) {
            hashCode = 0;
        } else {
            hashCode = f.hashCode();
        }
        int r0 = (m + hashCode) * 31;
        Float f2 = this.tiltBRCornerRadius;
        if (f2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = f2.hashCode();
        }
        int r02 = (r0 + hashCode2) * 31;
        Float f3 = this.tiltBLCornerRadius;
        if (f3 == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = f3.hashCode();
        }
        int r03 = (r02 + hashCode3) * 31;
        Float f4 = this.tiltTLCornerRadius;
        if (f4 != null) {
            r2 = f4.hashCode();
        }
        return Float.hashCode(this.segmentSpace) + FlingCalculator$FlingInfo$$ExternalSyntheticOutline1.m(this.margin, FlingCalculator$FlingInfo$$ExternalSyntheticOutline1.m(this.cornerRadius, (r03 + r2) * 31, 31), 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DrawBarOptions(backTiltDegrees=");
        sb.append(this.backTiltDegrees);
        sb.append(", frontTiltDegrees=");
        sb.append(this.frontTiltDegrees);
        sb.append(", tiltTRCornerRadius=");
        sb.append(this.tiltTRCornerRadius);
        sb.append(", tiltBRCornerRadius=");
        sb.append(this.tiltBRCornerRadius);
        sb.append(", tiltBLCornerRadius=");
        sb.append(this.tiltBLCornerRadius);
        sb.append(", tiltTLCornerRadius=");
        sb.append(this.tiltTLCornerRadius);
        sb.append(", cornerRadius=");
        sb.append(this.cornerRadius);
        sb.append(", margin=");
        sb.append(this.margin);
        sb.append(", segmentSpace=");
        return AndroidFlingSpline$FlingResult$$ExternalSyntheticOutline0.m(sb, this.segmentSpace, ')');
    }

    public DrawBarOptions(int r1, int r2, Float f, Float f2, Float f3, Float f4, float f5, float f6, float f7) {
        this.backTiltDegrees = r1;
        this.frontTiltDegrees = r2;
        this.tiltTRCornerRadius = f;
        this.tiltBRCornerRadius = f2;
        this.tiltBLCornerRadius = f3;
        this.tiltTLCornerRadius = f4;
        this.cornerRadius = f5;
        this.margin = f6;
        this.segmentSpace = f7;
    }

    public /* synthetic */ DrawBarOptions(int r11, int r12, Float f, Float f2, Float f3, Float f4, float f5, float f6, float f7, int r20, DefaultConstructorMarker defaultConstructorMarker) {
        this((r20 & 1) != 0 ? 0 : r11, (r20 & 2) == 0 ? r12 : 0, (r20 & 4) != 0 ? null : f, (r20 & 8) != 0 ? null : f2, (r20 & 16) != 0 ? null : f3, (r20 & 32) == 0 ? f4 : null, (r20 & 64) != 0 ? 0.0f : f5, (r20 & 128) != 0 ? 0.0f : f6, (r20 & 256) == 0 ? f7 : 0.0f);
    }
}
