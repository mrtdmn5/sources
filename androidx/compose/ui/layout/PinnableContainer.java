package androidx.compose.ui.layout;

import androidx.compose.foundation.lazy.layout.LazyLayoutPinnableItem;

/* compiled from: PinnableContainer.kt */
/* loaded from: classes.dex */
public interface PinnableContainer {

    /* compiled from: PinnableContainer.kt */
    /* loaded from: classes.dex */
    public interface PinnedHandle {
        void release();
    }

    LazyLayoutPinnableItem pin();
}
