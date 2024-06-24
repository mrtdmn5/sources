package androidx.compose.foundation.lazy;

import androidx.compose.foundation.gestures.Orientation;
import java.util.List;
import kotlin.collections.EmptyList;

/* compiled from: LazyListState.kt */
/* loaded from: classes.dex */
public final class EmptyLazyListLayoutInfo implements LazyListLayoutInfo {
    public static final EmptyLazyListLayoutInfo INSTANCE = new EmptyLazyListLayoutInfo();

    static {
        Orientation orientation = Orientation.Vertical;
    }

    @Override // androidx.compose.foundation.lazy.LazyListLayoutInfo
    public final int getMainAxisItemSpacing() {
        return 0;
    }

    @Override // androidx.compose.foundation.lazy.LazyListLayoutInfo
    public final int getTotalItemsCount() {
        return 0;
    }

    @Override // androidx.compose.foundation.lazy.LazyListLayoutInfo
    public final List<LazyListItemInfo> getVisibleItemsInfo() {
        return EmptyList.INSTANCE;
    }
}
