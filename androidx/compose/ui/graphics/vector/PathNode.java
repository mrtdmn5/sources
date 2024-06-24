package androidx.compose.ui.graphics.vector;

import androidx.compose.animation.AndroidFlingSpline$FlingResult$$ExternalSyntheticOutline0;
import androidx.compose.animation.FlingCalculator$FlingInfo$$ExternalSyntheticOutline1;

/* compiled from: PathNode.kt */
/* loaded from: classes.dex */
public abstract class PathNode {
    public final boolean isCurve;
    public final boolean isQuad;

    /* compiled from: PathNode.kt */
    /* loaded from: classes.dex */
    public static final class ArcTo extends PathNode {
        public final float arcStartX;
        public final float arcStartY;
        public final float horizontalEllipseRadius;
        public final boolean isMoreThanHalf;
        public final boolean isPositiveArc;
        public final float theta;
        public final float verticalEllipseRadius;

        public ArcTo(float f, float f2, float f3, boolean z, boolean z2, float f4, float f5) {
            super(false, false, 3);
            this.horizontalEllipseRadius = f;
            this.verticalEllipseRadius = f2;
            this.theta = f3;
            this.isMoreThanHalf = z;
            this.isPositiveArc = z2;
            this.arcStartX = f4;
            this.arcStartY = f5;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ArcTo)) {
                return false;
            }
            ArcTo arcTo = (ArcTo) obj;
            if (Float.compare(this.horizontalEllipseRadius, arcTo.horizontalEllipseRadius) == 0 && Float.compare(this.verticalEllipseRadius, arcTo.verticalEllipseRadius) == 0 && Float.compare(this.theta, arcTo.theta) == 0 && this.isMoreThanHalf == arcTo.isMoreThanHalf && this.isPositiveArc == arcTo.isPositiveArc && Float.compare(this.arcStartX, arcTo.arcStartX) == 0 && Float.compare(this.arcStartY, arcTo.arcStartY) == 0) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final int hashCode() {
            int m = FlingCalculator$FlingInfo$$ExternalSyntheticOutline1.m(this.theta, FlingCalculator$FlingInfo$$ExternalSyntheticOutline1.m(this.verticalEllipseRadius, Float.hashCode(this.horizontalEllipseRadius) * 31, 31), 31);
            int r1 = 1;
            boolean z = this.isMoreThanHalf;
            int r2 = z;
            if (z != 0) {
                r2 = 1;
            }
            int r0 = (m + r2) * 31;
            boolean z2 = this.isPositiveArc;
            if (!z2) {
                r1 = z2 ? 1 : 0;
            }
            return Float.hashCode(this.arcStartY) + FlingCalculator$FlingInfo$$ExternalSyntheticOutline1.m(this.arcStartX, (r0 + r1) * 31, 31);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("ArcTo(horizontalEllipseRadius=");
            sb.append(this.horizontalEllipseRadius);
            sb.append(", verticalEllipseRadius=");
            sb.append(this.verticalEllipseRadius);
            sb.append(", theta=");
            sb.append(this.theta);
            sb.append(", isMoreThanHalf=");
            sb.append(this.isMoreThanHalf);
            sb.append(", isPositiveArc=");
            sb.append(this.isPositiveArc);
            sb.append(", arcStartX=");
            sb.append(this.arcStartX);
            sb.append(", arcStartY=");
            return AndroidFlingSpline$FlingResult$$ExternalSyntheticOutline0.m(sb, this.arcStartY, ')');
        }
    }

    /* compiled from: PathNode.kt */
    /* loaded from: classes.dex */
    public static final class Close extends PathNode {
        public static final Close INSTANCE = new Close();

        public Close() {
            super(false, false, 3);
        }
    }

    /* compiled from: PathNode.kt */
    /* loaded from: classes.dex */
    public static final class CurveTo extends PathNode {
        public final float x1;
        public final float x2;
        public final float x3;
        public final float y1;
        public final float y2;
        public final float y3;

        public CurveTo(float f, float f2, float f3, float f4, float f5, float f6) {
            super(true, false, 2);
            this.x1 = f;
            this.y1 = f2;
            this.x2 = f3;
            this.y2 = f4;
            this.x3 = f5;
            this.y3 = f6;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CurveTo)) {
                return false;
            }
            CurveTo curveTo = (CurveTo) obj;
            if (Float.compare(this.x1, curveTo.x1) == 0 && Float.compare(this.y1, curveTo.y1) == 0 && Float.compare(this.x2, curveTo.x2) == 0 && Float.compare(this.y2, curveTo.y2) == 0 && Float.compare(this.x3, curveTo.x3) == 0 && Float.compare(this.y3, curveTo.y3) == 0) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            return Float.hashCode(this.y3) + FlingCalculator$FlingInfo$$ExternalSyntheticOutline1.m(this.x3, FlingCalculator$FlingInfo$$ExternalSyntheticOutline1.m(this.y2, FlingCalculator$FlingInfo$$ExternalSyntheticOutline1.m(this.x2, FlingCalculator$FlingInfo$$ExternalSyntheticOutline1.m(this.y1, Float.hashCode(this.x1) * 31, 31), 31), 31), 31);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("CurveTo(x1=");
            sb.append(this.x1);
            sb.append(", y1=");
            sb.append(this.y1);
            sb.append(", x2=");
            sb.append(this.x2);
            sb.append(", y2=");
            sb.append(this.y2);
            sb.append(", x3=");
            sb.append(this.x3);
            sb.append(", y3=");
            return AndroidFlingSpline$FlingResult$$ExternalSyntheticOutline0.m(sb, this.y3, ')');
        }
    }

    /* compiled from: PathNode.kt */
    /* loaded from: classes.dex */
    public static final class HorizontalTo extends PathNode {
        public final float x;

        public HorizontalTo(float f) {
            super(false, false, 3);
            this.x = f;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof HorizontalTo) && Float.compare(this.x, ((HorizontalTo) obj).x) == 0) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            return Float.hashCode(this.x);
        }

        public final String toString() {
            return AndroidFlingSpline$FlingResult$$ExternalSyntheticOutline0.m(new StringBuilder("HorizontalTo(x="), this.x, ')');
        }
    }

    /* compiled from: PathNode.kt */
    /* loaded from: classes.dex */
    public static final class LineTo extends PathNode {
        public final float x;
        public final float y;

        public LineTo(float f, float f2) {
            super(false, false, 3);
            this.x = f;
            this.y = f2;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof LineTo)) {
                return false;
            }
            LineTo lineTo = (LineTo) obj;
            if (Float.compare(this.x, lineTo.x) == 0 && Float.compare(this.y, lineTo.y) == 0) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            return Float.hashCode(this.y) + (Float.hashCode(this.x) * 31);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("LineTo(x=");
            sb.append(this.x);
            sb.append(", y=");
            return AndroidFlingSpline$FlingResult$$ExternalSyntheticOutline0.m(sb, this.y, ')');
        }
    }

    /* compiled from: PathNode.kt */
    /* loaded from: classes.dex */
    public static final class MoveTo extends PathNode {
        public final float x;
        public final float y;

        public MoveTo(float f, float f2) {
            super(false, false, 3);
            this.x = f;
            this.y = f2;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof MoveTo)) {
                return false;
            }
            MoveTo moveTo = (MoveTo) obj;
            if (Float.compare(this.x, moveTo.x) == 0 && Float.compare(this.y, moveTo.y) == 0) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            return Float.hashCode(this.y) + (Float.hashCode(this.x) * 31);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("MoveTo(x=");
            sb.append(this.x);
            sb.append(", y=");
            return AndroidFlingSpline$FlingResult$$ExternalSyntheticOutline0.m(sb, this.y, ')');
        }
    }

    /* compiled from: PathNode.kt */
    /* loaded from: classes.dex */
    public static final class QuadTo extends PathNode {
        public final float x1;
        public final float x2;
        public final float y1;
        public final float y2;

        public QuadTo(float f, float f2, float f3, float f4) {
            super(false, true, 1);
            this.x1 = f;
            this.y1 = f2;
            this.x2 = f3;
            this.y2 = f4;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof QuadTo)) {
                return false;
            }
            QuadTo quadTo = (QuadTo) obj;
            if (Float.compare(this.x1, quadTo.x1) == 0 && Float.compare(this.y1, quadTo.y1) == 0 && Float.compare(this.x2, quadTo.x2) == 0 && Float.compare(this.y2, quadTo.y2) == 0) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            return Float.hashCode(this.y2) + FlingCalculator$FlingInfo$$ExternalSyntheticOutline1.m(this.x2, FlingCalculator$FlingInfo$$ExternalSyntheticOutline1.m(this.y1, Float.hashCode(this.x1) * 31, 31), 31);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("QuadTo(x1=");
            sb.append(this.x1);
            sb.append(", y1=");
            sb.append(this.y1);
            sb.append(", x2=");
            sb.append(this.x2);
            sb.append(", y2=");
            return AndroidFlingSpline$FlingResult$$ExternalSyntheticOutline0.m(sb, this.y2, ')');
        }
    }

    /* compiled from: PathNode.kt */
    /* loaded from: classes.dex */
    public static final class ReflectiveCurveTo extends PathNode {
        public final float x1;
        public final float x2;
        public final float y1;
        public final float y2;

        public ReflectiveCurveTo(float f, float f2, float f3, float f4) {
            super(true, false, 2);
            this.x1 = f;
            this.y1 = f2;
            this.x2 = f3;
            this.y2 = f4;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ReflectiveCurveTo)) {
                return false;
            }
            ReflectiveCurveTo reflectiveCurveTo = (ReflectiveCurveTo) obj;
            if (Float.compare(this.x1, reflectiveCurveTo.x1) == 0 && Float.compare(this.y1, reflectiveCurveTo.y1) == 0 && Float.compare(this.x2, reflectiveCurveTo.x2) == 0 && Float.compare(this.y2, reflectiveCurveTo.y2) == 0) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            return Float.hashCode(this.y2) + FlingCalculator$FlingInfo$$ExternalSyntheticOutline1.m(this.x2, FlingCalculator$FlingInfo$$ExternalSyntheticOutline1.m(this.y1, Float.hashCode(this.x1) * 31, 31), 31);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("ReflectiveCurveTo(x1=");
            sb.append(this.x1);
            sb.append(", y1=");
            sb.append(this.y1);
            sb.append(", x2=");
            sb.append(this.x2);
            sb.append(", y2=");
            return AndroidFlingSpline$FlingResult$$ExternalSyntheticOutline0.m(sb, this.y2, ')');
        }
    }

    /* compiled from: PathNode.kt */
    /* loaded from: classes.dex */
    public static final class ReflectiveQuadTo extends PathNode {
        public final float x;
        public final float y;

        public ReflectiveQuadTo(float f, float f2) {
            super(false, true, 1);
            this.x = f;
            this.y = f2;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ReflectiveQuadTo)) {
                return false;
            }
            ReflectiveQuadTo reflectiveQuadTo = (ReflectiveQuadTo) obj;
            if (Float.compare(this.x, reflectiveQuadTo.x) == 0 && Float.compare(this.y, reflectiveQuadTo.y) == 0) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            return Float.hashCode(this.y) + (Float.hashCode(this.x) * 31);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("ReflectiveQuadTo(x=");
            sb.append(this.x);
            sb.append(", y=");
            return AndroidFlingSpline$FlingResult$$ExternalSyntheticOutline0.m(sb, this.y, ')');
        }
    }

    /* compiled from: PathNode.kt */
    /* loaded from: classes.dex */
    public static final class RelativeArcTo extends PathNode {
        public final float arcStartDx;
        public final float arcStartDy;
        public final float horizontalEllipseRadius;
        public final boolean isMoreThanHalf;
        public final boolean isPositiveArc;
        public final float theta;
        public final float verticalEllipseRadius;

        public RelativeArcTo(float f, float f2, float f3, boolean z, boolean z2, float f4, float f5) {
            super(false, false, 3);
            this.horizontalEllipseRadius = f;
            this.verticalEllipseRadius = f2;
            this.theta = f3;
            this.isMoreThanHalf = z;
            this.isPositiveArc = z2;
            this.arcStartDx = f4;
            this.arcStartDy = f5;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RelativeArcTo)) {
                return false;
            }
            RelativeArcTo relativeArcTo = (RelativeArcTo) obj;
            if (Float.compare(this.horizontalEllipseRadius, relativeArcTo.horizontalEllipseRadius) == 0 && Float.compare(this.verticalEllipseRadius, relativeArcTo.verticalEllipseRadius) == 0 && Float.compare(this.theta, relativeArcTo.theta) == 0 && this.isMoreThanHalf == relativeArcTo.isMoreThanHalf && this.isPositiveArc == relativeArcTo.isPositiveArc && Float.compare(this.arcStartDx, relativeArcTo.arcStartDx) == 0 && Float.compare(this.arcStartDy, relativeArcTo.arcStartDy) == 0) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final int hashCode() {
            int m = FlingCalculator$FlingInfo$$ExternalSyntheticOutline1.m(this.theta, FlingCalculator$FlingInfo$$ExternalSyntheticOutline1.m(this.verticalEllipseRadius, Float.hashCode(this.horizontalEllipseRadius) * 31, 31), 31);
            int r1 = 1;
            boolean z = this.isMoreThanHalf;
            int r2 = z;
            if (z != 0) {
                r2 = 1;
            }
            int r0 = (m + r2) * 31;
            boolean z2 = this.isPositiveArc;
            if (!z2) {
                r1 = z2 ? 1 : 0;
            }
            return Float.hashCode(this.arcStartDy) + FlingCalculator$FlingInfo$$ExternalSyntheticOutline1.m(this.arcStartDx, (r0 + r1) * 31, 31);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("RelativeArcTo(horizontalEllipseRadius=");
            sb.append(this.horizontalEllipseRadius);
            sb.append(", verticalEllipseRadius=");
            sb.append(this.verticalEllipseRadius);
            sb.append(", theta=");
            sb.append(this.theta);
            sb.append(", isMoreThanHalf=");
            sb.append(this.isMoreThanHalf);
            sb.append(", isPositiveArc=");
            sb.append(this.isPositiveArc);
            sb.append(", arcStartDx=");
            sb.append(this.arcStartDx);
            sb.append(", arcStartDy=");
            return AndroidFlingSpline$FlingResult$$ExternalSyntheticOutline0.m(sb, this.arcStartDy, ')');
        }
    }

    /* compiled from: PathNode.kt */
    /* loaded from: classes.dex */
    public static final class RelativeCurveTo extends PathNode {
        public final float dx1;
        public final float dx2;
        public final float dx3;
        public final float dy1;
        public final float dy2;
        public final float dy3;

        public RelativeCurveTo(float f, float f2, float f3, float f4, float f5, float f6) {
            super(true, false, 2);
            this.dx1 = f;
            this.dy1 = f2;
            this.dx2 = f3;
            this.dy2 = f4;
            this.dx3 = f5;
            this.dy3 = f6;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RelativeCurveTo)) {
                return false;
            }
            RelativeCurveTo relativeCurveTo = (RelativeCurveTo) obj;
            if (Float.compare(this.dx1, relativeCurveTo.dx1) == 0 && Float.compare(this.dy1, relativeCurveTo.dy1) == 0 && Float.compare(this.dx2, relativeCurveTo.dx2) == 0 && Float.compare(this.dy2, relativeCurveTo.dy2) == 0 && Float.compare(this.dx3, relativeCurveTo.dx3) == 0 && Float.compare(this.dy3, relativeCurveTo.dy3) == 0) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            return Float.hashCode(this.dy3) + FlingCalculator$FlingInfo$$ExternalSyntheticOutline1.m(this.dx3, FlingCalculator$FlingInfo$$ExternalSyntheticOutline1.m(this.dy2, FlingCalculator$FlingInfo$$ExternalSyntheticOutline1.m(this.dx2, FlingCalculator$FlingInfo$$ExternalSyntheticOutline1.m(this.dy1, Float.hashCode(this.dx1) * 31, 31), 31), 31), 31);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("RelativeCurveTo(dx1=");
            sb.append(this.dx1);
            sb.append(", dy1=");
            sb.append(this.dy1);
            sb.append(", dx2=");
            sb.append(this.dx2);
            sb.append(", dy2=");
            sb.append(this.dy2);
            sb.append(", dx3=");
            sb.append(this.dx3);
            sb.append(", dy3=");
            return AndroidFlingSpline$FlingResult$$ExternalSyntheticOutline0.m(sb, this.dy3, ')');
        }
    }

    /* compiled from: PathNode.kt */
    /* loaded from: classes.dex */
    public static final class RelativeHorizontalTo extends PathNode {
        public final float dx;

        public RelativeHorizontalTo(float f) {
            super(false, false, 3);
            this.dx = f;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof RelativeHorizontalTo) && Float.compare(this.dx, ((RelativeHorizontalTo) obj).dx) == 0) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            return Float.hashCode(this.dx);
        }

        public final String toString() {
            return AndroidFlingSpline$FlingResult$$ExternalSyntheticOutline0.m(new StringBuilder("RelativeHorizontalTo(dx="), this.dx, ')');
        }
    }

    /* compiled from: PathNode.kt */
    /* loaded from: classes.dex */
    public static final class RelativeLineTo extends PathNode {
        public final float dx;
        public final float dy;

        public RelativeLineTo(float f, float f2) {
            super(false, false, 3);
            this.dx = f;
            this.dy = f2;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RelativeLineTo)) {
                return false;
            }
            RelativeLineTo relativeLineTo = (RelativeLineTo) obj;
            if (Float.compare(this.dx, relativeLineTo.dx) == 0 && Float.compare(this.dy, relativeLineTo.dy) == 0) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            return Float.hashCode(this.dy) + (Float.hashCode(this.dx) * 31);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("RelativeLineTo(dx=");
            sb.append(this.dx);
            sb.append(", dy=");
            return AndroidFlingSpline$FlingResult$$ExternalSyntheticOutline0.m(sb, this.dy, ')');
        }
    }

    /* compiled from: PathNode.kt */
    /* loaded from: classes.dex */
    public static final class RelativeMoveTo extends PathNode {
        public final float dx;
        public final float dy;

        public RelativeMoveTo(float f, float f2) {
            super(false, false, 3);
            this.dx = f;
            this.dy = f2;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RelativeMoveTo)) {
                return false;
            }
            RelativeMoveTo relativeMoveTo = (RelativeMoveTo) obj;
            if (Float.compare(this.dx, relativeMoveTo.dx) == 0 && Float.compare(this.dy, relativeMoveTo.dy) == 0) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            return Float.hashCode(this.dy) + (Float.hashCode(this.dx) * 31);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("RelativeMoveTo(dx=");
            sb.append(this.dx);
            sb.append(", dy=");
            return AndroidFlingSpline$FlingResult$$ExternalSyntheticOutline0.m(sb, this.dy, ')');
        }
    }

    /* compiled from: PathNode.kt */
    /* loaded from: classes.dex */
    public static final class RelativeQuadTo extends PathNode {
        public final float dx1;
        public final float dx2;
        public final float dy1;
        public final float dy2;

        public RelativeQuadTo(float f, float f2, float f3, float f4) {
            super(false, true, 1);
            this.dx1 = f;
            this.dy1 = f2;
            this.dx2 = f3;
            this.dy2 = f4;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RelativeQuadTo)) {
                return false;
            }
            RelativeQuadTo relativeQuadTo = (RelativeQuadTo) obj;
            if (Float.compare(this.dx1, relativeQuadTo.dx1) == 0 && Float.compare(this.dy1, relativeQuadTo.dy1) == 0 && Float.compare(this.dx2, relativeQuadTo.dx2) == 0 && Float.compare(this.dy2, relativeQuadTo.dy2) == 0) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            return Float.hashCode(this.dy2) + FlingCalculator$FlingInfo$$ExternalSyntheticOutline1.m(this.dx2, FlingCalculator$FlingInfo$$ExternalSyntheticOutline1.m(this.dy1, Float.hashCode(this.dx1) * 31, 31), 31);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("RelativeQuadTo(dx1=");
            sb.append(this.dx1);
            sb.append(", dy1=");
            sb.append(this.dy1);
            sb.append(", dx2=");
            sb.append(this.dx2);
            sb.append(", dy2=");
            return AndroidFlingSpline$FlingResult$$ExternalSyntheticOutline0.m(sb, this.dy2, ')');
        }
    }

    /* compiled from: PathNode.kt */
    /* loaded from: classes.dex */
    public static final class RelativeReflectiveCurveTo extends PathNode {
        public final float dx1;
        public final float dx2;
        public final float dy1;
        public final float dy2;

        public RelativeReflectiveCurveTo(float f, float f2, float f3, float f4) {
            super(true, false, 2);
            this.dx1 = f;
            this.dy1 = f2;
            this.dx2 = f3;
            this.dy2 = f4;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RelativeReflectiveCurveTo)) {
                return false;
            }
            RelativeReflectiveCurveTo relativeReflectiveCurveTo = (RelativeReflectiveCurveTo) obj;
            if (Float.compare(this.dx1, relativeReflectiveCurveTo.dx1) == 0 && Float.compare(this.dy1, relativeReflectiveCurveTo.dy1) == 0 && Float.compare(this.dx2, relativeReflectiveCurveTo.dx2) == 0 && Float.compare(this.dy2, relativeReflectiveCurveTo.dy2) == 0) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            return Float.hashCode(this.dy2) + FlingCalculator$FlingInfo$$ExternalSyntheticOutline1.m(this.dx2, FlingCalculator$FlingInfo$$ExternalSyntheticOutline1.m(this.dy1, Float.hashCode(this.dx1) * 31, 31), 31);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("RelativeReflectiveCurveTo(dx1=");
            sb.append(this.dx1);
            sb.append(", dy1=");
            sb.append(this.dy1);
            sb.append(", dx2=");
            sb.append(this.dx2);
            sb.append(", dy2=");
            return AndroidFlingSpline$FlingResult$$ExternalSyntheticOutline0.m(sb, this.dy2, ')');
        }
    }

    /* compiled from: PathNode.kt */
    /* loaded from: classes.dex */
    public static final class RelativeReflectiveQuadTo extends PathNode {
        public final float dx;
        public final float dy;

        public RelativeReflectiveQuadTo(float f, float f2) {
            super(false, true, 1);
            this.dx = f;
            this.dy = f2;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RelativeReflectiveQuadTo)) {
                return false;
            }
            RelativeReflectiveQuadTo relativeReflectiveQuadTo = (RelativeReflectiveQuadTo) obj;
            if (Float.compare(this.dx, relativeReflectiveQuadTo.dx) == 0 && Float.compare(this.dy, relativeReflectiveQuadTo.dy) == 0) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            return Float.hashCode(this.dy) + (Float.hashCode(this.dx) * 31);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("RelativeReflectiveQuadTo(dx=");
            sb.append(this.dx);
            sb.append(", dy=");
            return AndroidFlingSpline$FlingResult$$ExternalSyntheticOutline0.m(sb, this.dy, ')');
        }
    }

    /* compiled from: PathNode.kt */
    /* loaded from: classes.dex */
    public static final class RelativeVerticalTo extends PathNode {
        public final float dy;

        public RelativeVerticalTo(float f) {
            super(false, false, 3);
            this.dy = f;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof RelativeVerticalTo) && Float.compare(this.dy, ((RelativeVerticalTo) obj).dy) == 0) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            return Float.hashCode(this.dy);
        }

        public final String toString() {
            return AndroidFlingSpline$FlingResult$$ExternalSyntheticOutline0.m(new StringBuilder("RelativeVerticalTo(dy="), this.dy, ')');
        }
    }

    /* compiled from: PathNode.kt */
    /* loaded from: classes.dex */
    public static final class VerticalTo extends PathNode {
        public final float y;

        public VerticalTo(float f) {
            super(false, false, 3);
            this.y = f;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj instanceof VerticalTo) && Float.compare(this.y, ((VerticalTo) obj).y) == 0) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            return Float.hashCode(this.y);
        }

        public final String toString() {
            return AndroidFlingSpline$FlingResult$$ExternalSyntheticOutline0.m(new StringBuilder("VerticalTo(y="), this.y, ')');
        }
    }

    public PathNode(boolean z, boolean z2, int r5) {
        z = (r5 & 1) != 0 ? false : z;
        z2 = (r5 & 2) != 0 ? false : z2;
        this.isCurve = z;
        this.isQuad = z2;
    }
}
