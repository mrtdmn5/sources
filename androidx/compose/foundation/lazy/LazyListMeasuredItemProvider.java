package androidx.compose.foundation.lazy;

import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LazyListMeasuredItemProvider.kt */
/* loaded from: classes.dex */
public abstract class LazyListMeasuredItemProvider {
    public final long childConstraints;
    public final LazyListItemProvider itemProvider;
    public final LazyLayoutMeasureScope measureScope;

    public LazyListMeasuredItemProvider(long j, boolean z, LazyListItemProvider lazyListItemProvider, LazyLayoutMeasureScope measureScope) {
        int r6;
        Intrinsics.checkNotNullParameter(measureScope, "measureScope");
        this.itemProvider = lazyListItemProvider;
        this.measureScope = measureScope;
        if (z) {
            r6 = Constraints.m565getMaxWidthimpl(j);
        } else {
            r6 = Integer.MAX_VALUE;
        }
        this.childConstraints = ConstraintsKt.Constraints$default(r6, z ? Integer.MAX_VALUE : Constraints.m564getMaxHeightimpl(j), 5);
    }

    public abstract LazyListMeasuredItem createItem(int r1, Object obj, Object obj2, List<? extends Placeable> list);

    public final LazyListMeasuredItem getAndMeasure(int r6) {
        LazyListItemProvider lazyListItemProvider = this.itemProvider;
        return createItem(r6, lazyListItemProvider.getKey(r6), lazyListItemProvider.getContentType(r6), this.measureScope.mo102measure0kLqBqw(r6, this.childConstraints));
    }
}
