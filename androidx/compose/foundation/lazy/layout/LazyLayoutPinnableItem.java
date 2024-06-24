package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.lazy.layout.LazyLayoutPinnedItemList;
import androidx.compose.runtime.ParcelableSnapshotMutableIntState;
import androidx.compose.runtime.ParcelableSnapshotMutableState;
import androidx.compose.ui.layout.PinnableContainer;
import com.google.common.collect.Platform;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.UStringsKt;

/* compiled from: LazyLayoutPinnableItem.kt */
/* loaded from: classes.dex */
public final class LazyLayoutPinnableItem implements PinnableContainer, PinnableContainer.PinnedHandle, LazyLayoutPinnedItemList.PinnedItem {
    public final ParcelableSnapshotMutableState _parentPinnableContainer$delegate;
    public final ParcelableSnapshotMutableIntState index$delegate;
    public final Object key;
    public final ParcelableSnapshotMutableState parentHandle$delegate;
    public final LazyLayoutPinnedItemList pinnedItemList;
    public final ParcelableSnapshotMutableIntState pinsCount$delegate;

    public LazyLayoutPinnableItem(Object obj, LazyLayoutPinnedItemList pinnedItemList) {
        Intrinsics.checkNotNullParameter(pinnedItemList, "pinnedItemList");
        this.key = obj;
        this.pinnedItemList = pinnedItemList;
        this.index$delegate = UStringsKt.mutableIntStateOf(-1);
        this.pinsCount$delegate = UStringsKt.mutableIntStateOf(0);
        this.parentHandle$delegate = Platform.mutableStateOf$default(null);
        this._parentPinnableContainer$delegate = Platform.mutableStateOf$default(null);
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutPinnedItemList.PinnedItem
    public final int getIndex() {
        return this.index$delegate.getIntValue();
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutPinnedItemList.PinnedItem
    public final Object getKey() {
        return this.key;
    }

    public final int getPinsCount() {
        return this.pinsCount$delegate.getIntValue();
    }

    @Override // androidx.compose.ui.layout.PinnableContainer
    public final LazyLayoutPinnableItem pin() {
        LazyLayoutPinnableItem lazyLayoutPinnableItem;
        if (getPinsCount() == 0) {
            LazyLayoutPinnedItemList lazyLayoutPinnedItemList = this.pinnedItemList;
            lazyLayoutPinnedItemList.getClass();
            lazyLayoutPinnedItemList.items.add(this);
            PinnableContainer pinnableContainer = (PinnableContainer) this._parentPinnableContainer$delegate.getValue();
            if (pinnableContainer != null) {
                lazyLayoutPinnableItem = pinnableContainer.pin();
            } else {
                lazyLayoutPinnableItem = null;
            }
            this.parentHandle$delegate.setValue(lazyLayoutPinnableItem);
        }
        this.pinsCount$delegate.setIntValue(getPinsCount() + 1);
        return this;
    }

    @Override // androidx.compose.ui.layout.PinnableContainer.PinnedHandle
    public final void release() {
        boolean z;
        if (getPinsCount() > 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            this.pinsCount$delegate.setIntValue(getPinsCount() - 1);
            if (getPinsCount() == 0) {
                LazyLayoutPinnedItemList lazyLayoutPinnedItemList = this.pinnedItemList;
                lazyLayoutPinnedItemList.getClass();
                lazyLayoutPinnedItemList.items.remove(this);
                ParcelableSnapshotMutableState parcelableSnapshotMutableState = this.parentHandle$delegate;
                PinnableContainer.PinnedHandle pinnedHandle = (PinnableContainer.PinnedHandle) parcelableSnapshotMutableState.getValue();
                if (pinnedHandle != null) {
                    pinnedHandle.release();
                }
                parcelableSnapshotMutableState.setValue(null);
                return;
            }
            return;
        }
        throw new IllegalStateException("Release should only be called once".toString());
    }
}
