package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.RoundRect;

/* compiled from: Path.kt */
/* loaded from: classes.dex */
public interface Path {
    void addRoundRect(RoundRect roundRect);

    void close();

    void cubicTo(float f, float f2, float f3, float f4, float f5, float f6);

    /* renamed from: getFillType-Rg-k1Os */
    int mo304getFillTypeRgk1Os();

    boolean isConvex();

    void lineTo(float f, float f2);

    void moveTo(float f, float f2);

    /* renamed from: op-N5in7k0 */
    boolean mo305opN5in7k0(Path path, Path path2, int r3);

    void quadraticBezierTo(float f, float f2, float f3, float f4);

    void relativeCubicTo(float f, float f2, float f3, float f4, float f5, float f6);

    void relativeLineTo(float f, float f2);

    void relativeMoveTo(float f, float f2);

    void relativeQuadraticBezierTo(float f, float f2, float f3, float f4);

    void reset();

    default void rewind() {
        reset();
    }

    /* renamed from: setFillType-oQ8Xj4U */
    void mo306setFillTypeoQ8Xj4U(int r1);
}
