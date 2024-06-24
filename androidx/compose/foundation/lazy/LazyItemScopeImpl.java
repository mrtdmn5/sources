package androidx.compose.foundation.lazy;

import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
import kotlin.text.UStringsKt;

/* compiled from: LazyItemScopeImpl.kt */
/* loaded from: classes.dex */
public final class LazyItemScopeImpl implements LazyItemScope {
    public final ParcelableSnapshotMutableIntState maxWidthState = UStringsKt.mutableIntStateOf(Integer.MAX_VALUE);
    public final ParcelableSnapshotMutableIntState maxHeightState = UStringsKt.mutableIntStateOf(Integer.MAX_VALUE);
}
