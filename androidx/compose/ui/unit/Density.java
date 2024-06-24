package androidx.compose.ui.unit;

import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import kotlin.math.MathKt__MathJVMKt;

/* compiled from: Density.kt */
/* loaded from: classes.dex */
public interface Density {
    float getDensity();

    float getFontScale();

    /* renamed from: roundToPx-0680j_4 */
    default int mo44roundToPx0680j_4(float f) {
        float mo49toPx0680j_4 = mo49toPx0680j_4(f);
        if (Float.isInfinite(mo49toPx0680j_4)) {
            return Integer.MAX_VALUE;
        }
        return MathKt__MathJVMKt.roundToInt(mo49toPx0680j_4);
    }

    /* renamed from: toDp-u2uoSUM */
    default float mo46toDpu2uoSUM(int r2) {
        return r2 / getDensity();
    }

    /* renamed from: toDpSize-k-rfVVM */
    default long mo47toDpSizekrfVVM(long j) {
        boolean z;
        if (j != Size.Unspecified) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return DpKt.m582DpSizeYgX7TsA(mo45toDpu2uoSUM(Size.m276getWidthimpl(j)), mo45toDpu2uoSUM(Size.m274getHeightimpl(j)));
        }
        return DpSize.Unspecified;
    }

    /* renamed from: toPx--R2X_6o */
    default float mo48toPxR2X_6o(long j) {
        if (TextUnitType.m601equalsimpl0(TextUnit.m597getTypeUIouoOA(j), 4294967296L)) {
            return getDensity() * getFontScale() * TextUnit.m598getValueimpl(j);
        }
        throw new IllegalStateException("Only Sp can convert to Px".toString());
    }

    /* renamed from: toPx-0680j_4 */
    default float mo49toPx0680j_4(float f) {
        return getDensity() * f;
    }

    /* renamed from: toSize-XkaWNTQ */
    default long mo50toSizeXkaWNTQ(long j) {
        boolean z;
        int r0 = DpSize.$r8$clinit;
        if (j != DpSize.Unspecified) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return SizeKt.Size(mo49toPx0680j_4(DpSize.m587getWidthD9Ej5fM(j)), mo49toPx0680j_4(DpSize.m586getHeightD9Ej5fM(j)));
        }
        int r3 = Size.$r8$clinit;
        return Size.Unspecified;
    }

    /* renamed from: toDp-u2uoSUM */
    default float mo45toDpu2uoSUM(float f) {
        return f / getDensity();
    }
}
