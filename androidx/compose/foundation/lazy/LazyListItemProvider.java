package androidx.compose.foundation.lazy;

import androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider;
import androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap;

/* compiled from: LazyListItemProvider.kt */
/* loaded from: classes.dex */
public interface LazyListItemProvider extends LazyLayoutItemProvider {
    void getHeaderIndexes();

    LazyItemScopeImpl getItemScope();

    LazyLayoutKeyIndexMap getKeyIndexMap();
}
