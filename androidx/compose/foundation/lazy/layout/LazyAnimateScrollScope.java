package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.ui.unit.Density;

/* compiled from: LazyAnimateScroll.kt */
/* loaded from: classes.dex */
public interface LazyAnimateScrollScope {
    float expectedDistanceTo(int r1, int r2);

    Density getDensity();

    int getFirstVisibleItemIndex();

    int getFirstVisibleItemScrollOffset();

    int getItemCount();

    int getLastVisibleItemIndex();

    int getNumOfItemsForTeleport();

    Integer getTargetItemOffset(int r1);

    void snapToItem(ScrollScope scrollScope, int r2, int r3);
}
