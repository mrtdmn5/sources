package kotlin.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IteratorsJVM.kt */
/* loaded from: classes.dex */
public class CollectionsKt__IteratorsJVMKt extends CollectionsKt__CollectionsKt {
    public static final int collectionSizeOrDefault(Iterable iterable, int r2) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        if (iterable instanceof Collection) {
            return ((Collection) iterable).size();
        }
        return r2;
    }

    public static final ArrayList flatten(Iterable iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        ArrayList arrayList = new ArrayList();
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            CollectionsKt__ReversedViewsKt.addAll((Iterable) it.next(), arrayList);
        }
        return arrayList;
    }
}
