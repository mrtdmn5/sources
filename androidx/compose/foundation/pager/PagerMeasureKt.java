package androidx.compose.foundation.pager;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.unit.LayoutDirection;

/* compiled from: PagerMeasure.kt */
/* loaded from: classes.dex */
public final class PagerMeasureKt {
    /* renamed from: getAndMeasure-SGf7dI0, reason: not valid java name */
    public static final MeasuredPage m107getAndMeasureSGf7dI0(LazyLayoutMeasureScope lazyLayoutMeasureScope, int r14, long j, PagerLazyLayoutItemProvider pagerLazyLayoutItemProvider, long j2, Orientation orientation, Alignment.Horizontal horizontal, Alignment.Vertical vertical, LayoutDirection layoutDirection, boolean z, int r25) {
        return new MeasuredPage(r14, r25, lazyLayoutMeasureScope.mo102measure0kLqBqw(r14, j), j2, pagerLazyLayoutItemProvider.getKey(r14), orientation, horizontal, vertical, layoutDirection, z);
    }
}
