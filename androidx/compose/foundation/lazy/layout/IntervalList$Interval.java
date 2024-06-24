package androidx.compose.foundation.lazy.layout;

import androidx.appcompat.view.menu.SubMenuBuilder$$ExternalSyntheticOutline0;
import androidx.compose.foundation.lazy.layout.LazyLayoutIntervalContent;

/* compiled from: IntervalList.kt */
/* loaded from: classes.dex */
public final class IntervalList$Interval<T> {
    public final int size;
    public final int startIndex;
    public final T value;

    /* JADX WARN: Multi-variable type inference failed */
    public IntervalList$Interval(int r3, int r4, LazyLayoutIntervalContent.Interval interval) {
        boolean z;
        this.startIndex = r3;
        this.size = r4;
        this.value = interval;
        if (r3 >= 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            if (r4 > 0) {
                return;
            } else {
                throw new IllegalArgumentException(SubMenuBuilder$$ExternalSyntheticOutline0.m("size should be >0, but was ", r4).toString());
            }
        }
        throw new IllegalArgumentException(SubMenuBuilder$$ExternalSyntheticOutline0.m("startIndex should be >= 0, but was ", r3).toString());
    }
}
