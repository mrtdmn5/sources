package androidx.compose.foundation.lazy;

import androidx.compose.foundation.lazy.layout.LazyLayoutNearestRangeState;
import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
import kotlin.text.UStringsKt;

/* compiled from: LazyListScrollPosition.kt */
/* loaded from: classes.dex */
public final class LazyListScrollPosition {
    public boolean hadFirstNotEmptyLayout;
    public final ParcelableSnapshotMutableIntState index$delegate;
    public Object lastKnownFirstItemKey;
    public final LazyLayoutNearestRangeState nearestRangeState;
    public final ParcelableSnapshotMutableIntState scrollOffset$delegate;

    public LazyListScrollPosition(int r2, int r3) {
        this.index$delegate = UStringsKt.mutableIntStateOf(r2);
        this.scrollOffset$delegate = UStringsKt.mutableIntStateOf(r3);
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
            this.index$delegate.setIntValue(r3);
            this.nearestRangeState.update(r3);
            this.scrollOffset$delegate.setIntValue(r4);
        } else {
            throw new IllegalArgumentException(("Index should be non-negative (" + r3 + ')').toString());
        }
    }
}
