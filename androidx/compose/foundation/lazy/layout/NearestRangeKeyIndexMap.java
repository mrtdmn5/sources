package androidx.compose.foundation.lazy.layout;

import java.util.HashMap;
import java.util.Map;
import kotlin.collections.EmptyMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* compiled from: LazyLayoutKeyIndexMap.kt */
/* loaded from: classes.dex */
public final class NearestRangeKeyIndexMap implements LazyLayoutKeyIndexMap {
    public final Object[] keys;
    public final int keysStartIndex;
    public final Map<Object, Integer> map;

    public NearestRangeKeyIndexMap(IntRange nearestRange, LazyLayoutIntervalContent<?> intervalContent) {
        boolean z;
        Intrinsics.checkNotNullParameter(nearestRange, "nearestRange");
        Intrinsics.checkNotNullParameter(intervalContent, "intervalContent");
        MutableIntervalList intervals$1 = intervalContent.getIntervals$1();
        int r2 = nearestRange.first;
        if (r2 >= 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            int min = Math.min(nearestRange.last, intervals$1.size - 1);
            if (min < r2) {
                this.map = EmptyMap.INSTANCE;
                this.keys = new Object[0];
                this.keysStartIndex = 0;
                return;
            } else {
                this.keys = new Object[(min - r2) + 1];
                this.keysStartIndex = r2;
                HashMap hashMap = new HashMap();
                intervals$1.forEach(r2, min, new NearestRangeKeyIndexMap$1$1(r2, min, hashMap, this));
                this.map = hashMap;
                return;
            }
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap
    public final int getIndex(Object key) {
        Intrinsics.checkNotNullParameter(key, "key");
        Integer num = this.map.get(key);
        if (num == null) {
            num = -1;
        }
        return num.intValue();
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap
    public final Object getKey(int r3) {
        int r32 = r3 - this.keysStartIndex;
        if (r32 >= 0) {
            Object[] objArr = this.keys;
            Intrinsics.checkNotNullParameter(objArr, "<this>");
            if (r32 <= objArr.length - 1) {
                return objArr[r32];
            }
        }
        return null;
    }
}
