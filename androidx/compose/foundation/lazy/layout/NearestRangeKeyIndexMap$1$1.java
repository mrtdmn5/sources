package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.lazy.layout.LazyLayoutIntervalContent;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* compiled from: LazyLayoutKeyIndexMap.kt */
/* loaded from: classes.dex */
public final class NearestRangeKeyIndexMap$1$1 extends Lambda implements Function1<IntervalList$Interval<? extends LazyLayoutIntervalContent.Interval>, Unit> {
    public final /* synthetic */ int $first;
    public final /* synthetic */ int $last;
    public final /* synthetic */ HashMap<Object, Integer> $map;
    public final /* synthetic */ NearestRangeKeyIndexMap this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NearestRangeKeyIndexMap$1$1(int r1, int r2, HashMap<Object, Integer> hashMap, NearestRangeKeyIndexMap nearestRangeKeyIndexMap) {
        super(1);
        this.$first = r1;
        this.$last = r2;
        this.$map = hashMap;
        this.this$0 = nearestRangeKeyIndexMap;
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0030, code lost:            if (r3 == null) goto L7;     */
    @Override // kotlin.jvm.functions.Function1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final kotlin.Unit invoke(androidx.compose.foundation.lazy.layout.IntervalList$Interval<? extends androidx.compose.foundation.lazy.layout.LazyLayoutIntervalContent.Interval> r7) {
        /*
            r6 = this;
            androidx.compose.foundation.lazy.layout.IntervalList$Interval r7 = (androidx.compose.foundation.lazy.layout.IntervalList$Interval) r7
            java.lang.String r0 = "it"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            T r0 = r7.value
            androidx.compose.foundation.lazy.layout.LazyLayoutIntervalContent$Interval r0 = (androidx.compose.foundation.lazy.layout.LazyLayoutIntervalContent.Interval) r0
            kotlin.jvm.functions.Function1 r0 = r0.getKey()
            int r1 = r6.$first
            int r2 = r7.startIndex
            int r1 = java.lang.Math.max(r1, r2)
            int r7 = r7.size
            int r7 = r7 + r2
            int r7 = r7 + (-1)
            int r3 = r6.$last
            int r7 = java.lang.Math.min(r3, r7)
            if (r1 > r7) goto L4f
        L24:
            if (r0 == 0) goto L32
            int r3 = r1 - r2
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            java.lang.Object r3 = r0.invoke(r3)
            if (r3 != 0) goto L37
        L32:
            androidx.compose.foundation.lazy.layout.DefaultLazyKey r3 = new androidx.compose.foundation.lazy.layout.DefaultLazyKey
            r3.<init>(r1)
        L37:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r1)
            java.util.HashMap<java.lang.Object, java.lang.Integer> r5 = r6.$map
            r5.put(r3, r4)
            androidx.compose.foundation.lazy.layout.NearestRangeKeyIndexMap r4 = r6.this$0
            java.lang.Object[] r5 = r4.keys
            int r4 = r4.keysStartIndex
            int r4 = r1 - r4
            r5[r4] = r3
            if (r1 == r7) goto L4f
            int r1 = r1 + 1
            goto L24
        L4f:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.layout.NearestRangeKeyIndexMap$1$1.invoke(java.lang.Object):java.lang.Object");
    }
}
