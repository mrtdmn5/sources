package androidx.compose.foundation.pager;

import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: Pager.kt */
/* loaded from: classes.dex */
public final class PagerSnapDistanceMaxPages implements PagerSnapDistance {
    public final int pagesLimit = 1;

    @Override // androidx.compose.foundation.pager.PagerSnapDistance
    public final int calculateTargetPage(int r3, int r4) {
        int r0 = this.pagesLimit;
        return RangesKt___RangesKt.coerceIn(r4, r3 - r0, r3 + r0);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof PagerSnapDistanceMaxPages)) {
            return false;
        }
        if (this.pagesLimit != ((PagerSnapDistanceMaxPages) obj).pagesLimit) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Integer.hashCode(this.pagesLimit);
    }
}
