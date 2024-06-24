package androidx.compose.foundation.lazy.layout;

import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.DpKt;
import androidx.compose.ui.unit.DpSize;
import java.util.List;

/* compiled from: LazyLayoutMeasureScope.kt */
/* loaded from: classes.dex */
public interface LazyLayoutMeasureScope extends MeasureScope {
    /* renamed from: measure-0kLqBqw, reason: not valid java name */
    List<Placeable> mo102measure0kLqBqw(int r1, long j);

    @Override // androidx.compose.ui.unit.Density
    /* renamed from: toDp-u2uoSUM */
    default float mo46toDpu2uoSUM(int r2) {
        return r2 / getDensity();
    }

    @Override // androidx.compose.ui.unit.Density
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

    @Override // androidx.compose.ui.unit.Density
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

    @Override // androidx.compose.ui.unit.Density
    /* renamed from: toDp-u2uoSUM */
    default float mo45toDpu2uoSUM(float f) {
        return f / getDensity();
    }
}
