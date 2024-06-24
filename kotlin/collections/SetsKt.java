package kotlin.collections;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class SetsKt extends SetsKt__SetsKt {
    public static final LinkedHashSet plus(Set set, Iterable elements) {
        Integer num;
        int size;
        Intrinsics.checkNotNullParameter(set, "<this>");
        Intrinsics.checkNotNullParameter(elements, "elements");
        if (elements instanceof Collection) {
            num = Integer.valueOf(((Collection) elements).size());
        } else {
            num = null;
        }
        if (num != null) {
            size = set.size() + num.intValue();
        } else {
            size = set.size() * 2;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(MapsKt__MapsJVMKt.mapCapacity(size));
        linkedHashSet.addAll(set);
        CollectionsKt__ReversedViewsKt.addAll(elements, linkedHashSet);
        return linkedHashSet;
    }
}
