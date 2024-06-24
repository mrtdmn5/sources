package kotlin.collections;

import java.util.Collections;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MapsJVM.kt */
/* loaded from: classes.dex */
public class MapsKt__MapsJVMKt extends MapsKt__MapWithDefaultKt {
    public static final int mapCapacity(int r1) {
        if (r1 >= 0) {
            if (r1 < 3) {
                return r1 + 1;
            }
            if (r1 < 1073741824) {
                return (int) ((r1 / 0.75f) + 1.0f);
            }
            return Integer.MAX_VALUE;
        }
        return r1;
    }

    public static final <K, V> Map<K, V> mapOf(Pair<? extends K, ? extends V> pair) {
        Intrinsics.checkNotNullParameter(pair, "pair");
        Map<K, V> singletonMap = Collections.singletonMap(pair.first, pair.second);
        Intrinsics.checkNotNullExpressionValue(singletonMap, "singletonMap(...)");
        return singletonMap;
    }

    public static final <K, V> Map<K, V> toSingletonMap(Map<? extends K, ? extends V> map) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Map.Entry<? extends K, ? extends V> next = map.entrySet().iterator().next();
        Map<K, V> singletonMap = Collections.singletonMap(next.getKey(), next.getValue());
        Intrinsics.checkNotNullExpressionValue(singletonMap, "with(...)");
        return singletonMap;
    }
}
