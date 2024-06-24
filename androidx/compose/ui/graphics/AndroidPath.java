package androidx.compose.ui.graphics;

import android.graphics.Path;
import android.graphics.RectF;
import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRect;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidPath.android.kt */
/* loaded from: classes.dex */
public final class AndroidPath implements Path {
    public final android.graphics.Path internalPath;
    public final android.graphics.Matrix mMatrix;
    public final float[] radii;
    public final RectF rectF;

    public AndroidPath() {
        this(0);
    }

    /* renamed from: addPath-Uv8p0NA, reason: not valid java name */
    public final void m303addPathUv8p0NA(Path path, long j) {
        if (path instanceof AndroidPath) {
            this.internalPath.addPath(((AndroidPath) path).internalPath, Offset.m259getXimpl(j), Offset.m260getYimpl(j));
            return;
        }
        throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
    }

    public final void addRect(Rect rect) {
        float f = rect.left;
        if (!Float.isNaN(f)) {
            float f2 = rect.top;
            if (!Float.isNaN(f2)) {
                float f3 = rect.right;
                if (!Float.isNaN(f3)) {
                    float f4 = rect.bottom;
                    if (!Float.isNaN(f4)) {
                        RectF rectF = this.rectF;
                        rectF.set(f, f2, f3, f4);
                        this.internalPath.addRect(rectF, Path.Direction.CCW);
                        return;
                    }
                    throw new IllegalStateException("Rect.bottom is NaN".toString());
                }
                throw new IllegalStateException("Rect.right is NaN".toString());
            }
            throw new IllegalStateException("Rect.top is NaN".toString());
        }
        throw new IllegalStateException("Rect.left is NaN".toString());
    }

    @Override // androidx.compose.ui.graphics.Path
    public final void addRoundRect(RoundRect roundRect) {
        Intrinsics.checkNotNullParameter(roundRect, "roundRect");
        RectF rectF = this.rectF;
        rectF.set(roundRect.left, roundRect.top, roundRect.right, roundRect.bottom);
        long j = roundRect.topLeftCornerRadius;
        float m253getXimpl = CornerRadius.m253getXimpl(j);
        float[] fArr = this.radii;
        fArr[0] = m253getXimpl;
        fArr[1] = CornerRadius.m254getYimpl(j);
        long j2 = roundRect.topRightCornerRadius;
        fArr[2] = CornerRadius.m253getXimpl(j2);
        fArr[3] = CornerRadius.m254getYimpl(j2);
        long j3 = roundRect.bottomRightCornerRadius;
        fArr[4] = CornerRadius.m253getXimpl(j3);
        fArr[5] = CornerRadius.m254getYimpl(j3);
        long j4 = roundRect.bottomLeftCornerRadius;
        fArr[6] = CornerRadius.m253getXimpl(j4);
        fArr[7] = CornerRadius.m254getYimpl(j4);
        this.internalPath.addRoundRect(rectF, fArr, Path.Direction.CCW);
    }

    @Override // androidx.compose.ui.graphics.Path
    public final void close() {
        this.internalPath.close();
    }

    @Override // androidx.compose.ui.graphics.Path
    public final void cubicTo(float f, float f2, float f3, float f4, float f5, float f6) {
        this.internalPath.cubicTo(f, f2, f3, f4, f5, f6);
    }

    @Override // androidx.compose.ui.graphics.Path
    /* renamed from: getFillType-Rg-k1Os, reason: not valid java name */
    public final int mo304getFillTypeRgk1Os() {
        if (this.internalPath.getFillType() == Path.FillType.EVEN_ODD) {
            return 1;
        }
        return 0;
    }

    @Override // androidx.compose.ui.graphics.Path
    public final boolean isConvex() {
        return this.internalPath.isConvex();
    }

    public final boolean isEmpty() {
        return this.internalPath.isEmpty();
    }

    @Override // androidx.compose.ui.graphics.Path
    public final void lineTo(float f, float f2) {
        this.internalPath.lineTo(f, f2);
    }

    @Override // androidx.compose.ui.graphics.Path
    public final void moveTo(float f, float f2) {
        this.internalPath.moveTo(f, f2);
    }

    @Override // androidx.compose.ui.graphics.Path
    /* renamed from: op-N5in7k0, reason: not valid java name */
    public final boolean mo305opN5in7k0(Path path1, Path path, int r6) {
        boolean z;
        boolean z2;
        boolean z3;
        Path.Op op;
        Intrinsics.checkNotNullParameter(path1, "path1");
        boolean z4 = false;
        if (r6 == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            op = Path.Op.DIFFERENCE;
        } else {
            if (r6 == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                op = Path.Op.INTERSECT;
            } else {
                if (r6 == 4) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z3) {
                    op = Path.Op.REVERSE_DIFFERENCE;
                } else {
                    if (r6 == 2) {
                        z4 = true;
                    }
                    if (z4) {
                        op = Path.Op.UNION;
                    } else {
                        op = Path.Op.XOR;
                    }
                }
            }
        }
        if (path1 instanceof AndroidPath) {
            AndroidPath androidPath = (AndroidPath) path1;
            if (path instanceof AndroidPath) {
                return this.internalPath.op(androidPath.internalPath, ((AndroidPath) path).internalPath, op);
            }
            throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
        }
        throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
    }

    @Override // androidx.compose.ui.graphics.Path
    public final void quadraticBezierTo(float f, float f2, float f3, float f4) {
        this.internalPath.quadTo(f, f2, f3, f4);
    }

    @Override // androidx.compose.ui.graphics.Path
    public final void relativeCubicTo(float f, float f2, float f3, float f4, float f5, float f6) {
        this.internalPath.rCubicTo(f, f2, f3, f4, f5, f6);
    }

    @Override // androidx.compose.ui.graphics.Path
    public final void relativeLineTo(float f, float f2) {
        this.internalPath.rLineTo(f, f2);
    }

    @Override // androidx.compose.ui.graphics.Path
    public final void relativeMoveTo(float f, float f2) {
        this.internalPath.rMoveTo(f, f2);
    }

    @Override // androidx.compose.ui.graphics.Path
    public final void relativeQuadraticBezierTo(float f, float f2, float f3, float f4) {
        this.internalPath.rQuadTo(f, f2, f3, f4);
    }

    @Override // androidx.compose.ui.graphics.Path
    public final void reset() {
        this.internalPath.reset();
    }

    @Override // androidx.compose.ui.graphics.Path
    public final void rewind() {
        this.internalPath.rewind();
    }

    @Override // androidx.compose.ui.graphics.Path
    /* renamed from: setFillType-oQ8Xj4U, reason: not valid java name */
    public final void mo306setFillTypeoQ8Xj4U(int r2) {
        Path.FillType fillType;
        boolean z = true;
        if (r2 != 1) {
            z = false;
        }
        if (z) {
            fillType = Path.FillType.EVEN_ODD;
        } else {
            fillType = Path.FillType.WINDING;
        }
        this.internalPath.setFillType(fillType);
    }

    /* renamed from: translate-k-4lQ0M, reason: not valid java name */
    public final void m307translatek4lQ0M(long j) {
        android.graphics.Matrix matrix = this.mMatrix;
        matrix.reset();
        matrix.setTranslate(Offset.m259getXimpl(j), Offset.m260getYimpl(j));
        this.internalPath.transform(matrix);
    }

    public AndroidPath(android.graphics.Path internalPath) {
        Intrinsics.checkNotNullParameter(internalPath, "internalPath");
        this.internalPath = internalPath;
        this.rectF = new RectF();
        this.radii = new float[8];
        this.mMatrix = new android.graphics.Matrix();
    }

    public /* synthetic */ AndroidPath(int r1) {
        this(new android.graphics.Path());
    }
}
