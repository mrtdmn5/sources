package androidx.compose.foundation.lazy;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.lazy.layout.LazyAnimateScrollKt$animateScrollToItem$2;
import androidx.compose.foundation.lazy.layout.LazyAnimateScrollScope;
import androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap;
import androidx.compose.ui.layout.Remeasurement;
import androidx.compose.ui.unit.Density;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LazyListAnimateScrollScope.kt */
/* loaded from: classes.dex */
public final class LazyListAnimateScrollScope implements LazyAnimateScrollScope {
    public final int numOfItemsForTeleport;
    public final LazyListState state;

    public LazyListAnimateScrollScope(LazyListState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        this.state = state;
        this.numOfItemsForTeleport = 100;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyAnimateScrollScope
    public final float expectedDistanceTo(int r7, int r8) {
        LazyListLayoutInfo layoutInfo = this.state.getLayoutInfo();
        List<LazyListItemInfo> visibleItemsInfo = layoutInfo.getVisibleItemsInfo();
        int size = visibleItemsInfo.size();
        int r4 = 0;
        for (int r3 = 0; r3 < size; r3++) {
            r4 += visibleItemsInfo.get(r3).getSize();
        }
        int mainAxisItemSpacing = layoutInfo.getMainAxisItemSpacing() + (r4 / visibleItemsInfo.size());
        int firstVisibleItemIndex = r7 - getFirstVisibleItemIndex();
        int min = Math.min(Math.abs(r8), mainAxisItemSpacing);
        if (r8 < 0) {
            min *= -1;
        }
        return ((mainAxisItemSpacing * firstVisibleItemIndex) + min) - getFirstVisibleItemScrollOffset();
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyAnimateScrollScope
    public final Density getDensity() {
        return this.state.density;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyAnimateScrollScope
    public final int getFirstVisibleItemIndex() {
        return this.state.getFirstVisibleItemIndex();
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyAnimateScrollScope
    public final int getFirstVisibleItemScrollOffset() {
        return this.state.getFirstVisibleItemScrollOffset();
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyAnimateScrollScope
    public final int getItemCount() {
        return this.state.getLayoutInfo().getTotalItemsCount();
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyAnimateScrollScope
    public final int getLastVisibleItemIndex() {
        LazyListItemInfo lazyListItemInfo = (LazyListItemInfo) CollectionsKt___CollectionsKt.lastOrNull(this.state.getLayoutInfo().getVisibleItemsInfo());
        if (lazyListItemInfo != null) {
            return lazyListItemInfo.getIndex();
        }
        return 0;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyAnimateScrollScope
    public final int getNumOfItemsForTeleport() {
        return this.numOfItemsForTeleport;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyAnimateScrollScope
    public final Integer getTargetItemOffset(int r8) {
        LazyListItemInfo lazyListItemInfo;
        boolean z;
        List<LazyListItemInfo> visibleItemsInfo = this.state.getLayoutInfo().getVisibleItemsInfo();
        int size = visibleItemsInfo.size();
        int r3 = 0;
        while (true) {
            if (r3 < size) {
                lazyListItemInfo = visibleItemsInfo.get(r3);
                if (lazyListItemInfo.getIndex() == r8) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    break;
                }
                r3++;
            } else {
                lazyListItemInfo = null;
                break;
            }
        }
        LazyListItemInfo lazyListItemInfo2 = lazyListItemInfo;
        if (lazyListItemInfo2 == null) {
            return null;
        }
        return Integer.valueOf(lazyListItemInfo2.getOffset());
    }

    public final Object scroll(LazyAnimateScrollKt$animateScrollToItem$2 lazyAnimateScrollKt$animateScrollToItem$2, Continuation continuation) {
        Object scroll;
        scroll = this.state.scroll(MutatePriority.Default, lazyAnimateScrollKt$animateScrollToItem$2, continuation);
        if (scroll == CoroutineSingletons.COROUTINE_SUSPENDED) {
            return scroll;
        }
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyAnimateScrollScope
    public final void snapToItem(ScrollScope scrollScope, int r3, int r4) {
        Intrinsics.checkNotNullParameter(scrollScope, "<this>");
        LazyListState lazyListState = this.state;
        LazyListScrollPosition lazyListScrollPosition = lazyListState.scrollPosition;
        lazyListScrollPosition.update(r3, r4);
        lazyListScrollPosition.lastKnownFirstItemKey = null;
        LazyListItemPlacementAnimator lazyListItemPlacementAnimator = lazyListState.placementAnimator;
        lazyListItemPlacementAnimator.activeKeys.clear();
        lazyListItemPlacementAnimator.keyIndexMap = LazyLayoutKeyIndexMap.Empty.$$INSTANCE;
        lazyListItemPlacementAnimator.firstVisibleIndex = -1;
        Remeasurement remeasurement = lazyListState.remeasurement;
        if (remeasurement != null) {
            remeasurement.forceRemeasure();
        }
    }
}
