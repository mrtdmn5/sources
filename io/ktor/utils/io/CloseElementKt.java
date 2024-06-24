package io.ktor.utils.io;

import androidx.compose.foundation.text.TextDelegateKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: CloseElement.kt */
/* loaded from: classes3.dex */
public final class CloseElementKt {
    public static final CloseElement CLOSED_SUCCESS = new CloseElement(null);

    /* renamed from: finalConstraints-tfFHcEY, reason: not valid java name */
    public static final long m1651finalConstraintstfFHcEY(long j, boolean z, int r5, float f) {
        int r4;
        boolean z2;
        boolean z3 = true;
        if (!z) {
            if (r5 == 2) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2) {
                z3 = false;
            }
        }
        if (z3 && Constraints.m561getHasBoundedWidthimpl(j)) {
            r4 = Constraints.m565getMaxWidthimpl(j);
        } else {
            r4 = Integer.MAX_VALUE;
        }
        if (Constraints.m567getMinWidthimpl(j) != r4) {
            r4 = RangesKt___RangesKt.coerceIn(TextDelegateKt.ceilToIntPx(f), Constraints.m567getMinWidthimpl(j), r4);
        }
        return ConstraintsKt.Constraints$default(r4, Constraints.m564getMaxHeightimpl(j), 5);
    }
}
