package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.runtime.State;
import androidx.compose.runtime.StructuralEqualityPolicy;
import com.google.common.collect.Platform;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: LazyLayoutNearestRangeState.kt */
/* loaded from: classes.dex */
public final class LazyLayoutNearestRangeState implements State<IntRange> {
    public int lastFirstVisibleItem;
    public final ParcelableSnapshotMutableState value$delegate;

    /* compiled from: LazyLayoutNearestRangeState.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
    }

    static {
        new Companion();
    }

    public LazyLayoutNearestRangeState(int r4) {
        int r0 = (r4 / 30) * 30;
        this.value$delegate = Platform.mutableStateOf(RangesKt___RangesKt.until(Math.max(r0 - 100, 0), r0 + 30 + 100), StructuralEqualityPolicy.INSTANCE);
        this.lastFirstVisibleItem = r4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.runtime.State
    public final IntRange getValue() {
        return (IntRange) this.value$delegate.getValue();
    }

    public final void update(int r3) {
        if (r3 != this.lastFirstVisibleItem) {
            this.lastFirstVisibleItem = r3;
            int r32 = (r3 / 30) * 30;
            this.value$delegate.setValue(RangesKt___RangesKt.until(Math.max(r32 - 100, 0), r32 + 30 + 100));
        }
    }
}
