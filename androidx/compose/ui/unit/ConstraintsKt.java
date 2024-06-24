package androidx.compose.ui.unit;

import androidx.compose.ui.unit.Constraints;
import com.google.firebase.concurrent.ExecutorsRegistrar$$ExternalSyntheticLambda8;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: Constraints.kt */
/* loaded from: classes.dex */
public final class ConstraintsKt {
    public static final long Constraints(int r4, int r5, int r6, int r7) {
        boolean z;
        boolean z2;
        boolean z3 = true;
        if (r5 >= r4) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            if (r7 >= r6) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                if (r4 < 0 || r6 < 0) {
                    z3 = false;
                }
                if (z3) {
                    return Constraints.Companion.m569createConstraintsZbe2FdA$ui_unit_release(r4, r5, r6, r7);
                }
                throw new IllegalArgumentException(ExecutorsRegistrar$$ExternalSyntheticLambda8.m("minWidth(", r4, ") and minHeight(", r6, ") must be >= 0").toString());
            }
            throw new IllegalArgumentException(("maxHeight(" + r7 + ") must be >= than minHeight(" + r6 + ')').toString());
        }
        throw new IllegalArgumentException(("maxWidth(" + r5 + ") must be >= than minWidth(" + r4 + ')').toString());
    }

    public static /* synthetic */ long Constraints$default(int r2, int r3, int r4) {
        if ((r4 & 2) != 0) {
            r2 = Integer.MAX_VALUE;
        }
        if ((r4 & 8) != 0) {
            r3 = Integer.MAX_VALUE;
        }
        return Constraints(0, r2, 0, r3);
    }

    /* renamed from: constrain-4WqzIAM */
    public static final long m573constrain4WqzIAM(long j, long j2) {
        return IntSizeKt.IntSize(RangesKt___RangesKt.coerceIn((int) (j2 >> 32), Constraints.m567getMinWidthimpl(j), Constraints.m565getMaxWidthimpl(j)), RangesKt___RangesKt.coerceIn(IntSize.m593getHeightimpl(j2), Constraints.m566getMinHeightimpl(j), Constraints.m564getMaxHeightimpl(j)));
    }

    /* renamed from: constrain-N9IONVI */
    public static final long m574constrainN9IONVI(long j, long j2) {
        return Constraints(RangesKt___RangesKt.coerceIn(Constraints.m567getMinWidthimpl(j2), Constraints.m567getMinWidthimpl(j), Constraints.m565getMaxWidthimpl(j)), RangesKt___RangesKt.coerceIn(Constraints.m565getMaxWidthimpl(j2), Constraints.m567getMinWidthimpl(j), Constraints.m565getMaxWidthimpl(j)), RangesKt___RangesKt.coerceIn(Constraints.m566getMinHeightimpl(j2), Constraints.m566getMinHeightimpl(j), Constraints.m564getMaxHeightimpl(j)), RangesKt___RangesKt.coerceIn(Constraints.m564getMaxHeightimpl(j2), Constraints.m566getMinHeightimpl(j), Constraints.m564getMaxHeightimpl(j)));
    }

    /* renamed from: constrainHeight-K40F9xA */
    public static final int m575constrainHeightK40F9xA(int r1, long j) {
        return RangesKt___RangesKt.coerceIn(r1, Constraints.m566getMinHeightimpl(j), Constraints.m564getMaxHeightimpl(j));
    }

    /* renamed from: constrainWidth-K40F9xA */
    public static final int m576constrainWidthK40F9xA(int r1, long j) {
        return RangesKt___RangesKt.coerceIn(r1, Constraints.m567getMinWidthimpl(j), Constraints.m565getMaxWidthimpl(j));
    }

    /* renamed from: isSatisfiedBy-4WqzIAM */
    public static final boolean m577isSatisfiedBy4WqzIAM(long j, long j2) {
        boolean z;
        boolean z2;
        int m567getMinWidthimpl = Constraints.m567getMinWidthimpl(j);
        int m565getMaxWidthimpl = Constraints.m565getMaxWidthimpl(j);
        int r2 = (int) (j2 >> 32);
        if (m567getMinWidthimpl <= r2 && r2 <= m565getMaxWidthimpl) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            int m566getMinHeightimpl = Constraints.m566getMinHeightimpl(j);
            int m564getMaxHeightimpl = Constraints.m564getMaxHeightimpl(j);
            int m593getHeightimpl = IntSize.m593getHeightimpl(j2);
            if (m566getMinHeightimpl <= m593getHeightimpl && m593getHeightimpl <= m564getMaxHeightimpl) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: offset-NN6Ew-U */
    public static final long m578offsetNN6EwU(long j, int r6, int r7) {
        int m567getMinWidthimpl = Constraints.m567getMinWidthimpl(j) + r6;
        int r1 = 0;
        if (m567getMinWidthimpl < 0) {
            m567getMinWidthimpl = 0;
        }
        int m565getMaxWidthimpl = Constraints.m565getMaxWidthimpl(j);
        if (m565getMaxWidthimpl != Integer.MAX_VALUE && (m565getMaxWidthimpl = m565getMaxWidthimpl + r6) < 0) {
            m565getMaxWidthimpl = 0;
        }
        int m566getMinHeightimpl = Constraints.m566getMinHeightimpl(j) + r7;
        if (m566getMinHeightimpl < 0) {
            m566getMinHeightimpl = 0;
        }
        int m564getMaxHeightimpl = Constraints.m564getMaxHeightimpl(j);
        if (m564getMaxHeightimpl == Integer.MAX_VALUE || (m564getMaxHeightimpl = m564getMaxHeightimpl + r7) >= 0) {
            r1 = m564getMaxHeightimpl;
        }
        return Constraints(m567getMinWidthimpl, m565getMaxWidthimpl, m566getMinHeightimpl, r1);
    }
}
