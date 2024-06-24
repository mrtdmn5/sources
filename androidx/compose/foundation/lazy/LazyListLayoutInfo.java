package androidx.compose.foundation.lazy;

import java.util.List;

/* compiled from: LazyListLayoutInfo.kt */
/* loaded from: classes.dex */
public interface LazyListLayoutInfo {
    default int getMainAxisItemSpacing() {
        return 0;
    }

    int getTotalItemsCount();

    List<LazyListItemInfo> getVisibleItemsInfo();
}
