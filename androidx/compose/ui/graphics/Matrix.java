package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.MutableRect;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;

/* compiled from: Matrix.kt */
/* loaded from: classes.dex */
public final class Matrix {
    /* renamed from: constructor-impl$default, reason: not valid java name */
    public static float[] m337constructorimpl$default() {
        return new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    }

    /* renamed from: map-MK-Hz9U, reason: not valid java name */
    public static final long m338mapMKHz9U(float[] fArr, long j) {
        boolean z;
        float m259getXimpl = Offset.m259getXimpl(j);
        float m260getYimpl = Offset.m260getYimpl(j);
        float f = 1 / (((fArr[7] * m260getYimpl) + (fArr[3] * m259getXimpl)) + fArr[15]);
        if (!Float.isInfinite(f) && !Float.isNaN(f)) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            f = 0.0f;
        }
        return OffsetKt.Offset(((fArr[4] * m260getYimpl) + (fArr[0] * m259getXimpl) + fArr[12]) * f, ((fArr[5] * m260getYimpl) + (fArr[1] * m259getXimpl) + fArr[13]) * f);
    }

    /* renamed from: map-impl, reason: not valid java name */
    public static final void m339mapimpl(float[] fArr, MutableRect mutableRect) {
        long m338mapMKHz9U = m338mapMKHz9U(fArr, OffsetKt.Offset(mutableRect.left, mutableRect.top));
        long m338mapMKHz9U2 = m338mapMKHz9U(fArr, OffsetKt.Offset(mutableRect.left, mutableRect.bottom));
        long m338mapMKHz9U3 = m338mapMKHz9U(fArr, OffsetKt.Offset(mutableRect.right, mutableRect.top));
        long m338mapMKHz9U4 = m338mapMKHz9U(fArr, OffsetKt.Offset(mutableRect.right, mutableRect.bottom));
        mutableRect.left = Math.min(Math.min(Offset.m259getXimpl(m338mapMKHz9U), Offset.m259getXimpl(m338mapMKHz9U2)), Math.min(Offset.m259getXimpl(m338mapMKHz9U3), Offset.m259getXimpl(m338mapMKHz9U4)));
        mutableRect.top = Math.min(Math.min(Offset.m260getYimpl(m338mapMKHz9U), Offset.m260getYimpl(m338mapMKHz9U2)), Math.min(Offset.m260getYimpl(m338mapMKHz9U3), Offset.m260getYimpl(m338mapMKHz9U4)));
        mutableRect.right = Math.max(Math.max(Offset.m259getXimpl(m338mapMKHz9U), Offset.m259getXimpl(m338mapMKHz9U2)), Math.max(Offset.m259getXimpl(m338mapMKHz9U3), Offset.m259getXimpl(m338mapMKHz9U4)));
        mutableRect.bottom = Math.max(Math.max(Offset.m260getYimpl(m338mapMKHz9U), Offset.m260getYimpl(m338mapMKHz9U2)), Math.max(Offset.m260getYimpl(m338mapMKHz9U3), Offset.m260getYimpl(m338mapMKHz9U4)));
    }

    /* renamed from: reset-impl, reason: not valid java name */
    public static final void m340resetimpl(float[] fArr) {
        float f;
        for (int r1 = 0; r1 < 4; r1++) {
            for (int r3 = 0; r3 < 4; r3++) {
                if (r1 == r3) {
                    f = 1.0f;
                } else {
                    f = 0.0f;
                }
                fArr[(r3 * 4) + r1] = f;
            }
        }
    }

    /* renamed from: translate-impl$default, reason: not valid java name */
    public static void m341translateimpl$default(float[] fArr, float f, float f2) {
        float f3 = (fArr[8] * 0.0f) + (fArr[4] * f2) + (fArr[0] * f) + fArr[12];
        float f4 = (fArr[9] * 0.0f) + (fArr[5] * f2) + (fArr[1] * f) + fArr[13];
        float f5 = (fArr[10] * 0.0f) + (fArr[6] * f2) + (fArr[2] * f) + fArr[14];
        float f6 = (fArr[11] * 0.0f) + (fArr[7] * f2) + (fArr[3] * f) + fArr[15];
        fArr[12] = f3;
        fArr[13] = f4;
        fArr[14] = f5;
        fArr[15] = f6;
    }
}
