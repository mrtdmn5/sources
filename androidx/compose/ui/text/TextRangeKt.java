package androidx.compose.ui.text;

import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: TextRange.kt */
/* loaded from: classes.dex */
public final class TextRangeKt {
    public static final long TextRange(int r5, int r6) {
        boolean z;
        boolean z2 = true;
        if (r5 >= 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            if (r6 < 0) {
                z2 = false;
            }
            if (z2) {
                long j = (r6 & 4294967295L) | (r5 << 32);
                int r0 = TextRange.$r8$clinit;
                return j;
            }
            throw new IllegalArgumentException(("end cannot be negative. [start: " + r5 + ", end: " + r6 + ']').toString());
        }
        throw new IllegalArgumentException(("start cannot be negative. [start: " + r5 + ", end: " + r6 + ']').toString());
    }

    /* renamed from: coerceIn-8ffj60Q, reason: not valid java name */
    public static final long m528coerceIn8ffj60Q(long j, int r6) {
        int r0 = TextRange.$r8$clinit;
        int r02 = (int) (j >> 32);
        int coerceIn = RangesKt___RangesKt.coerceIn(r02, 0, r6);
        int coerceIn2 = RangesKt___RangesKt.coerceIn(TextRange.m523getEndimpl(j), 0, r6);
        if (coerceIn == r02 && coerceIn2 == TextRange.m523getEndimpl(j)) {
            return j;
        }
        return TextRange(coerceIn, coerceIn2);
    }
}
