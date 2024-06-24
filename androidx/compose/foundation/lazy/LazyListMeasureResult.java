package androidx.compose.foundation.lazy;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.MeasureResult;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LazyListMeasureResult.kt */
/* loaded from: classes.dex */
public final class LazyListMeasureResult implements LazyListLayoutInfo, MeasureResult {
    public final /* synthetic */ MeasureResult $$delegate_0;
    public final boolean canScrollForward;
    public final float consumedScroll;
    public final LazyListMeasuredItem firstVisibleItem;
    public final int firstVisibleItemScrollOffset;
    public final int mainAxisItemSpacing;
    public final int totalItemsCount;
    public final List<LazyListItemInfo> visibleItemsInfo;

    public LazyListMeasureResult(LazyListMeasuredItem lazyListMeasuredItem, int r3, boolean z, float f, MeasureResult measureResult, List list, int r8, Orientation orientation, int r10) {
        Intrinsics.checkNotNullParameter(measureResult, "measureResult");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        this.firstVisibleItem = lazyListMeasuredItem;
        this.firstVisibleItemScrollOffset = r3;
        this.canScrollForward = z;
        this.consumedScroll = f;
        this.visibleItemsInfo = list;
        this.totalItemsCount = r8;
        this.mainAxisItemSpacing = r10;
        this.$$delegate_0 = measureResult;
    }

    @Override // androidx.compose.ui.layout.MeasureResult
    public final Map<AlignmentLine, Integer> getAlignmentLines() {
        return this.$$delegate_0.getAlignmentLines();
    }

    @Override // androidx.compose.ui.layout.MeasureResult
    public final int getHeight() {
        return this.$$delegate_0.getHeight();
    }

    @Override // androidx.compose.foundation.lazy.LazyListLayoutInfo
    public final int getMainAxisItemSpacing() {
        return this.mainAxisItemSpacing;
    }

    @Override // androidx.compose.foundation.lazy.LazyListLayoutInfo
    public final int getTotalItemsCount() {
        return this.totalItemsCount;
    }

    @Override // androidx.compose.foundation.lazy.LazyListLayoutInfo
    public final List<LazyListItemInfo> getVisibleItemsInfo() {
        return this.visibleItemsInfo;
    }

    @Override // androidx.compose.ui.layout.MeasureResult
    public final int getWidth() {
        return this.$$delegate_0.getWidth();
    }

    @Override // androidx.compose.ui.layout.MeasureResult
    public final void placeChildren() {
        this.$$delegate_0.placeChildren();
    }
}
