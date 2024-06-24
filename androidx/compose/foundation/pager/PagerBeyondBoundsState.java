package androidx.compose.foundation.pager;

import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsState;
import androidx.compose.ui.layout.Remeasurement;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PagerBeyondBoundsModifier.kt */
/* loaded from: classes.dex */
public final class PagerBeyondBoundsState implements LazyLayoutBeyondBoundsState {
    public final int beyondBoundsPageCount;
    public final PagerState state;

    public PagerBeyondBoundsState(PagerState state, int r3) {
        Intrinsics.checkNotNullParameter(state, "state");
        this.state = state;
        this.beyondBoundsPageCount = r3;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsState
    public final int getFirstPlacedIndex() {
        return Math.max(0, this.state.getFirstVisiblePage$foundation_release() - this.beyondBoundsPageCount);
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsState
    public final boolean getHasVisibleItems() {
        return !this.state.getLayoutInfo$foundation_release().getVisiblePagesInfo().isEmpty();
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsState
    public final int getItemCount() {
        return this.state.getLayoutInfo$foundation_release().getPagesCount();
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsState
    public final int getLastPlacedIndex() {
        return Math.min(getItemCount() - 1, ((PageInfo) CollectionsKt___CollectionsKt.last(this.state.getLayoutInfo$foundation_release().getVisiblePagesInfo())).getIndex() + this.beyondBoundsPageCount);
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsState
    public final void remeasure() {
        Remeasurement remeasurement = (Remeasurement) this.state.remeasurement$delegate.getValue();
        if (remeasurement != null) {
            remeasurement.forceRemeasure();
        }
    }
}
