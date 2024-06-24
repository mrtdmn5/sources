package aws.smithy.kotlin.runtime.util;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ValuesMap.kt */
/* loaded from: classes.dex */
public final class ValuesMapKt {
    public static final LinkedHashMap deepCopy(Map map) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt__MapsJVMKt.mapCapacity(map.size()));
        for (Map.Entry entry : map.entrySet()) {
            linkedHashMap.put(entry.getKey(), CollectionsKt___CollectionsKt.toMutableList((Collection) entry.getValue()));
        }
        return linkedHashMap;
    }
}
