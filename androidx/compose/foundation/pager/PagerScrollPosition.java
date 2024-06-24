package androidx.compose.foundation.pager;

import androidx.compose.foundation.lazy.layout.LazyLayoutNearestRangeState;
import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
import kotlin.text.UStringsKt;

/* compiled from: PagerScrollPosition.kt */
/* loaded from: classes.dex */
public final class PagerScrollPosition {
    public final ParcelableSnapshotMutableIntState currentPage$delegate;
    public final ParcelableSnapshotMutableIntState firstVisiblePage$delegate;
    public boolean hadFirstNotEmptyLayout;
    public Object lastKnownFirstPageKey;
    public final LazyLayoutNearestRangeState nearestRangeState;
    public final ParcelableSnapshotMutableIntState scrollOffset$delegate = UStringsKt.mutableIntStateOf(0);

    public PagerScrollPosition(int r2) {
        this.firstVisiblePage$delegate = UStringsKt.mutableIntStateOf(r2);
        this.currentPage$delegate = UStringsKt.mutableIntStateOf(r2);
        this.nearestRangeState = new LazyLayoutNearestRangeState(r2);
    }

    public final void update(int r3, int r4) {
        boolean z;
        if (r3 >= 0.0f) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            this.firstVisiblePage$delegate.setIntValue(r3);
            this.nearestRangeState.update(r3);
            this.scrollOffset$delegate.setIntValue(r4);
        } else {
            throw new IllegalArgumentException(("Index should be non-negative (" + r3 + ')').toString());
        }
    }
}
