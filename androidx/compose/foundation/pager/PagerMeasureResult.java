package androidx.compose.foundation.pager;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.unit.IntSizeKt;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PagerMeasureResult.kt */
/* loaded from: classes.dex */
public final class PagerMeasureResult implements PagerLayoutInfo, MeasureResult {
    public final /* synthetic */ MeasureResult $$delegate_0;
    public final int afterContentPadding;
    public final boolean canScrollForward;
    public final PageInfo closestPageToSnapPosition;
    public final float consumedScroll;
    public final MeasuredPage firstVisiblePage;
    public final int firstVisiblePageOffset;
    public final Orientation orientation;
    public final int pageSize;
    public final int pageSpacing;
    public final int pagesCount;
    public final int viewportStartOffset;
    public final List<PageInfo> visiblePagesInfo;

    public PagerMeasureResult(List list, int r3, int r4, int r5, int r6, Orientation orientation, int r8, float f, MeasuredPage measuredPage, MeasuredPage measuredPage2, int r12, boolean z, MeasureResult measureResult) {
        Intrinsics.checkNotNullParameter(measureResult, "measureResult");
        this.visiblePagesInfo = list;
        this.pagesCount = r3;
        this.pageSize = r4;
        this.pageSpacing = r5;
        this.afterContentPadding = r6;
        this.orientation = orientation;
        this.viewportStartOffset = r8;
        this.consumedScroll = f;
        this.firstVisiblePage = measuredPage;
        this.closestPageToSnapPosition = measuredPage2;
        this.firstVisiblePageOffset = r12;
        this.canScrollForward = z;
        this.$$delegate_0 = measureResult;
    }

    @Override // androidx.compose.foundation.pager.PagerLayoutInfo
    public final int getAfterContentPadding() {
        return this.afterContentPadding;
    }

    @Override // androidx.compose.ui.layout.MeasureResult
    public final Map<AlignmentLine, Integer> getAlignmentLines() {
        return this.$$delegate_0.getAlignmentLines();
    }

    @Override // androidx.compose.foundation.pager.PagerLayoutInfo
    public final int getBeforeContentPadding() {
        return -this.viewportStartOffset;
    }

    @Override // androidx.compose.foundation.pager.PagerLayoutInfo
    public final PageInfo getClosestPageToSnapPosition() {
        return this.closestPageToSnapPosition;
    }

    @Override // androidx.compose.ui.layout.MeasureResult
    public final int getHeight() {
        return this.$$delegate_0.getHeight();
    }

    @Override // androidx.compose.foundation.pager.PagerLayoutInfo
    public final Orientation getOrientation() {
        return this.orientation;
    }

    @Override // androidx.compose.foundation.pager.PagerLayoutInfo
    public final int getPageSize() {
        return this.pageSize;
    }

    @Override // androidx.compose.foundation.pager.PagerLayoutInfo
    public final int getPageSpacing() {
        return this.pageSpacing;
    }

    @Override // androidx.compose.foundation.pager.PagerLayoutInfo
    public final int getPagesCount() {
        return this.pagesCount;
    }

    @Override // androidx.compose.foundation.pager.PagerLayoutInfo
    /* renamed from: getViewportSize-YbymL2g */
    public final long mo106getViewportSizeYbymL2g() {
        return IntSizeKt.IntSize(getWidth(), getHeight());
    }

    @Override // androidx.compose.foundation.pager.PagerLayoutInfo
    public final List<PageInfo> getVisiblePagesInfo() {
        return this.visiblePagesInfo;
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
